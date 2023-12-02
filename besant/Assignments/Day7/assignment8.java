import java.util.Scanner;
public class assignment8
{
    public static void main(String[] args) 
    {
        try(Scanner sc = new Scanner (System.in))
        {   int score; String grade = "";
            System.out.print("Enter the score: "); score = sc.nextInt();
            if (score > 0)
            {
                if (score >= 91)
                {
                    grade = "S"; 
                }
                else if (score >= 81 && score <=90)
                {
                    grade = "A";
                }
                else if (score >=71 && score <=80)
                {
                    grade = "B";
                }   
                else if (score >=41 && score <=70)
                {
                    grade = "C";
                }
                else if (score >= 0 && score <=40)
                {
                    grade = "Fail";
                }
                System.out.println("Your Grade is "+grade);
            }
            else
            {
                System.out.println("Invalid Input");
            }
        }
    }
}
