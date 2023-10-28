import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 5;
        int rounds = 5;
        int totalScore = 0;

        Random random = new Random();

        for (int round = 1; round <= rounds; round++) {
            int targetNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            System.out.println("Round " + round + ": Guess a number between " + rangeStart + " and " + rangeEnd);
            int attempts = 0;
            int userGuess;

            while (attempts < maxAttempts) {
                userGuess = getUserGuess("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess");
                attempts++;

                if (userGuess == targetNumber) {
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Round " + round + " ended. Your total score so far: " + totalScore);
        }

        System.out.println("Game over. Total Score: " + totalScore);
    }

    public static int getUserGuess(String message) {
        String userInput = JOptionPane.showInputDialog(null, message);
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            return getUserGuess(message);
        }
    }
}