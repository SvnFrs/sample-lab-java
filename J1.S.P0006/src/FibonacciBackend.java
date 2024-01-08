import java.util.Arrays;

public class FibonacciBackend {
    // instance variable to store the size of the Fibonacci sequence
    private int fibonacciSize;
    // array to store the results of the Fibonacci calculations for memoization
    private int[] memo;

    // default constructor
    public FibonacciBackend() {
    }

    /**
     * constructor with a specified size
     *
     * @param fibonacciSize
     * @throws Exception
     */
    public FibonacciBackend(int fibonacciSize) throws Exception {
        setFibonacciSize(fibonacciSize);
    }

    /**
     *  getter method for the size of the Fibonacci sequence
     *
     * @return
     */
    public int getFibonacciSize() {
        return fibonacciSize;
    }

    /**
     * setter method for the size of the Fibonacci sequence
     *
     * @param fibonacciSize
     * @throws Exception
     */
    public void setFibonacciSize(int fibonacciSize) throws Exception {
        // if the size is less than 0, throw an exception
        if (fibonacciSize < 0) {
            throw new Exception("The Fibonacci size must be greater than 0");
        }
        this.fibonacciSize = fibonacciSize;
        // initialize the memo array with -1 values to indicate that the results are not yet computed
        memo = new int[fibonacciSize];
        Arrays.fill(memo, -1);
    }

    /**
     * recursive method to calculate the Fibonacci number at a specified position
     *
     * @param i
     * @return
     */
    public int getFibonacciNumber(int i) {
        // base cases: if i is 0 or 1, return i
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        }
        // check if the result is already stored in memo
        if (memo[i] != -1) {
            return memo[i];
        }
        // if the result is not yet stored in memo, calculate it and store it in memo
        memo[i] = getFibonacciNumber(i - 1) + getFibonacciNumber(i - 2);
        return memo[i];
    }

    /**
     *  method to generate a string representation of the Fibonacci sequence
     *
     * @return
     */
    @Override
    public String toString() {
        // start with the first Fibonacci number
        String result = "" + getFibonacciNumber(0);
        // append the remaining Fibonacci numbers separated by commas
        for (int i = 1; i < fibonacciSize; i++) {
            result += ", " + getFibonacciNumber(i);
        }
        return result;
    }
}
