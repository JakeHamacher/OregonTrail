import java.util.Scanner;

public class jumpingOffHelpers {

    public static String getJumpOffMonth(Scanner scanner) {
        String retVal = null;

        while (true) {
            System.out.println("It is 1848. Your jumping off");
            System.out.println("place for Oregon is Independence,");
            System.out.println("Missouri. You must decide which");
            System.out.println("month to leave Independence.");
            System.out.println("");
            System.out.println("1. March");
            System.out.println("2. April");
            System.out.println("3. May");
            System.out.println("4. June");
            System.out.println("5. July");
            System.out.println("6. Ask for advice");
            System.out.println("");
            System.out.print("What is your choice? ");

            // Ensure valid input
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline character

                switch (choice) {
                    case 1:
                        retVal = "March";
                        break;
                    case 2:
                        retVal = "April";
                        break;
                    case 3:
                        retVal = "May";
                        break;
                    case 4:
                        retVal = "June";
                        break;
                    case 5:
                        retVal = "July";
                        break;
                    case 6:
                        System.out.println("You attend a public meeting held");
                        System.out.println("for \"folks with the California -");
                        System.out.println("Oregon fever.\" You're told:");
                        System.out.println("");
                        System.out.println("If you leave too early, there");
                        System.out.println("won't be any grass for your");
                        System.out.println("oxen to eat. If you leave too");
                        System.out.println("late, you may not get to Oregon");
                        System.out.println("before winter comes. If you");
                        System.out.println("leave at just the right time,");
                        System.out.println("there will be green grass and");
                        System.out.println("the weather will still be cool.");
                        System.out.println();
                        continue; // Restart the loop
                    default:
                        System.out.println("Invalid option. Please try again.");
                        continue; // Restart the loop
                }

                System.out.println("You have chosen to set off in " + retVal + ".");
                break; // Exit loop after valid input
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input and clear the buffer
            }
        }
        return retVal;
    }
}
