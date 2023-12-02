public class day18_mn 
{
    public static void main (String [] args)
    {
        day18_1 a1 = new day18_1();
        a1.Add(12,3);

        day18_2 a2 = new day18_2();
        a2.concat("String1", "String2");

        day18_3 a3 = new day18_3();
        a3.Rarea(12, 15);
    }
}

 /*
 * Packages:
 * It is a collection of subopackages, classes, Interfaces
 * 1) Predefined Packages:
 * Pre-defined by java library
 * 2) user defined Packages:
 * definde by user.
 * Types:
 * 1) import java.classname
 * 2) import java.*
 * 
 * Access Specifiers:
 * 1) public
 * 2) private --> to be used within a class
 * 3) protected --> to be used within a package
 * 4) default
 * 
 */