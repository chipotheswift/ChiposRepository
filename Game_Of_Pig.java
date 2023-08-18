import java.util.Random;
import java.util.Scanner;

public class Game_Of_Pig {
    private static final int WINNING_SCORE = 20;
    private static final int PLAYER1_ROLLS_UNDER_10 = 1;
    private static final int PLAYER1_ROLLS_10_AND_ABOVE = 2;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int[] playerPoints = new int[2];
        int currentPlayer = 0;
        int currentPlayerTurnTotal = 0;

        System.out.print("Your turn total is 0. Enter (r)oll or (s)top:");

        while (playerPoints[0] < WINNING_SCORE && playerPoints[1] < WINNING_SCORE) {
            String choice;
            if (currentPlayer == 0) {
                choice = scanner.nextLine();
            } else {
                choice = "r"; 
            }

            if (choice.equals("r")) {
                int roll = random.nextInt(6) + 1;
                System.out.println("You rolled: " + roll);
                System.out.println();

                if (roll == 1) {
                    currentPlayerTurnTotal = 0;
                    System.out.println("Turn over.");
                    System.out.println("Current score: You have " + playerPoints[0] + ", Computer has " + playerPoints[1]);
                    System.out.println();
                    currentPlayer = 1;
                    System.out.println("Computer turn total is " + playerPoints[1] + ".Computer rolls.");
                } else {
                    currentPlayerTurnTotal += roll;
                    System.out.print("Your turn total is " + currentPlayerTurnTotal + ". Enter (r)oll or (s)top:");
                }
            } else if (choice.equals("s")) {
                playerPoints[currentPlayer] += currentPlayerTurnTotal;
                currentPlayerTurnTotal = 0;
                System.out.println("Turn over.");
                System.out.println("Current score: You have " + playerPoints[0] + ", Computer has " + playerPoints[1]);
                System.out.println();
                currentPlayer = 1;
                System.out.println("Computer turn total is " + playerPoints[1] + ". Computer rolls.");
            }

            if (currentPlayer == 1 && playerPoints[0] < 10) {
                int numRolls = PLAYER1_ROLLS_UNDER_10;

                for (int i = 0; i < numRolls; i++) {
                    int computerRoll = random.nextInt(6) + 1;
                    System.out.println("Computer rolled: " + computerRoll);
                    System.out.println();

                    if (computerRoll == 1) {
                        currentPlayerTurnTotal = 0;
                        System.out.println("Turn over.");
                        System.out.println("Current score: You have " + playerPoints[0] + ", Computer has " + playerPoints[1]);
                        System.out.println();
                        currentPlayer = 0;
                        System.out.print("Your turn total is " + playerPoints[0] + ". Enter (r)oll or (s)top:");
                        break;
                    } else {
                        currentPlayerTurnTotal += computerRoll;
                    }
                }

                if (currentPlayerTurnTotal > 0) {
                    playerPoints[currentPlayer] += currentPlayerTurnTotal;
                    currentPlayerTurnTotal = 0;
                    System.out.println("Computer turn total is "+playerPoints[1]+ ". Computer stops.");
                    System.out.println("Turn over.");
                    System.out.println("Current score: You have " + playerPoints[0] + ", Computer has " + playerPoints[1]);
                    System.out.println();
                    currentPlayer = 0;
                    System.out.print("Your turn total is " + playerPoints[0] + ". Enter (r)oll or (s)top:");
                }
            } else if (currentPlayer == 1 && playerPoints[0] >= 10) {
                int numRolls = PLAYER1_ROLLS_10_AND_ABOVE;

                for (int i = 0; i < numRolls; i++) {
                    int computerRoll = random.nextInt(6) + 1;
                    System.out.println("Computer rolled: " + computerRoll);
                    System.out.println();

                    if (computerRoll == 1) {
                        currentPlayerTurnTotal = 0;
                        System.out.println("Turn over.");
                        System.out.println("Current score: You have " + playerPoints[0] + ", Computer has " + playerPoints[1]);
                        System.out.println();
                        currentPlayer = 0;
                        System.out.print("Your turn total is " + playerPoints[0] + ". Enter (r)oll or (s)top:");
                        break;
                    } else {
                        currentPlayerTurnTotal += computerRoll;
                    }
                }

                if (currentPlayerTurnTotal > 0) {
                    playerPoints[currentPlayer] += currentPlayerTurnTotal;
                    currentPlayerTurnTotal = 0;
                    System.out.println("Computer turn total is "+playerPoints[1]+". Computer stops.");
                    System.out.println("Turn over");
                    System.out.println("Current score: You have " + playerPoints[0] + ", Computer has " + playerPoints[1]);
                    System.out.println();
                    currentPlayer = 0;
                    System.out.print("Your turn total is " + playerPoints[0] + ". Enter (r)oll or (s)top:");
                }
            }
        }

        System.out.println();
        System.out.println("Game Over!");

        if (playerPoints[0] >= WINNING_SCORE) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}
