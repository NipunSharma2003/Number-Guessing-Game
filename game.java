import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("==========================================");
        System.out.println("         Welcome to the Number Guessing Game");
        System.out.println("==========================================");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Your task is to guess it within limited tries.");
        System.out.println("Let's see how good your guessing skills are!\n");

        boolean playAgain = true;

        while (playAgain) {
            int number = rand.nextInt(100) + 1; // random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7;  // maximum number of chances
            boolean guessedCorrectly = false;

            System.out.println("A number has been chosen between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess (" + (maxAttempts - attempts) + " attempts left): ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("\nCongratulations! You guessed the number " + number + " in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a smaller number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou have used all your attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("\n==========================================");
                System.out.println("Thank you for playing the Number Guessing Game!");
                System.out.println("Hope you enjoyed it. See you next time!");
                System.out.println("==========================================");
            }
        }

        sc.close();
    }
}
