import java.util.Random;

/**
 * The Linear Search Back End class
 */
class LinearSearchBackEnd {
    private int[] array; // The array of integers
    private int numOfArray; // The size of the array
    private int searchNum; // The search number

    /**
     * The constructor for the LinearSearchBackEnd class.
     *
     * @param numOfArray The number of elements in the array.
     * @param searchNum  The search number.
     */
    public LinearSearchBackEnd(int numOfArray, int searchNum) {
        while (true) {
            try {
                this.numOfArray = numOfArray;
                this.searchNum = searchNum;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number again.");
            }
        }
        array = new int[numOfArray];
        Random random = new Random();
        // Fill the array with random numbers
        for (int i = 0; i < numOfArray; i++) {
            array[i] = random.nextInt(10);
        }
    }

    /**
     * The method for searching for the search number in the array using linear search algorithm.
     *
     * @return The index of the search number in the array, or -1 if the search number is not found.
     */
    public int getIndex() {
        for (int i = 0; i < numOfArray; i++) {
            if (array[i] == searchNum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * The toString method for the LinearSearchBackEnd class.
     * This method is used to print the array in a readable format.
     *
     * @return The formatted array as a string.
     */
    @Override
    public String toString() {
        // Create a StringBuilder object to construct the formatted array
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numOfArray; i++) {
            sb.append(array[i]);
            // If the current element is not the last element in the array, add a ", "
            if (i < numOfArray - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        // Return the formatted array as a string
        return sb.toString();
    }
}