//Day6
import java.util.Scanner;
public class day6
{
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {
            String a; int b, c, d, e, f, g, h=10, res;
            System.out.print("Enter Your name: "); a = sc.next();
            System.out.print("Enter the first number: "); b = sc.nextInt();  b+=20;
            System.out.print("Enter Your second number: "); c = sc.nextInt(); c+=20;
            System.out.println("Hello "+a);
            System.out.println(b+" greater than "+c+"? "+(b>c));
            System.out.println("NOT of OR of b>c and c>b: "+!((b>c)||(c>b)));
            System.out.print("Enter d: "); d = sc.nextInt(); //preincrement
            System.out.println("Preincrement: "+ ++d);
            System.out.print("Enter e: "); e = sc.nextInt(); //postincrement
            System.out.println("Postincrement: "+ e++);
            System.out.print("Enter f: "); f = sc.nextInt(); //predecrement
            System.out.println("Predecrement: "+ --f);
            System.out.print("Enter g: "); g = sc.nextInt(); //postdecrementc
            System.out.println("Postdecrement: "+ g--);     
            System.out.println("The value of b & d is "+ e +" & "+ g);       
            res = (d<e)?(d):(e);
            System.out.println("The Result is "+res);
            System.out.println((h++) + (++h) * (--h)); //(10 + 12 * 11)  --> (10 + 132) --> returns 142
        }
    }
}
