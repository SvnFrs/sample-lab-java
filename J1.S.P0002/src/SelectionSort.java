import java.util.Scanner;

public class SelectionSort {
    /**
     *
     * The main method of the BubbleSort class. Prompts the user for the size of the array,
     * generates the array with random integers, sorts the array, and prints both the unsorted and sorted arrays.
     *
     @param args The command line arguments.
     */
    public static void main(String[] args) {

        // Create a Scanner instance to take input from user
        Scanner input = new Scanner(System.in);
        SelectionSortBackEnd be;

        // Infinite loop to keep asking for user input until a valid positive integer is given
        while (true) {
            try {
                // Ask for array size
                System.out.println("Enter number of array: ");

                // Try to parse the user input to integer
                be = new SelectionSortBackEnd(Integer.parseInt(input.nextLine()));

                // Break the loop if the user input is valid
                break;
            } catch (NumberFormatException nfe) {
                // Catch NumberFormatException if the user input is not an integer
                System.out.println("The array size must be a positive integer!");
            } catch (Exception e) {
                // Catch other exceptions if any
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
