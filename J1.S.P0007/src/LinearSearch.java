import java.util.Scanner;

class LinearSearch {
    /**
     * The main method for the BinaryFrontEnd class.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                // Create a Scanner object to read input from the user
                System.out.println("Enter the number of array: ");
                // Read the number of elements in the array from the user
                int numOfArray = sc.nextInt();
                System.out.println("Enter the search number: ");
                // Read the search number from the user
                int searchNum = sc.nextInt();
                // Create a BinaryBackend object with the number of elements and search number
                LinearSearchBackEnd lb = new LinearSearchBackEnd(numOfArray, searchNum);
                // Get the index of the search number
                int index = lb.getIndex();
                // Print the sorted array
                System.out.println("The Array: " + lb);
                // If the index is -1, the search number is not found in the array
                if (index == -1) {
                    System.out.println("Search number not found in array");
                } else {
                    // Otherwise, print the index of the search number in the array
                    System.out.println("Found " + searchNum + " at index: " + index);
                }
                break;
            } catch (Exception e) {
                // Catch any exceptions that occur during the execution of the program
                System.out.println("Invalid input, please enter a valid number.");
                sc.nextLine();
            }
        } while (true);
    }
}
