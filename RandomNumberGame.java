public class RandomNumberGame {
	private int min = Integer.MIN_VALUE;
	private int max = Integer.MAX_VALUE;
	private int number;
	private static final boolean cheats = false; // change this to true if you want to enter cheat/debug/evaluation mode

	public RandomNumberGame(int[] range) {
		setMin(range[0]);
		setMax(range[1]);
		generateNumber();
		if (cheats) {
			System.out.println("CHEATS ENABLED - " + number + " generated from range [" + min + ", " + max + "]");
		}
		//System.out.println(number);	// uncomment the first part of this line for evaluation - this is a much more primitive way to get the generated number for evaluation
	}

	private void generateNumber() {
		number = (int)(Math.random() * (max-min+1) + min);
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

	public GuessResult processGuess(int guess) {
		if (guess < number) {
			return GuessResult.LOW;
		} else if (guess > number) {
			return GuessResult.HIGH;
		} else {
			return GuessResult.CORRECT;
		}
	}

	public int recommendedGuesses() {
		int range = max - min;
		int recommendation;
		if (range > 500) {
			recommendation = 60;
		} else if (range > 250) {
			recommendation = 40;
		} else if (range > 100) {
			recommendation = 20;
		} else if (range > 10) {
			recommendation = 10;
		} else {
			recommendation = range / 2;
		}
		return recommendation;
	}
}
