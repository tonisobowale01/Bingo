import java.util.Scanner;

public class Game {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Card Bingo = new Card();
        System.out.println("Welcome to a game of BINGO!");
        Bingo.displayCard();

        // Because we need the game to continue running till a win, the infinite while loop is implemented
        while (true) {
            System.out.println("Choose an option.");
            System.out.println("[1] Enter a called number.\n[2] See current card.");

            Scanner first = new Scanner(System.in);
            System.out.print(": ");
            int option = first.nextInt();

            if (option == 1) {
                System.out.print("Enter the called number: ");
                int calledNumber = input.nextInt();
                if(calledNumber == 0) {
                    break;
                }
                Bingo.markNumber(calledNumber);
                if (Bingo.checkForBingo()) {
                    System.out.println("Win");
                    break;
                }
                System.out.println("No winner yet!\n");
            } else if (option == 2) {
                Bingo.displayCard();
            }
        }

        // Close the scanner
        input.close();
    }
}