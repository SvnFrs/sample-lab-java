/**
 * This class is used to sort an array of integers in ascending or descending
 * which implements ISort interface.
 */
public class Sort implements SortInterface {

    private int length; // Store array length
    private int[] arr; // Store array of inputted elements

    /**
     * Create a default constructor that initialize array with length of 0
     */
    public Sort() {
        length = 0; // Set length to zero
        arr = new int[length]; // Initialize array with length of 0         
    }

    /**
     * Create a constructor that initialize an array with given length
     *
     * @param length
     */
    public Sort(int length) {
        setLength(length); // Set length for array
        arr = new int[length]; // Initialize array with given length         
    }

    /**
     * Get the array length
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * Set the length for array
     *
     * @param length
     */
    public void setLength(int length) {
        length = Validation.checkRange(length, 1); // Validate length
        this.length = length;
    }

    /**
     * Assign new value to array with given index
     *
     * @param index
     * @param value
     */
    public void add(int index, int value) {
        arr[index] = value;
    }

    /**
     * Display the initial unsorted array with given format
     *
     * @return String
     */
    @Override
    public String toString() {
        String s = "[" + arr[0] + "]"; // Display the first array element
        for (int i = 1; i < arr.length; i++) {
            s += ", [" + arr[i] + "]"; // Display the rest of array elements
        }

        return s;
    }

    /**
     * Sort the array in ascending order using Bubble sort algorithm
     *
     * @return sorted array in ascending order
     */
    @Override
    public int[] sortAscending() {
        int[] newArr = arr; // Store initial array

        // Sort the array
        for (int i = arr.length - 1; i >= 0; i--) { // Traverse through the array in reverse order
            for (int j = 0; j < i; j++) { // Loop until array is reached at assigned index
                if (newArr[j] > newArr[j + 1]) { // Swap when first element is greater than second element
                    int temp = newArr[j]; // Store first element value in temporary variable 
                    newArr[j] = newArr[j + 1]; // Assign second element value to first element value
                    newArr[j + 1] = temp; // Assign temporary value to second element value
                }
            }
        }

        // Return the sorted array in ascending order
        return newArr;
    }

    /**
     * Sort the array in descending order using Bubble sort algorithm
     *
     * @return int[]
     */
    @Override
    public int[] sortDescending() {
        int[] newArr = arr; // Store initial array

        // Sort the array
        for (int i = arr.length - 1; i >= 0; i--) { // Traverse through the array in reverse order
            for (int j = 0; j < i; j++) { // Loop until array is reached at assigned index
                if (newArr[j] < newArr[j + 1]) { // Swap when first element is less than second element
                    int temp = newArr[j]; // Store first element value in temporary variable 
                    newArr[j] = newArr[j + 1]; // Assign second element value to first element value
                    newArr[j + 1] = temp; // Assign temporary value to second element value
                }
            }
        }

        // Return the sorted array in descending order
        return newArr;
    }
}
