import java.util.Scanner;

public class Main {

    private static Emp_Manager em;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in); // Create an instance of Scanner class
        em = new Emp_Manager(); // Initialize new Emp_Manager instance

        // Loop until user choose 0
        while (true) {
            em.menu(); // Print menu
            // Make sure user input is in range
            while (true) {
                try {
                    // Input and validate choice
                    int choice = Validation.checkRange(Integer.parseInt(input.nextLine().trim()), 0, 2);
                    // Operate different menu section
                    switch (choice) {
                        case 1: // Create new employee data
                            em.add();
                            break;

                        case 2: // Show employee list
                            em.show();
                            break;

                        case 0: // End the program
                            System.out.println("SEE YOU AGAIN!");
                            return;
                    }
                    break;
                } catch (NumberFormatException nfe) { // Throw when user input is out of range
                    System.out.print("--------Error! Please choice again (From 0 to 2): ");
                } catch (IllegalArgumentException iae) { // Throw when user input is non-numerical
                    System.out.print("--------Error! Please choice again (From 0 to 2): ");
                }
            }
        }
    }
}
