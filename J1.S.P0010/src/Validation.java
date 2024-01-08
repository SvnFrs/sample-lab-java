/**
 * Validation class
 * Handle input validation, such as range, non-numerical, etc.
 */
public class Validation {

    /**
     * Validate input with starting and ending given range
     *
     * @param value input value
     * @param fromRange range
     * @param toRange range
     * @return value
     */
    public static int checkRange(int value, int fromRange, int toRange) {
        if (value < fromRange || value > toRange) { // Throw when user input is out of range
            throw new NumberFormatException("Please only enter integer from " + fromRange + " to " + toRange);
        } else {
            return value;
        }
    }

    /**
     * Validate input with starting given range
     *
     * @param value input value
     * @param fromRange range
     * @return value
     */
    public static int checkRange(int value, int fromRange) {
        if (value < fromRange) { // Throw when user input is less than range value
            throw new NumberFormatException("Please only enter integer from " + fromRange);
        } else {
            return value;
        }
    }
}
