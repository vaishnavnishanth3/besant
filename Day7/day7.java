import java.util.Scanner;
public class day7 {
    public static void main (String[] args){
        int a,b;
        try (Scanner sc = new Scanner (System.in)) {
            a = sc.nextInt();
            b = sc.nextInt();
        }
        System.out.println("Bitwise AND "+(a&b));
        System.out.println("Bitwise OR "+(a|b));
        System.out.println("Bitwise Ex-OR "+(a^b));
    }
}