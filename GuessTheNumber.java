import java.util.Random;
import java.util.Scanner;


public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 10;
        int rounds = 3;
        int score = 0;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("Round " + round + " of " + rounds);
            int numberToGuess = random.nextInt(100) + 1;
            boolean guessed = false;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.println("Attempt " + attempt + " of " + maxAttempts);
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
         System.out.println("Congratulations! You guessed the number.");
          score += (maxAttempts - attempt + 1) * 10; 
                    guessed = true;
                    break;
                } else if (userGuess < numberToGuess) {
                System.out.println("The number is higher than your guess.");
                } else {
                    System.out.println("The number is lower than your guess.");
                }
            }

            if (!guessed) {
  System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess);
            }

            System.out.println("Your score after round " + round + " is: " + score);
            System.out.println();
        }

        System.out.println("Game Over!");
        System.out.println("Your final score is: " + score);
        scanner.close();
    }
}