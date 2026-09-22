////MAHI K PANCHAL(202302626010095)
//MARHAMA SHAIKH (202302626010124)
//ANANYA TIWARI (202302626010138)
//MAIN CLASS
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

          System.out.println("            *    **********       ***********   ***********   ***********   **             **  *********** ***********    **********     ");
        System.out.println("         **      **********       **       **   *             **            **             **  **       ** ***********    **       **    ");
        System.out.println("       **        **       **      **       **   *             **            **             **  **       ** **         **  **       **     ");
        System.out.println("      **         **       ***     **       **   *             **            **             **  **       ** **        ***  **       **       ");
        System.out.println("     **          **       ***     **       **   **********    ************  **             **  **       ** ************** **       **       ");
        System.out.println("     **          ************     **       **            *              **  **       *     **  **       ** **         *** **       **       ");
        System.out.println("     **          **       ***     **       **            *              **  **     ** **   **  **       ** **         *** **       **       ");
        System.out.println("      **         **       **      **       **            *              **  **   **    **  **  **       ** **         *** **       **         ");
        System.out.println("        **       **       **      ***********   **********    ************  ** **     ** ***    ********** **         *** **********       ");
        System.out.println("         **      **       **                                                                                                                 "); 
        //Instructions
        System.out.println("Welcome to Crossword Game!");
        System.out.println("");
        System.out.println("Rules:");
        System.out.println("1. There are 3 levels.");
        System.out.println("2. Keys for movements: Right(R), Left(L), Up(U), Down(D)");
        System.out.println("3. For any wrong move, message will be shown on right side of screen.");
        System.out.println("4. To check the answers, enter 'S'.");
        System.out.println("5. To exit the game, enter 'E'. (You can only exit if the prompt is asking to enter letter for movement)");
        System.out.println("");

        // Start Level 1
        Level1.main(args);
        
        // After Level 1, start Level 2
        System.out.println("Moving to Level 2...");
        Level2.main(args);
        
        // After Level 2, start Level 3
        System.out.println("Moving to Level 3...");
        Level3.main(args);
        
        scan.close();
    }
}