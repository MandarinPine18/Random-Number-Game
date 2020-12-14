/*Student name
 **Date
 **Period
 **Program name
 */

//imports

import java.util.Scanner;


class Main {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //Welcome your user and ask for their name.
        String name = input("Enter your name: ");
        System.out.println("Welcome to the game, " + name);
        System.out.println(RandomNumberGame.getRules() + "\n");

        // starting the game
        RandomNumberGame game = startGame();

        // so the way I implemented the guess number system is in the game object. The actual values inside the object
        // are private, but the object is able to give the main method a recommendation for how many guesses are a good
        // number
        int guessLimit = game.recommendedGuesses();
        System.out.println("You have " + guessLimit + "guesses.");

        // here I get into the guessing part of the game
        // I start the count at one because, in any display portions, I always have to add one anyways. In order to offset that, <= is used instead of <
        for (int i = 1; i <= guessLimit; i++) {
            // get the guess from the user
            int guess = Integer.parseInt(input("Enter guess " + i + ": "));

            // GuessResult is an enumeration I made for this purpose, see the file for more information
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

    // takes the GuessResult
    public static String guessToString(GuessResult result, int i) {
        String resultString = "Error in guess to string";
        switch (result) {
            case LOW -> resultString = "That guess was too low";
            case HIGH -> resultString = "That guess was too high";
            case CORRECT -> resultString = "Congrats you correctly guessed the number in " + i + " guesses.";
        }
        return resultString;
    }
}