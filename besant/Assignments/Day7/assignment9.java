import java.util.Scanner;
public class assignment9 {
    public static void main (String [] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {
            String character;
            System.out.print("Enter the Character (A-Z): "); character = sc.next();
            if (character == "a" | character == "A" | character == "e" | character == "E" | character == "I" | character == "i" | character == "o" | character == "O" | character == "u" | character == "U")
                System.out.println("The Character is a Vowel!");
            else
                System.out.println("The Charatcer is a Consonent");
        }
    }
}
