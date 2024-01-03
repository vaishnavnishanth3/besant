import java.util.Scanner;
public class assignment13 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner (System.in))
        {
            int year;
            System.out.print("Enter the year: "); year = sc.nextInt();
            if (year%4 == 0)
            {
                System.out.println("The Input is a Leap Year! ");
            }
            else
            {
                System.out.println("The input is not a leap Year! ");
            }
        }
    }
}
