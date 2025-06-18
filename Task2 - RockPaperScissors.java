import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Enter your choice (Rock, Paper, Scissors): ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];

            // Convert user input to standard format
            String userChoice = "";
            if (userInput.equals("rock")) userChoice = "Rock";
            else if (userInput.equals("paper")) userChoice = "Paper";
            else if (userInput.equals("scissors")) userChoice = "Scissors";
            else {
                System.out.println("Invalid input. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            System.out.println("Computer chose: " + computerChoice);
            System.out.println("You chose: " + userChoice);

            // Determine the winner
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (
                (userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (userChoice.equals("Scissors") && computerChoice.equals("Paper")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Rock"))
            ) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            // Ask to play again
            System.out.println("Do you want to play again? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            playAgain = again.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
