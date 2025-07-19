import java.util.Scanner;

// Class to represent the user's bank account
class Account {
    private double balance;

    public Account() {
        this.balance = 0.0; // Initial balance is 0
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

// Class to represent the ATM machine
class ATMSystem {
    private Account account;
    private Scanner scanner;

    public ATMSystem(Account account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void startATM() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> handleCheckBalance();
                case 2 -> handleDeposit();
                case 3 -> handleWithdraw();
                case 4 -> {
                    System.out.println("Exiting... Thank you for using our ATM!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n====== Welcome to ATM Menu ======");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }

    private void handleCheckBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", account.getBalance());
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.printf("₹%.2f deposited successfully.%n", amount);
        }
    }

    private void handleWithdraw() {
        if (account.getBalance() <= 0) {
            System.out.println("You have no funds in your account. Please deposit money first.");
            return;
        }

        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        }
        // Error messages already handled in the withdraw method
    }
}

// Main class to run the program
public class Task3{
    public static void main(String[] args) {
        Account user = new Account(); // Initial balance is 0
        ATMSystem atm = new ATMSystem(user);
        atm.startATM();
    }
}
