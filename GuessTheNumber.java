import javax.swing.*;
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {
        // Game setup
        int totalRounds = 5;  // Number of rounds
        int totalScore = 0;   // Total score initialized to 0
        int maxAttempts = 10; // Max attempts per round

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("Round " + round + " of " + totalRounds);
            // Generate random number between 1 and 100
            int numberToGuess = new Random().nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            // Start a round
            while (attemptsLeft > 0 && !guessedCorrectly) {
                // Prompt user to guess
                String userInput = JOptionPane.showInputDialog(null, 
                        "Round " + round + ": Guess the number between 1 and 100\nAttempts left: " + attemptsLeft, 
                        "Guess the Number", JOptionPane.QUESTION_MESSAGE);
                if (userInput == null) {
                    // User canceled the dialog
                    return;
                }

                try {
                    int userGuess = Integer.parseInt(userInput);

                    if (userGuess < 1 || userGuess > 100) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                        continue;
                    }

                    // Check if the user's guess is correct
                    if (userGuess == numberToGuess) {
                        guessedCorrectly = true;
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number correctly.");
                        int points = maxAttempts - attemptsLeft + 1;  // Points based on attempts
                        totalScore += points;
                        JOptionPane.showMessageDialog(null, "You scored " + points + " points in this round.");
                    } else if (userGuess < numberToGuess) {
                        JOptionPane.showMessageDialog(null, "The number is higher. Try again!");
                    } else {
                        JOptionPane.showMessageDialog(null, "The number is lower. Try again!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry! You've used all your attempts. The number was " + numberToGuess);
            }

            // Show score after each round
            JOptionPane.showMessageDialog(null, "Total Score: " + totalScore);
        }

        // Final score after all rounds
        JOptionPane.showMessageDialog(null, "Game Over! Your final score is: " + totalScore);
    }
}
