import java.util.Random;

public class InsertionSortBackEnd {

    // declare an array of integers called "arr"
    private int[] arr;

    /**
     * constructor for the BackEnd class, which takes in the size of the array as an argument
     *
     * @param arrSize
     * @throws Exception
     */
    public InsertionSortBackEnd(int arrSize) throws Exception {
        // if the size of the array is less than or equal to zero, throw an exception with an error message
        if (arrSize <= 0) {
            throw new Exception("The array size must be a positive integer!");
            // otherwise, create an array of the specified size and call the generateArray method with the array size as an argument
        } else {
            arr = new int[arrSize];
            generateArray(arrSize);
        }
    }

    /**
     * method to generate an array of random integers with a value between 0 and 100
     *
     * @param arrSize
     */
    public void generateArray(int arrSize) {
        // create a new Random object
        Random rand = new Random();

        // loop through the array and fill each element with a random integer between 0 and 100
        for (int index = 0; index < arr.length; index++) {

            arr[index] = rand.nextInt(100);
        }
    }

    /**
     * method to sort the elements in the array in ascending order
     */
    public void sort() {
        int element;

        // loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {

            // set the current element to "element"
            element = arr[i];
            // loop through the elements before the current element
            for (int j = i - 1; j >= 0; j--) {
                // if the current element is smaller than the previous element, swap them
                if (element < arr[j]) {
                    swap(j + 1, j);
                } else {
                    // if the current element is greater than or equal to the previous element, stop looping
                    break;
                }
            }
        }
    }

    /**
     * method to swap two elements in the array
     *
     * @param firstIdx
     * @param secondIdx
     */
    public void swap(int firstIdx, int secondIdx) {
        // store the value of the first element in a temporary variable
        int temp = arr[firstIdx];
        // set the value of the first element to the value of the second element
        arr[firstIdx] = arr[secondIdx];
        // set the value of the second element to the value stored in the temporary variable
        arr[secondIdx] = temp;
    }

    /**
     *  method to return a string representation of the array
     *
     * @return
     */
    @Override
    public String toString() {
        // start the string with an opening square bracket and the first element in the array
        String s = "[" + arr[0];

        // loop through the rest of the elements in the array and add each one to the string with a comma in between
        for (int index = 1; index < arr.length; index++) {
            s += ", " + arr[index];
        }
        // add a closing square bracket to the end of the string
        s += "]";

        // return the final string
        return s;
    }
}
