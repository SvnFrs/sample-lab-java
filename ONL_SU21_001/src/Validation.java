import java.util.ArrayList;

public class Validation {

    //Create regex pattern to check for valid ID syntax
    private static final String idCheck = "(NV)[0-9]{4}";

    /**
     * Validate employee ID
     *
     * @param id Employee ID
     * @return id
     */
    public static String checkId(String id) {
        id = checkString(id); // Check empty string
        if (!id.matches(idCheck)) { // Check valid ID syntax
            throw new IllegalArgumentException("--------Error! Please id number again (NVxxxx): ");
        }

        return id;
    }

    /**
     * Validate employee name
     *
     * @param name Employee name
     * @return name
     */
    public static String checkName(String name) {
        if (name.trim().isEmpty()) { // Check empty employee name
            throw new IllegalArgumentException("--------Error! Please name again (Not Null): ");
        }
        return name;
    }

    /**
     * Validate input string
     *
     * @param str Input string
     * @return str
     */
    public static String checkString(String str) {
        if (str.trim().isEmpty()) { // Check empty String
            throw new IllegalArgumentException("--------Error! Value is empty, enter again: ");
        }

        return str;
    }

    /**
     * Validate input number
     *
     * @param str Input string
     * @return digit
     */
    public static int checkDigit(String str) {
        try { // Check non-numerical value
            int digit = Integer.parseInt(str);
            return digit;
        } catch (NumberFormatException nfe) { // Throw when inputted value is non-numerical
            throw new IllegalArgumentException("--------Error! Value is invalid, enter again: ");
        }
    }

    /**
     * Validate employee salary
     *
     * @param salary Employee salary
     * @return salary
     */
    public static double checkSalary(double salary) {
        if (salary < 100) { // Throw when employee salary is less than 100
            throw new IllegalArgumentException("--------Error! Please salary again (Salary >= 100 USD): ");
        }

        return salary;
    }

    /**
     * Validate employee COE value
     *
     * @param coe Employee COE value
     * @return coe
     */
    public static double checkCOE(double coe) {
        if (coe < 1 || coe > 5) { // Throw when employee COE value is out of range
            throw new IllegalArgumentException("-----Error! Please coefficients salary again (From 1 to 5): ");
        }

        return coe;
    }

    /**
     * Validate inputted range
     *
     * @param value Input value
     * @param fromRange From range
     * @param toRange To range
     * @return value
     */
    public static int checkRange(int value, int fromRange, int toRange) {
        if (value < fromRange || value > toRange) { // Throw when inputted value is out of range
            throw new IllegalArgumentException("--------Error! Please choice again (From " + fromRange + " to " + toRange + "): ");
        }

        return value;
    }

    /**
     * Validate input range
     *
     * @param value Input value
     * @param fromRange From range
     * @return value
     */
    public static int checkRange(int value, int fromRange) {
        if (value < fromRange) { // Throw when inputted value is out of range
            throw new IllegalArgumentException("--------Error! Please choice again (From " + fromRange + "): ");
        }

        return value;
    }
}
