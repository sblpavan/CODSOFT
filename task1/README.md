# CODSOFT Java Internship - Task 1

##  Task 1: Number Guessing Game

---

###  Problem Statement:

- Generate a random number between 1 and 100.
- User has to guess the number.
- Provide feedback after each guess:
  - "Too high"
  - "Too low"
  - "Correct"
- Repeat until the user guesses correctly.

---

### Source Code

```java
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        int secretNumber = random.nextInt(100) + 1;
        int guessCount = 0;
        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            guessCount++;

            if (userGuess == secretNumber) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number in " + guessCount + " tries.");
            } else if (userGuess < secretNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        scanner.close();
    }
}
