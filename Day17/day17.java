class Employee
{
    int id; // Instance Variable
    String name, dept; // Instance Variable
    Employee(int id, String name, String dept)
    {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }
    public void display()
    {
        System.out.println(id+" "+name+" "+dept+" ");
    }
}

class Person
{
    public void eat()
    {
        System.out.println("Eating...");
        this.sleep(); // (or) sleep()
        this.walk();  // (or) walk()
    }

    public void sleep()
    {
        System.out.println("Sleeping...");
    }

    public void walk()
    {
        System.out.println("Walking");
    }
}

class Sample1
{
    String color = "Red";
}

class Sample2 extends Sample1
{
    String color = "Green";
    public void prclr()
    {
        System.out.println(color);
        System.out.println(super.color);
    }
}

class Sample3
{
    public void a()
    {
        System.out.println("This is A method in Sample3");
    }
}

class Sample4 extends Sample3
{
    public void a()
    {
        System.out.println("This is A method in Sammple4");
        super.a();
    }
    public void b()
    {
        System.out.println("This is B method in Sample4");
    }
    public void c()
    {
        System.out.println("This is C method in Sample4");
    }
}

class Management 
{
    Management()
    {
        System.out.println("Management Class");
    }
}

class Department extends Management
{
    Department()
    {
        super();
        System.out.println("Department Class");
    }
}

class test 
{
    final int min = 1; // direct initial|
    int max, normal;

    test(int normal)
    {
        this.normal = normal;
        max = 100;
    }

    public void print_det()
    {
        System.out.println(min+" "+max+" "+normal);
    }

}

class Eagle
{
    private int id;
    private Float Salary;
    private String Name;

    public String getName()
    {
        return Name;
    }

    public void SetName(String Name)
    {
        this.Name = Name;
    }
    
    public int getId()
    {
        return id;
    }

    public void SetId (int id)
    {
        this.id = id;
    }

    public float getSalary()
    {
        return Salary;
    }

    public void SetSalary(float Salary)
    {
        this.Salary = Salary;
    }
}

public class day17
{
    public static void main (String [] args)
    {
        Employee e1 = new Employee(0001,"Name1","Dept1");
        e1.display(); 

        Person p1 = new Person();
        p1.eat();
        p1.sleep();
        p1.walk();

        Sample2 s2 = new Sample2();
        s2.prclr();

        Sample4 s4 = new Sample4();
        s4.a();
        s4.b();
        s4.c();

        new Department();

        test t2 = new test(50);
        t2.print_det();

        Eagle e3 = new Eagle();
        e3.SetName("Name_new");
        System.out.println(e3.getName());

        e3.SetId(102);
        System.out.println(e3.getId());
    }
}

/*
 * this:
 *  It is used to represent current class Object
 *  Types:
 *  1) this(.)dot
 *      Use 'this(.)' to differentiate the paramteters
 *  2) this off()
 *      to mention a function using this
 * 
 *  Super:
 *      It is used to represent a parent class object.
 *  types:
 *  1) super variable: calling a variable super
 *  2) method: calling a function super
 *  3) Constructor: 
 *      Using super is not necessary.
 * 
 *  Final:
 *  It is a fixed value
 *  1) final variable:
 *      Cannot change the variable
 *  2) final method:
 *      Cannot change the method
 *  3) final class
 *      Cannot change the final
 * 
 * Encapsulation:
 *      Covering a data
 *  Private will be used to keep the variable inside the class
 *  get & Set method can be used to encapsulate
 */
