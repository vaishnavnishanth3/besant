class Employee extends Thread
{
    public void run()
    {
        int j;
        for (j=1;j<=5;j++)
        {
            System.out.println("Run Method");
        }
    }
}

public class day21
{
    public static void main(String[] args) 
    {
        Myclass m1 = new Myclass();
        System.out.println(m1.getName());
        Myclass m2 = new Myclass();
        System.out.println(m2.getName());
        m1.setName("Customer-1");
        System.out.println(m1.getName());

        int i=100;
        Integer i2 = Integer.valueOf(i);
        System.out.println(i2);
        System.out.println(i2);
        System.out.println(i);

        int x = 300;
        System.out.println(x);
        int j;
        j=x;
        System.out.println(j);
        
    }
}

/*
 * MultiThreading:
 * Thread --> Light weight process
 * Doing Multiple Task in a single Program
 * 
 * Ex:
 * Money Transaction
 * Video game playing
 * 
 * Methods:
 * 1) Start: Parallel Process
 * 2) run: Single Process
 * 3) sleep
 * 4) getName: returnd the name of the Thread
 * 5) setName: it set the name of the thread
 * 6) getId: It returns th name of the ID
 * 7) join: To join two threads.
 * 
 * priority:
 * 1) MIN_PRIORITY --> 1
 * 2) NORM_PRIORITY --> 5
 * 3) MAX_PRIORITY --> 10
 * 
 * wrapper class:
 * it is a java provided to convert primitive datatype into object, object into primitive datatype is called a Wrapper class.
 * 
 * Primitive datatype:
 * int, float, byte, short....
 * 
 * Autoboxing:
 * It is a conversion of Primitive Datatype into its corresponding wrapper class.
 * 
 * unBoxing:
 * The UnBoxing Conversion of Primitive Datatype into its corresponding wrapper class.
 * 
 * 
 */