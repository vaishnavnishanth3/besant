import java.util.Scanner;

public class day14 {
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            int f;
            display();
            System.out.print("Enter the number to find the factorial: ");
            f = sc.nextInt();
            System.out.println(fact(f));
        }
    }

    public static void display() {
        System.out.println("New");
    }

    public static void recursive() {
        System.out.println("This is Recursive Method");
        recursive();
    }

    public static int fact(int f) {
        if (f == 1) {
            return 1;
        } else {
            return f * fact(f - 1);
        }
    }

    static class Myclass1 {
        public void method1() {
            System.out.println("This is my method!!!");
        }
    }
    public static void newint()
    {
        Myclass1 obj = new Myclass1();
        obj.method1();

    }
}


/*OOPS
 * Object --> real world entity --> properties: State(name, place, colour) and behaviour(start, stop, drive) --> EX: car, mobile
 
 * Class:
 * Syntax:
 * class classname
 * {
 *      //Statements
 * }
 * example: 
 * class Student
 * {
 *      //sid, name, dept, course, fees
 *      login()
 *      logout()
 * }
 * 1) static method --> doesn't create an object
 * calling a method --> classname.methodname()
 * 
 * 2) Non-static method --> create any object 
 * 
 
 * Inheritance --> It is a machanism where a new class is derived from an existing class
 * Example: Mobile 
 * 1990 ---> landline mobile --> calling
 * 2000 --> keypad phone --> calling, sms sending, camera,....
 * 2010 ---> android--> callinf, sms sending, camera, network...
 
 * Polymorphism --> single action is processed by different ways
 * types:
 * compile time polymorphism
 * run time polymorphism
 * Example:
 * 12 + 3 =15
 * "12" + "3" = 123
 
 * DataAbstraction --> It hiding internal details and show only functionality
 * Example:
 * Program execution
 
 * Encapsulation --> It is a process of wrapping data into single unit
 */ 
