import java.util.Scanner;

abstract class Mobile
{
    public void voicecall()
    {
        System.out.println("Voice call is available");
    }
    abstract public void camera();
    abstract public void display();
}

class Samsung
{
    public void camera()
    {
        System.out.println("75mpx");
    }
    public void display()
    {
        System.out.println("5.5inch");
    }
    public void fingerprint()
    {
        System.out.println("Available");
    }
}

class RedMi
{
    public void camera()
    {
        System.out.println("80mpx");
    }
    public void display()
    {
        System.out.println("6 inch");
    }
    public void fingerprint()
    {
        System.out.println("Available");
    }
}

interface A
{
    public void read();
}

interface B extends A
{
    public void write();
}

class Sample implements B
{
    public void read()
    {
        System.out.println("Reading");
    }
    public void write()
    {
        System.out.println("Writing");
    }
}

class Animal
{
    Animal()
    {
        System.out.println("This is Animal class");
    }
}

class Student
{   
    int sid = 0001;
    String name = "Prakash", dept = "ECE";
    Student()
    {
        System.out.println("Student ID: "+sid);
        System.out.println("Student Name: "+name);
        System.out.println("Student Department: "+dept);
    }
}

class Student1
{
    Student1(int sid, String name, String dept)
    {
        System.out.println("Student ID: "+sid);
        System.out.println("Student Name: "+name);
        System.out.println("Student Department: "+dept);
    }
    public void city(String city)
    {
        System.out.print("Student City: "+city);
    }
}

class Student2
{
    int i;
    String n,d;
    Student2(int id, String Name, String dept)
    {
        i = id;
        n = Name;
        d = dept;
    }
    public void Student_details()
    {
        System.out.println(i+" "+n+" "+d);
    }
}

class employee
{
    int i;
    String n,c;
    employee(int id, String name, String Company)
    {
        i = id;
        n = name;
        c = Company;
    }
    public void company_details()
    {
        System.out.println(i+" "+n+" "+c);
    }
}

class Employee1
{
    int i;
    String n,c;
    Employee1(int id, String name, String Company)
    {
        i = id;
        n = name;
        c = Company;
    }

    Employee1(Employee1 obj)
    {
        i = obj.i;
        n = obj.n; 
        c = obj.c;
    }

    public void company_details()
    {
        System.out.println(i+" "+n+" "+c);
    }
}

class book
{
    String bn, an;
    int p,page;
    book(String Bname, String Aname, int price)
    {
        bn = Bname; 
        an = Aname;
        p = price; 
    }
    book(String Bname, String Aname, int price, int pages)
    {
        bn = Bname;
        an = Aname;
        p = price;
        page = pages;
    }
    public void Book_details()
    {
        System.out.println(bn+" "+an+" "+page+" "+p);
    }
}

class Student3
{
    int id;
    String name, department;
    static String college = "ABC";
    Student3(int i, String n, String d)
    {
        id = i;
        name = n;
        department = d;
    }
    public void student_info()
    {
        System.out.println(id+" "+name+" "+department+" "+college);
    }
}

class Student4
{
    int id;
    String name, department;
    static String college = "ABC";
    
    public static void change()
    {
        college="XYZ";
    }

    Student4(int i, String n, String d)
    {
        id = i;
        name = n;
        department = d;
    }
    public void student_info()
    {
        System.out.println(id+" "+name+" "+department+" "+college);
    }
}

public class day16
{
    public static void main (String [] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {   String model;
            System.out.print("\nEnter your Mobile Model [Samsung | RedMi]: "); model = sc.next();
            Samsung sam = new Samsung();
            RedMi red = new RedMi();
            if (model.toLowerCase().equals("samsung"))
            {
                System.out.print("Camera: ");sam.camera();
                System.out.print("Display: ");sam.display();
                System.out.print("FingerPrint Sensor: ");sam.fingerprint();
            }
            else if (model.toLowerCase().equals("redmi"))
            {
                System.out.print("Camera: ");red.camera();
                System.out.print("Display: ");red.display();
                System.out.print("FingerPrint Sensor: ");red.fingerprint();
            }
            else
            {
                System.out.println("Invalid Option");
            }
            Sample s1 = new Sample();
            s1.read();
            s1.write();

            new Animal(); // constructor is not needed to be called just assigning will be enough
            new Student();
            
            Student1 st1 = new Student1(0002,"Ranav","CSE");
            st1.city("Chennai");
            
            Student2 st2 = new Student2(0003,"Santhosh","IT");
            st2.Student_details();
            
            employee e0 = new employee(0004, "Sathish", "TCS");
            e0.company_details();

            Employee1 e1 = new Employee1(0, "Grisper", "WIPRO");
            e1.company_details();
            Employee1 e2 = new Employee1(e1);
            e2.company_details();

            book b1 = new book("Newbook","Writer",859,547);
            b1.Book_details();

            Student3 s3 = new Student3(0005,"Name","MECH");
            s3.student_info();

            Student3 s4 = new Student3(0005,"Name","MECH");
            Student4.change();
            s4.student_info();
        } 
    }
    
    static
        {
            System.out.println("Static block -1 !");
        }
    
    static
        {
            System.out.println("Static block -2 !");
        }
} 

/*
 * Interface:
 * It is a blue print of an class object
 * It is a pure Abstraction
 * syntax:
 * interface1  interface2
 * {
 * // Statements
 * }
 * inteface1
 * {
 *  public void read();
 * }
 * interface2
 * {
 *  public void write();
 * }
 * Constructor:
 * A constructor is a Special type of a method that is used to object Initialization
 * Rules:
 * 1) class name same as Constructor name
 * 2) no return type
 * Type:
 * 1) Default Constructor:
 *  A contructor have no arguements is called as a Default Constructor
 * Syntax:
 * class classname
 * {
 *  classname();
 * }
 * 2) Parameterized Constructor:
 *  Arguments will be passed
 * 3)copy Constructor
 *  copy an already existing constructor
 * 
 * Constructor Overloading:
 *
 * keywords:
 * reserved words
 * 50 keywords
 * lowercase only
 * ex (if,else,break,while,do,for,float,int,char,String,class) 
 * 
 * programatic keywords:
 * static, this, super, final
 * static --> automatic memory management
 * types:
 * 1) static variable --> use static keyword before a variable
 * 2) static method
 * 3) static
 */
 