import java.util.Scanner;

public class assignment1
{
  public static void main(String[] args)
  {
    try(Scanner sc = new Scanner (System.in))
    { 
    System.out.print("Enter the radius of the circle: ");
    int radius= sc.nextInt();
    int pi = 22/7;
    int Area = (pi*(radius*radius));
    int Perimeter = 2*pi*radius;
    System.out.println("The Value of Area is "+Area+" sq.units");
    System.out.println("The Value of Perimeter is "+Perimeter+" units");
    }
  }
}