import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Random dice = new Random();
        Scanner input = new Scanner(System.in);
        String playAgain;
        int dieOne = 0;
        int dieTwo = 0;
        int crapsRoll = 0;
        int crapsPoint = 0;
        int userWins = 0;
        int userLosses = 0;
        boolean gameOver = false;
        boolean validPlayAgain = false;

        while(!gameOver)
        {
            dieOne = dice.nextInt(6) + 1;
            dieTwo = dice.nextInt(6) + 1;
            crapsRoll = dieOne + dieTwo;
            crapsPoint = 0;
            if (crapsRoll == 7 || crapsRoll == 11)
            {
                System.out.println(dieOne + " and " + dieTwo + " is " + crapsRoll + ", a natural was rolled. The game is won!");
                userWins += 1;
                do
                {
                    System.out.print("Would you like to play again? Y/N ");
                    playAgain = input.nextLine();
                    playAgain = playAgain.toUpperCase();
                    if (playAgain.equals("Y") || playAgain.equals("N"))
                    {
                        validPlayAgain = true;
                        if (playAgain.equals("Y"))
                        {
                            gameOver = false;
                        }
                        else
                        {
                            gameOver = true;
                        }
                    }
                }
                while (!validPlayAgain);
            }
            else if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12)
            {
                System.out.println(dieOne + " and " + dieTwo + " is " + crapsRoll + ", craps was rolled. The game is lost!");
                userLosses += 1;
                do
                {
                    System.out.print("Would you like to play again? Y/N ");
                    playAgain = input.nextLine();
                    playAgain = playAgain.toUpperCase();
                    if (playAgain.equals("Y") || playAgain.equals("N")) ;
                    {
                        validPlayAgain = true;
                        if (playAgain.equals("Y"))
                        {
                            gameOver = false;
                        }
                        else
                        {
                            gameOver = true;
                        }
                    }
                }
                while (!validPlayAgain);
            }
            else
            {
                System.out.println("You rolled a " + dieOne + " and a " + dieTwo + " totaling " + crapsRoll + ", the point is set at " + crapsRoll);
                crapsPoint = crapsRoll;
                crapsRoll = 0;
                while (crapsPoint != crapsRoll)
                {
                    dieOne = dice.nextInt(6) + 1;
                    dieTwo = dice.nextInt(6) + 1;
                    crapsRoll = dieOne + dieTwo;
                    if (crapsRoll == 7)
                    {
                        System.out.println("You rolled a " + dieOne + " and a " + dieTwo + " totaling " + crapsRoll + ". You have crapped out, the game is lost!");
                        crapsPoint = crapsRoll;
                        userLosses += 1;
                        do
                        {
                            System.out.print("Would you like to play again? Y/N ");
                            playAgain = input.nextLine();
                            playAgain = playAgain.toUpperCase();
                            if (playAgain.equals("Y") || playAgain.equals("N"))
                            {
                                validPlayAgain = true;
                                if(playAgain.equals("Y"))
                                {
                                    gameOver = false;
                                }
                                else
                                {
                                    gameOver = true;
                                }
                            }
                            else
                            {
                                validPlayAgain = false;
                            }
                        }
                        while (!validPlayAgain);
                    }
                    else if (crapsRoll == crapsPoint)
                    {
                        System.out.println("You rolled a " + dieOne + " and a " + dieTwo + " totaling " + crapsRoll + ". You hit the point, the game is won!");
                        userWins += 1;
                        do
                        {
                            System.out.print("Would you like to play again? Y/N ");
                            playAgain = input.nextLine();
                            playAgain = playAgain.toUpperCase();
                            if (playAgain.equals("Y") || playAgain.equals("N"))
                            {
                                validPlayAgain = true;
                                if (playAgain.equals("Y"))
                                {
                                    gameOver = false;
                                }
                                else
                                {
                                    gameOver = true;
                                }
                            }
                        }
                        while (!validPlayAgain);
                    }
                    else
                    {
                        System.out.println("You rolled a " + dieOne + " and a " + dieTwo + " totaling " + crapsRoll + ". You will roll again to try for the point.");
                    }
                }
            }
        }
        System.out.println("Thank you for playing, you won " + userWins + " times and lost " + userLosses + " times.");
    }
}