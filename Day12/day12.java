//day12
import java.util.Scanner;
public class day12
{ 
    public static void main(String[] args) 
    { 
        try(Scanner sc = new Scanner (System.in))
        { 
            String x = "Besant Technologies"; 
            System.out.println(x.indexOf('o',13));
        } 
    } 
} 
/*String buffer and builder methods 
 1) append
 2) replace
 3) index
 4) delete
 5) reverse
*/
