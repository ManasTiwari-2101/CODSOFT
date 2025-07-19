import java.util.*;
public class Task2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of subjects");
        int n=sc.nextInt();
        int[] arr= new int[n];
        int s=0;
        for(int i=0;i<arr.length;i++){
            System.out.println("Enter marks of subject");
            arr[i]=sc.nextInt();
            s=s+arr[i];
        }
        double avg=s/(n*1.0);
        if (avg>=90){
            Task2.show(s,avg,'A');
        }
        else if(avg>=80){
            Task2.show(s,avg,'B');
        }
        else if (avg>=70){
            Task2.show(s,avg,'C');
        }
        else if(avg >=60){
            Task2.show(s,avg,'D');
        }
        else{
            Task2.show(s,avg,'F');
        }
    }
    public static void show(int total,double avg,char ch){
        System.out.println("Total marks:"+total);
        System.out.println("Average percentage:"+avg);
        System.out.println("Grade:"+ch);
    }
}
