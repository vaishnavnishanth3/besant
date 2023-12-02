package Day5;
import java.util.Scanner;
public class day5 {
    public static void main(String[] args){
        try (Scanner sc = new Scanner (System.in)) {
            System.out.print("Enter your Name: ");
            String a=sc.nextLine();
            System.out.print("Enter your Password: ");
            String b=sc.nextLine();
            System.out.print("Enter your Gender: ");
            char c=sc.next().charAt(0);
            System.out.println("");
            System.out.print("My Name is "+a+",");
            System.out.print(" my password is "+b);
            System.out.print(" & my Gender is "+c+".");
        }
    }   
}