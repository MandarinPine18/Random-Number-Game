/*Student name
 **Date
 **Period
 **Program name
 */

//imports

import java.util.Scanner;


class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        //Welcome your user and ask for their name.
        String name = input("Enter your name: ");
        System.out.println("Welcome to the game, " + name);

        RandomNumberGame game = startGame();

        int guessLimit = 5;
        for (int i = 0; i < guessLimit; i++) {
            makeGuess();
        }

        //Code a way to replay the game.

    }

    //Create your Static game method here.
    public static RandomNumberGame startGame() {
        int[] range = promptRange();
        return new RandomNumberGame(range);
    }

    public static int[] promptRange() {
        return new int[]{1, 10};
    }

    // cleans up repetitive print and get input statements
    public static String input(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
}