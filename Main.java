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

    public static String input(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
}