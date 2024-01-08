import java.util.Scanner;


public class Main {

    private static BaseConverter bc; // Create a new object of BaseSystem class


    /**
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create a new instance of Scanner class

        // Loop until user stop using
        while (true) {
            System.out.println("*=*=*=*=*=* BASE CONVERTER Program *=*=*=*=*=*");
            bc = new BaseConverter(); // Initialize object from BaseSystem class

            /*Input section*/
            do { // Input base input
                try {
                    System.out.print("Please enter input base number: ");
                    // Input base
                    bc.setInBase(input.nextInt());
                    input.nextLine();

                    break;
                } catch (IllegalArgumentException iae) { // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                    input.nextLine();
                } catch (Exception e) { // Throw when user input is non-numerical
                    System.out.println("Only 2, 10 or 16 base number is allowed!");
                    input.nextLine();
                }
            } while (true);

            do { // Input base output
                try {
                    System.out.print("Please enter output base number: ");
                    // Base input
                    bc.setOutBase(input.nextInt());
                    input.nextLine();

                    break;
                } catch (IllegalArgumentException iae) {  // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                    input.nextLine();
                } catch (Exception e) { // Throw when user input is non-numerical
                    System.out.println("Only 2, 10 or 16 base number is allowed!");
                    input.nextLine();
                }
            } while (true);

            do { // Input converted value
                try {
                    System.out.print("Please enter the value to be converted: ");
                    // Input value
                    bc.setValue(input.nextLine());

                    break;
                } catch (IllegalArgumentException iae) { // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                }
            } while (true);

            /*Output section*/
            // Print the initial value
            System.out.print("The value enter: ");
            System.out.printf("(%s)%d\n", bc.getValue(), bc.getInBase());
            // Convert value into given base
            bc.baseConverter();
            // Print converted value
            System.out.print("The converted value: ");
            System.out.printf("(%s)%d\n", bc.getValue(), bc.getOutBase());

            /*Looping section*/
            do {
                try {
                    System.out.print("Do you want to convert value again [Yes-No]? ");
                    if (!Validation.loopCheck(input.nextLine())) { // Stop the program
                        System.out.println("Thanks for using the program!");
                        return;
                    } else { // Continue program
                        System.out.println();
                        break;
                    }
                } catch (IllegalArgumentException iae) { // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                }
            } while (true);
        }
    }
}