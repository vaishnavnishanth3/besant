public class day15
{
    public static void main (String [] args)
    {
        Demo de = new Demo();
        Vehicle ve = new Vehicle();
        Bike bi = new Bike();
        SBI ba = new SBI();
        de.function1();
        de.function1(10);
        de.function1(2.4f);
        de.function1('X');
        ve.run();
        bi.move();
        bi.run();
        ba.interest();
    }
}

class Demo
{
    public void function1()
    {
        System.out.println("An Example");
    }
    public void function1(int a)
    {
        System.out.println(a*10);
    }
    public void function1(float a)
    {
        System.out.println(a);
    }
    public void function1(char a)
    {
        System.out.println(a);
    }
}

class Vehicle // compile time polymorphism
{
    public void run()
    {
        System.out.println("This is a vehicle class");
    }
}

class Bike extends Vehicle
{
    public void move()
    {
        System.out.println("This is a Bike Class");
    }
}

class bank
{
    public void interest()
    {
        System.out.println("0% Intrest");
    }   
}

class Axis extends bank
{
    public void interest()
    {
        System.out.println("10 %");
    }
}

class SBI extends bank
{
    public void interest()
    {
        System.out.println("15% Interest");
    }
}

abstract class Abstract
{
    public void message()
    {
        System.out.println("Enter message");
    }

    abstract public void area();

}

class Rectangle extends Abstract
{
    public void area()
    {
        int l=10,b=15;
        System.out.println(l*b);
    }
}
/*polymorphism:
 * poly--> many
 * morphism --> forms(or)ways
 * types:
 * 1) compile time polymorphism (or) method overloading:
 * --> Same method name but different(or)  method overloading
 * --> it implements a with class
 * types:
 * same data types with number of arguements
 * 2) run time polymorphism (or) method Overriding
 * 
 * inheritance:
 * classname1 extends classname2
 * {
 *  
 * }
 * 
 * Data Abstraction -- it hides internal details and show only the functionality
 * types:
 * Abstraction --> Abstract and non-Abstract method
 * a) Abstract class
 * syntax:
 * abstract class classname
 * {
 * 
 * }
 * b) Abstract method
 * syntax:
 * abstract public class void method_name();
 * 
 * interface --> Abstract method only
 * 
 *
 */