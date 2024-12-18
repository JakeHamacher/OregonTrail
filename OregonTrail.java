import java.util.Scanner;

public class OregonTrail {

    public static void main(String[] args) {
        // Initialize game components
        Scanner scanner = new Scanner(System.in);

        // Start the game
        startGame(scanner);

        // Close the scanner
        scanner.close();
    }

    // Method to start the game
    private static void startGame(Scanner scanner) {
        helpers.clear();
        System.out.println("Welcome to Oregon Trail!");
        System.out.println("\n----- Main Menu -----");
        initialChoice(scanner);

        // Get player data
        System.out.println(helpers.playerSetup(scanner));
        jumpingOffHelpers.getJumpOffMonth(scanner);
    }

    // Get choice and proper input to either start game or quit
    private static void initialChoice(Scanner scanner) {
        System.out.println("1. Start Journey");
        System.out.println("2. Quit");
        System.out.print("Choose an option: ");
        try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    helpers.clear();
                    System.out.println("Starting the journey...");
                    System.out.println();
                    break;
                case 2:
                    helpers.clear();
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    helpers.clear();
                    System.out.println("Invalid option. Please try again.");
                    initialChoice(scanner);
            }
        } catch (Exception e) {
            helpers.clear();
            System.err.println(e);
            System.err.println("Improper Input - try again");
            scanner.nextLine();
            initialChoice(scanner);
        }
    }
}