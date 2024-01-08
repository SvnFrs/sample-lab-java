import java.util.Random;

public class SelectionSortBackEnd {

    // field to store the integer array
    private int[] arr;

    /*
     * constructor that takes in the size of the array
     * and initializes the array with random integers
     *
     */
    public SelectionSortBackEnd(int arrSize) throws Exception {
        do {
            try {
                arr = new int[arrSize];
                Random rand = new Random();
                for (int i = 0; i < arrSize; i++) {
                    arr[i] = rand.nextInt(10);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number again.");
            }
        } while (true);
    }

    /**
     * method to sort the array using a basic sorting algorithm (Bubble Sort)
     *
     */
    public void sort() {
        // outer loop to iterate through the array
        for (int i = 0; i < arr.length - 1; i++) {
            // inner loop to compare and swap elements
            for (int j = i; j < arr.length; j++) {
                // if the current element is greater than the next element
                if (arr[i] > arr[j]) {
                    // swap the elements
                    swap(i, j);
                }
            }
        }
    }

    /**
     *  method to swap two elements in the array
     *
     * @param firstIdx
     * @param secondIdx
     */
    public void swap(int firstIdx, int secondIdx) {
        // store the value of the first element in a temporary variable
        int temp = arr[firstIdx];
        // assign the value of the second element to the first element
        arr[firstIdx] = arr[secondIdx];
        // assign the value of the temporary variable (first element) to the second element
        arr[secondIdx] = temp;
    }

    /**
     * override the toString method to return a string representation of the array
     *
     * @return
     */
    @Override
    public String toString() {
        // start the string with the first element in square brackets
        String s = "[" + arr[0];

        // loop through the rest of the array and add each element separated by a comma
        for (int index = 1; index < arr.length; index++) {
            s += ", " + arr[index];
        }
        // end the string with a closing square bracket
        s += "]";

        // return the string representation of the array
        return s;
    }
}
