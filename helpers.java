import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class helpers {
    // Empty the terminal before displaying new text
    public static void clear() {
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

    // Set up player info
    public static Player playerSetup(Scanner scanner) {
        String name = "";
        String job = "";

        playerSetupInit();

        // Use a loop to handle invalid inputs and keep asking for a valid choice
        while (true) {
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        job = "Banker";
                        break;
                    case 2:
                        job = "Carpenter";
                        break;
                    case 3:
                        job = "Farmer";
                        break;
                    case 4:
                        helpers.clear();
                        System.out.println("Traveling to Oregon isn't easy!");
                        System.out.println("But if you're a banker, you'll");
                        System.out.println("have more money for supplies");
                        System.out.println("and services than a carpenter");
                        System.out.println("or a farmer.");
                        System.out.println();
                        System.out.println("However, the harder you have");
                        System.out.println("to try, the more points you");
                        System.out.println("deserve! Therefore, the");
                        System.out.println("farmer earns the greatest");
                        System.out.println("number of points and the");
                        System.out.println("banker earns the least.");
                        System.out.println();
                        playerSetupInit();
                        continue;
                    default:
                        helpers.clear();
                        System.out.println("Invalid option. Please try again.");
                        System.out.println();
                        playerSetupInit();
                        continue;
                }

                break;
            } catch (Exception e) {
                helpers.clear();
                System.err.println(e);
                System.err.println("Improper Input - try again");
                scanner.nextLine(); // Clear the invalid input
                System.out.println();
                playerSetupInit();
            }
        }
        Player player = new Player(name, job);

        setParty(player); // Get party member names

        return player;
    }

    private static void playerSetupInit() {
        System.out.println("Many kinds of people made the trip to Oregon.");
        System.out.println("You may:");
        System.out.println("1. Be a banker from Boston");
        System.out.println("2. Be a carpenter from Ohio");
        System.out.println("3. Be a farmer from Illinois");
        System.out.println("4. Find out the differences between the choices");
        System.out.println();
        System.out.println("What is your choice? ");
    }

    private static void setParty(Player player) {
        clear();
        getMemberName(player);
    }

    private static void getMemberName(Player player) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Predefined list of random names
        String[] randomNames = { "Alex", "Sam", "Jordan", "Taylor", "Casey", "Morgan", "Riley", "Drew", "Jamie",
                "Cameron", "Avery", "Parker", "Quinn", "Dakota", "Reese", "Skyler", "Jordan",
                "Logan", "Hunter", "Charlie", "Emerson", "Rowan", "Sage", "Harper", "Blake",
                "Devin", "Ellis", "Finley", "Jesse", "Micah", "Tatum", "Arden", "Remy",
                "Shiloh", "Lane", "Corey", "Spencer", "River", "Toby", "Dylan", "Case",
                "Hayden", "Blaine", "Oakley", "Peyton", "Robin", "Reagan", "Kendall", "Hollis",
                "Taylor", "Rory", "Phoenix", "Dale", "Marlowe", "Lennon", "Sawyer", "Terry",
                "Gray", "Alexis", "Daryl", "Baylor", "Linden", "Carter", "Kieran", "Quentin",
                "Ash", "Billie", "Sutton", "Monroe", "Marlow", "Cody", "Sydney", "Easton",
                "Ellery", "Marion", "Arlo", "Brett", "Cruz", "Dawson", "Indigo", "Nico",
                "Leighton", "Marley", "Noel", "Payton", "Robin", "Winter", "Cory", "Drew"
        };

        List<String> partyMembers = new ArrayList<>();
        int partySize = 5; // Number of party members

        System.out.println("Enter your party members' names. Press Enter to randomly assign a name.");

        // Loop to get party members
        for (int i = 1; i <= partySize; i++) {
            System.out.print("Enter name for party member " + i + ": ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                // Randomly assign a name if input is empty
                String randomName = randomNames[random.nextInt(randomNames.length)];
                System.out.println("No name entered. Assigning random name: " + randomName);
                partyMembers.add(randomName);
            } else {
                partyMembers.add(input);
            }
        }

        // Display the party members
        clear();
        System.out.println("\nYour party members are:");
        for (int i = 0; i < partyMembers.size(); i++) {
            System.out.println("Party Member " + (i + 1) + ": " + partyMembers.get(i));
        }

        player.setName(partyMembers.get(0)); // Set the name of the player to the first party member

        scanner.close();
    }
}
