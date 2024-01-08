import java.util.Random;
import java.util.Arrays;

/**
 * The BinaryBackend class represents the backend logic for performing binary search on an array of integers.
 */
class BinaryBackend {
    private int[] array;
    private int searchNum;

    /**
     * Constructs a BinaryBackend object with the specified number of array elements and search number.
     *
     * @param numOfArray the number of elements in the array
     * @param searchNum the number to be searched for in the array
     */
    public BinaryBackend(int numOfArray, int searchNum) throws Exception {
        do {
            try {
                this.searchNum = searchNum;
                array = new int[numOfArray];
                Random random = new Random();
                // Fill the array with random numbers
                for (int i = 0; i < numOfArray; i++) {
                    array[i] = random.nextInt(10);
                }
                // Sort the array
                Arrays.sort(array);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number again.");
            }
        } while (true);
    }

    /**
     * Searches the array for the specified search number using binary search and returns its index.
     *
     * @return the index of the search number if found, -1 otherwise
     */
    public int getIndex() {
        // Perform binary search to find the index of the search number
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == searchNum) {
                return mid;
            } else if (array[mid] < searchNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // if the search number is not found in the array, return -1
        return -1;
    }

    /**
     * Returns the array.
     *
     * @return the array
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Returns a string representation of the array.
     *
     * @return a string representation of the array
     */
    @Override
    public String toString() {
        String s = "["; // Print the header of the array

        // Print the elements of the array
        for (int i = 0; i < array.length; i++) {
            s += array[i];
            if (i != array.length - 1) {
                s += ", ";
            }
        }
        s += "]";

        return s;
    }
}
