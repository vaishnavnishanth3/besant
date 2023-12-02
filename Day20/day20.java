import java.util.*;

class Myclass extends Thread
{
    public void run()
    {
        int j;
        for (j=1;j<=5;++j);
        {
            System.out.println("Display!!");
        }
    }
}

public class day20
{
    public static void main (String [] args)
    {
        ArrayList <Object> a1 = new ArrayList<>();
        System.out.println(a1);
        a1.add(120);
        a1.add(300);
        a1.add(88);
        a1.add("String");
        a1.add(3.247f);
        System.out.println(a1);
        System.out.println(a1.size()); 
        System.out.println(a1.get(4));
        a1.set(1,"One");
        System.out.println(a1);

        LinkedList <Object> a2 = new LinkedList<>();
        System.out.println(a2);
        a2.add(876);
        a2.add(364);
        a2.add(249);
        System.out.println(a2.get(2));
        System.out.println(a2);
        a2.set(0,"Besant");
        a2.addFirst("First");
        System.out.println(a2);
        System.out.println(a2.peek());
        System.out.println(a2.remove());
        System.out.println(a2.peek());

        Stack <Object> s1 = new Stack<>();
        System.out.println(s1);
        s1.add("C");
        s1.add("Python");
        s1.add("Java");
        System.out.println(s1);
        System.out.println(s1.peek());
        System.out.println(s1.pop());
        System.out.println(s1);

        HashSet <Object> h1 = new HashSet<>();
        h1.add(1200);
        h1.add(856);
        h1.add("Bool");
        System.out.println(h1);

        LinkedHashSet <Object> l1 = new LinkedHashSet<>();
        l1.add(1200);
        l1.add(2000);
        l1.add(3000);
        System.out.println(l1);

        HashMap <Object,Object> h2 = new HashMap<>();
        h2.put(101,"C");
        h2.put(102,"Python");
        h2.put(103,"Java");
        System.out.println(h2);

        TreeMap <Object,Object> t1 = new TreeMap<>();
        t1.put(1,"Setting");
        System.out.println(t1);

        Myclass m1 = new Myclass();
        m1.start();
    }
}

/*
 * Framework:
 * Collection Stores group of objects.
 * Framework is a collection of classes and interface
 * 
 * Types:
 * 1) List: collection of values
 * a) Array list: Similar to array, default class.
 * Array --> collection of values with same datatype, fixed size.
 * Array list --> collection of an values with different datatype, no fixed sized.
 *  Syntax:
 *  ArrayList  var = new ArrayList <>();
 * 
 * b) Linked list:
 * Element linked with the next element
 * Data can be added at either front or back.
 * peak() returns the head value in a linked list.
 * 
 * 2) Queue: 
 * First in --> First Out. 
 * 
 * 3) stack:
 *  First in --> Last Out.
 * 
 * 4) set:
 * Unordered Collection of Values:
 * Types:
 * a) Hashset
 *  Syntax:
 * Hashset var = new HashSet<>();
 * 
 * b) LinkedHashset:
 * Returns the value in input order
 * 
 * c) TreeSet
 * Returns the value in Ascending order
 * 
 * 5) Map:
 * We use them as Key and Values:
 * 
 * Types:
 * a) HashMap:
 * Stored as mapped 
 * 
 * b) LinkedHashMap:
 * objects are linked together
 * 
 * c) TreeMap:
 * Syntax:
 * TreeMap obj = new Treemap<>();
 * 
 * MultiThreading:
 * Thread --> Light weight process
 * Doing Multiple Task in a single Program
 * 
 * Ex:
 * Money Transaction
 * Video game playing
 * 
 * Methods:
 * 1) Start
 * 2) run
 * 3) sleep
 * 4) getName
 * 5) setName
 * 6) getId
 * 7) join
 * 
 * priority:
 * 1) MIN_PRIORITY --> 1
 * 2) NORM_PRIORITY --> 5
 * 3) MAX_PRIORITY --> 10
 */