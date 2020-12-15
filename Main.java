/* Ethan Parab
 **12/14/20
 **Period 5
 **AP Computer Science A
 */

//imports

import java.util.Scanner;


class Main {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Welcome your user and ask for their name.
        String name = input("Enter your name: ");
        System.out.println("Welcome to the game, " + name);
        System.out.println(RandomNumberGame.getRules() + "\n");

        while (true) {
            // starting the game
            RandomNumberGame game = startGame();

            // so the way I implemented the guess number system is in the game object. The actual values inside the object
            // are private, but the object is able to give the main method a recommendation for how many guesses are a good
            // number
            int guessLimit = game.recommendedGuesses();
            System.out.println("You have " + guessLimit + " guesses.");

            // here I get into the guessing part of the game
            // I start the count at one because, in any display portions, I always have to add one anyways. In order to offset that, <= is used instead of <
            for (int i = 1; i <= guessLimit; i++) {
                // get the guess from the user
                int guess;
                while (true) { try {
                    guess = Integer.parseInt(input("Enter guess " + i + ": "));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You must enter an integer. Try again.");
                } }

                // GuessResult is an enumeration I made for this purpose, see the file for more information
                GuessResult result = game.processGuess(guess);
                System.out.println(guessToString(result, i) + "\n");
                if (result == GuessResult.CORRECT) {
                    break;
                }
                if (i == guessLimit) {
                    game.loseMessage();
                    System.out.println();
                }
            }

            //Code a way to replay the game.
            while (true) { try {
                Command command = stringToCommand(input("Type \"end\" to exit the program or \"replay\" to restart the game.\n>"));
                switch (command) {
                    case ERROR:
                        throw new IllegalArgumentException("Invalid command, try again.");
                    case EXIT:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } }
        }
    }

    //Create your Static game method here.
    public static RandomNumberGame startGame() {
        int[] range = promptRange();
        return new RandomNumberGame(range);
    }

    public static int[] promptRange() {
        int[] range = new int[2];
        range[0] = 1;
        while (true) { try {
            range[1] = Integer.parseInt(input("Enter the maximum possible number: "));
            if (range[1] <= 1) {
                throw new NumberFormatException();
            }
            break;
        } catch (NumberFormatException e) {
            System.out.println("You must enter an integer greater than 1. Try again.");
        } }
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
            case LOW:
                resultString = "That guess was too low";
                break;
            case HIGH:
                resultString = "That guess was too high";
                break;
            case CORRECT:
                resultString = "Congrats you correctly guessed the number in " + i + " guesses.";
                break;
        }
        return resultString;
    }

    public static Command stringToCommand(String string) {
        Command command = Command.ERROR;
        string = string.toLowerCase();
        if (string.startsWith("replay")) {
            command = Command.RESTART;
        } else if (string.startsWith("end")) {
            command = Command.EXIT;
        }
        return command;
    }
}