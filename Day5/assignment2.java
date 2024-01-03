/*  [  Area of triangle = (1/2)*base*height ] 
    [  Perimeter of triangle = (2*base+2*hypotenuse)]
*/

import java.util.Scanner;
import java.lang.Math;
public class assignment2 
{
    public static void main (String[] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {
            System.out.print("Enter the length of height: ");
            double height = sc.nextDouble();
            System.out.print("Enter the length of base: ");
            double base = sc.nextDouble();
            double a = (height*height)+(base*base);
            double hypotenuse = Math.sqrt(a);
            double area = (0.5)*base*height;
            double Perimeter = (2*base)+(2*hypotenuse);
            System.out.println("The Area of the triangle is "+area);
            System.out.println("The Perimeter of the triangle is "+Perimeter);
        }
    }
}
