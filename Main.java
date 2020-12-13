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

        int guessLimit = game.recommendedGuesses();
        System.out.println("You have " + guessLimit + "guesses.");

        for (int i = 0; i < guessLimit; i++) {
            int guess = Integer.parseInt(input("Enter guess " + (i+1) + ": "));
            GuessResult result = game.processGuess(guess);
            System.out.println(guessToString(result, i) + "\n");
            if (result == GuessResult.CORRECT) {
                break;
            }
        }

        //Code a way to replay the game.

    }

    //Create your Static game method here.
    public static RandomNumberGame startGame() {
        int[] range = promptRange();
        return new RandomNumberGame(range);
    }

    public static int[] promptRange() {
        int[] range = new int[2];
        range[0] = 1;
        range[1] = Integer.parseInt(input("Enter the maximum possible number: "));
        return range;
    }

    // cleans up repetitive print and get input statements
    public static String input(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    public static String guessToString(GuessResult result, int i) {
        String resultString = "Error in guess to string";
        switch (result) {
            case LOW -> resultString = "That guess was too low";
            case HIGH -> resultString = "That guess was too high";
            case CORRECT -> resultString = "Congrats you correctly guessed the number in " + (i+1) + " guesses.";
        }
        return resultString;
    }
}