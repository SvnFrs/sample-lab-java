/**
 * J1.S.P0009 - BMI Calculator
 */
public class Main {
    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator(); // Create a new Calculator object
            calculator.menu();
        } catch //Catch all exceptions
            (Exception e) {
                System.out.println("Found exception: " + e.getMessage());
        }
    }
}
