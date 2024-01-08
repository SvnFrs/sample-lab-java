import java.util.Scanner;

/**
 * This class represents a BubbleSort program
 * which uses the BubbleSortBackEnd class to sort an array of random integers.
 */
public class BubbleSort {

    /**
     *
     * The main method of the BubbleSort class. Prompts the user for the size of the array,
     * generates the array with random integers, sorts the array, and prints both the unsorted and sorted arrays.
     *
     @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BubbleSortBackEnd be = new BubbleSortBackEnd();

        while (true) {
            try {
                System.out.println("Enter number of array: ");
                be.setSize(Integer.parseInt(input.nextLine())); // set the size of the array
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("The array size must be a positive integer!"); // throw an exception if the size is less than or equal to 0
            } catch (Exception e) {
                System.out.println(e.getMessage()); //
            }
        }

        be.generateArray(); // generate the array with random elements
        System.out.print("Unsorted array: "
            + be.toString()); // print the unsorted array

        System.out.println();

        be.sort(); // sort the array
        System.out.print("Sorted array: "
            + be.toString()); // print the sorted array
    }

}