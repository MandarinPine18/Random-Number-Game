public class RandomNumberGame {
    private int min = Integer.MIN_VALUE;
    private int max = Integer.MAX_VALUE;
    private static boolean cheats = false; // change this to true if you want to enter cheat mode

    public RandomNumberGame(int[] range) {
        setMin(range[1]);
        setMax(range[2]);
    }

    private void setMin(int min) {
        if (max > min) {
            this.min = min;
        }
    }

    private void setMax(int max) {
        if (max > min) {
            this.max = max;
        }
    }

    public static String getRules() {
        return "This is the Random Number Guessing Game. A random number will be generated based on a range you provide. You must then guess the number. You have a limited number of guesses. Try your best and have fun!";
    }
}
