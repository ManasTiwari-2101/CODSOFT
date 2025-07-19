import java.util.*;
public class Task1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int g=generate();
        while (true){
            System.out.println("Enter a number between 1 to 100");
            int n=sc.nextInt();
            if(n==g){
                System.out.println("Bravo! you guessed correctly");
                break;
            }
            else if(n>g){
                System.out.println("To high ");
            }
            else{
                System.out.println("Too low");
            }
        }
    }
    public static int generate(){
        return (int)(Math.random()*100) + 1;
    }
}
