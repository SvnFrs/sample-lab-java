import java.util.Scanner;

public class InsertionSort {
    /**
     * The main method for the InsertionSort class.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InsertionSortBackEnd be;

        // Loop until a valid input is received
        while (true) {
            try {
                System.out.println("Enter number of array: ");

                // Try to parse the input as an integer
                be = new InsertionSortBackEnd(Integer.parseInt(input.nextLine()));

                // If successful, break out of the loop
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("The array size must be a positive integer!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Print the unsorted array
        System.out.print("Unsorted array: ");
        System.out.println(be.toString());

        // Sort the array
        be.sort();

        // Print the sorted array
        System.out.print("Sorted array: ");
        System.out.print(be.toString());
    }
}
