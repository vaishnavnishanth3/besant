//day11
import java.util.Scanner;
public class day11
{
    public static void main(String[] args) 
    {
        try(Scanner sc = new Scanner (System.in))
        {
            char ch[]={'B','E','S','A','N','T'}; String name1="Name", name2= new String(name1), name3 = new String (ch), r;          
            System.out.println(name1);
            System.out.println(name2);
            System.out.println(name3);

            String y = "Besant";
            System.out.println(y);
            String z = new String(y.concat(" Technologies"));
            System.out.println(z);

            StringBuffer x= new StringBuffer("Besant");
            System.out.println(x);
            x.append(" Technologies");
            System.out.println(x);

            r = sc.nextLine();
            System.out.println(r);
        }
    }
}

/*String Methods
-----------------
1)length
2)charAt
3)containation
4)contains
5)startswith
6)endswith
7)equals
8)equalsIgnorecase
9)indexof
10)lastindexof
11)hashcode
12)touppercase
13)tolowercase
14)trim
15)isempty
16)valueof
17)join
18)substr */