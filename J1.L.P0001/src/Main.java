/**
 * This class is the entry point of the application.
 * @author IuseArchBTW
 */
public class Main {
    /**
     * The main method of the application.
     * @param args
     */
    public static void main(String[] args) {
        // Try to create a new instance of the CandidateManagement class and call its CreateTable method
        try {
            new CandidateManagement().CreateTable();
        }
        // Catch any exception that occurs during the execution of the CreateTable method
        catch (Exception e) {
            // Print an error message to the console indicating the exception message
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}