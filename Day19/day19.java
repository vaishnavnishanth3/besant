package Day19;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class day19
{
    /**
     * @param args
     */
    public static void main(String[] args) 
    {   try (Scanner sc = new Scanner (System.in)) {
        int a=10;
        System.out.println(a/3);
        System.out.println(0/a);
        
        try 
        {
            System.out.println(a/0);
        }

        catch (ArithmeticException e1)
        {
            System.out.println(e1);
        }

        try
        {
            int arr[]=new int[5];
            arr[10]=34; 
            System.out.println(arr[10]);
        }

        catch (ArrayIndexOutOfBoundsException e2)
        {
            System.out.println(e2);
        }

        // Create Folder:
        boolean res;
        File x = new File("C:\\Users\\vaish\\Desktop\\Jav");
        res = x.exists(); // to check its existance
        System.out.println(res);
        if (res == false)
        {
            x.mkdir();
        }

        // Create a subfolder:
        boolean res1;
        File y = new File ("C:\\Users\\vaish\\Desktop\\Jav\\Jav1\\Jav2\\Jav3");
        res1 = y.exists();
        System.out.println(res1);
        if(res == false)
        {
            y.mkdirs();
        }

        // Create a file:
        boolean res2;
        File z = new File ("C:\\Users\\vaish\\Desktop\\Jav\\Jav1\\Jav2\\Jav3\\file.txt");
        res2 = z.exists();
        System.out.println(res2);
        if (res2 == false)
        {
            try
            {
                z.createNewFile();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }    
        }
        
        // To delete a file:
        // Replace z.createNewFile with z.delete

        // to write content in file:
        File g = new File ("C:\\Users\\vaish\\Desktop\\Jav\\Jav1\\Jav2\\Jav3\\file.txt");
        try
        {
            try (FileWriter fw = new FileWriter(g)) {
                System.out.println("Write the Message below: ");
                String content; content = sc.next();
                fw.write(content);
                fw.flush(); // to move the content to the file
                fw.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    }
}


/*
 * Exception Handling:
 *  It is a mechanism to handle the run time errors
 * 
 * Error:
 * Types:
 * 1) Compile Time Error
 * Ex: Syntax Error, during compiling
 * 2) Run time Error
 * Ex: During Runtime.
 * 
 * throw:
 * it is used to out the run time error
 * syntax:
 * throw new ArithmeticException(); 
 * 
 * Throws is same as the throw but it connects with the class name
 * syntax:
 * public static void demo() throws NullPointerException
 * {
 *  //Statements
 * }
 * 
 *  Files:
 *  It is a collection of Data
 * 
 * Types:
 * 1) Text File
 * 2) Binary File
 * Syntax:
 * import java.io.*;
 * File obj = new File(location);
 * 
 * Folder:
 * To create a folder:
 * 
*/
