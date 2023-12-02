//day13
import java.util.Scanner;
public class day13
{
    public static void main(String[] args)     
    {
        int x,y;
        try (Scanner sc = new Scanner (System.in)) 
        {
            System.out.println("Executing Java main method");
            System.out.print("Enter x: ");x = sc.nextInt();
            System.out.print("Enter y: ");y = sc.nextInt();
            besant1();
            add(x,y);
        }
    }

    public static void besant1()
    {
        System.out.println("besant1 is called");
    }

    public static void add(int a, int b)
    {
        System.out.println(a+b);
    }
}

/*
 * Syntax:
 * public static void main(String[] args)
 * public static datatype method_name(list_of_arg)
 * {
 *  // statements
 * }
 * 
 */
 