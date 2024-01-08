import java.util.Scanner;


public class Main {

    private static GUI gui; // Create an object of GUI class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in); // Create an object from Scanner class
        gui = new GUI(); // Initialize object from Scanner class

        // Loop until user choose Exit
        while (true) {
            gui.menu(); // Print main menu
            int choice = 0; // Store user choice

            /*Input choice*/
            do { // Make sure user input is valid
                try {
                    System.out.print("Please choice one option: ");
                    // Input and validate input
                    choice = Validation.checkRange(input.nextInt(), 1, 4);
                    input.nextLine();

                    break;
                } catch (NumberFormatException nfe) { // Throw when user input is out of range
                    System.out.println(nfe.getMessage());
                    input.nextLine();
                } catch (Exception e) { // Throw when user input is non-numerical
                    System.out.println("Please only enter integer from 1 to 4");
                    input.nextLine();
                }
            } while (true);

            /*
             * Switch case to handle user choice
             */
            switch (choice) {
                case 1:
                    // Create new array with user input
                    gui.createArray();
                    System.out.println();
                    break;

                case 2:
                    // Display the array in ascending order
                    System.out.println(gui.getAscendingArray());
                    System.out.println();
                    break;

                case 3:
                    // Display the array in descending order
                    System.out.println(gui.getDescendingArray());
                    System.out.println();
                    break;

                case 4:
                    // Exit the program
                    System.out.println("========= THANKS YOU FOR USING THE PROGRAM =========");
                    return;
            }
        }
    }

}
