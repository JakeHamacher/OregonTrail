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
        System.out.println("Welcome to Oregon Trail!");

            System.out.println("\n----- Main Menu -----");
            initialChoice(scanner);
        }

    private static void initialChoice(Scanner scanner) {
        System.out.println("1. Start Journey");
            System.out.println("2. Quit");
            System.out.print("Choose an option: ");
            try {
                int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    clear();
                    System.out.println("Starting the journey...");
                    break;
                case 2:
                    clear();
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    clear();
                    System.out.println("Invalid option. Please try again.");
                    initialChoice(scanner);
            }
            } catch (Exception e) {
                clear();
                System.err.println(e);
                System.err.println("Improper Input - try again");
                scanner.nextLine();
                initialChoice(scanner);
            }
            
        }

        private static void clear() {
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    // Windows
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    // Unix/Linux/Mac
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            } catch (Exception e) {
                System.out.println("Error clearing the console: " + e.getMessage());
            }
        }
    }

    

