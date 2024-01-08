import java.util.Random;

/**

 The BubbleSortBackEnd class is responsible for the backend processing of the bubble sort algorithm.
 */
public class BubbleSortBackEnd {

    private int[] arr; // instance variable to store the array
    private int arrSize; // instance variable to store the size of the array

    /*
    Empty constructor
    */
    public BubbleSortBackEnd() {
    }

    /**
     Constructor which initializes the size of the array
     @param arrSize the size of the array to be created
     @throws Exception if the array size is less than or equal to 0
     */
    public BubbleSortBackEnd(int arrSize) throws Exception {
        while (true) {
            try {
                setSize(arrSize);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number again.");
            }
        }

    }

    /**
     Sets the size of the array
     @param arrSize the size of the array to be created
     @throws Exception if the array size is less than or equal to 0
     */
    public void setSize(int arrSize) throws Exception {
        if (arrSize <= 0) {
            throw new Exception("The array size must be a positive integer!"); // throw an exception if the size is less than or equal to 0
        }
        this.arrSize = arrSize;
    }

    /**
     Gets the size of the array
     @return the size of the array
     */
    public int getSize() {
        return arrSize;
    }

    /**

     Method which generates a random array of the specified size
     */
    public void generateArray() {
        Random rand = new Random(); // create a Random object to generate random numbers
        arr = new int[this.arrSize]; // allocate memory to the array with the specified size

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100); // generate a random number less than 100 and store it in the array
        }
    }

    /**
     Method which returns a string representation of the array
     @return a string representation of the array
     */
    @Override
    public String toString() {
        String result = "[" + arr[0]; // start the result with the first element of the array
        for (int index = 1; index < arr.length; index++) {
            result += ", " + arr[index]; // add the remaining elements of the array with a comma separator
        }
        result += "]";
        return result;
    }

    /**
     Sorts the array using the bubble sort algorithm
     */
    public void sort() {
        int remain = arr.length; // initialize the number of elements that need to be sorted
        while (remain >= 2) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) // compare adjacent elements
                {
                    swap(i, i + 1); // swap the elements if they are in the wrong order
                }
            }
            remain--;
        }
    }

    /**
     Swaps the elements at the specified indices in the array
     @param firstIdx the index of the first element
     @param secondIdx the index of the second element
     */
    public void swap(int firstIdx, int secondIdx) {
        int temp = arr[firstIdx]; // store the first element in a temporary variable
        arr[firstIdx] = arr[secondIdx]; // copy the second element to the first position
        arr[secondIdx] = temp; // copy the first element to the second position
    }
}