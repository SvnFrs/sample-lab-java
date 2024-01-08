class Fibonacci {
    /**
     * The main method for the Fibonacci class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of the FibonacciBackend class
        FibonacciBackend fib = new FibonacciBackend();

        try {
            // Set the size of the Fibonacci sequence to 45
            fib.setFibonacciSize(45);
            // Print the message "The 45 sequence Fibonacci:"
            System.out.println("The 45 sequence Fibonacci:");
            // Print the string representation of the fib object
            System.out.println(fib.toString());
        } catch (NumberFormatException nfe) {
            // If a NumberFormatException is caught, print the message "The Fibonacci size must be greater than 0"
            System.out.println("The Fibonacci size must be greater than 0");
        } catch (Exception e) {
            // If any other exception is caught, print the message returned by e.getMessage()
            System.out.println(e.getMessage());
        }
    }
}
