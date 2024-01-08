import java.util.Scanner;

public class WordCount {

    /**
     * The main method for the FrontEnd class.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Scanner to read input from the user
        WordCountBackEnd wc;  // WordCount object to store the count of words and characters

        // Loop until the user enters a valid input
        while (true) {
            try {
                System.out.println("Enter your content:");
                wc = new WordCountBackEnd(input.nextLine());  // Initialize the WordCount object with user input
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());  // Print any exceptions caught
            }
        }

        // Call the countLetter method of the WordCount object
        wc.countLetter();
        // Print the count of letters by calling the printLetter method of the WordCount object
        System.out.println(wc.printLetter());

        // Call the countCharacter method of the WordCount object
        wc.countCharacter();
        // Print the count of characters by calling the printCharacter method of the WordCount object
        System.out.println(wc.printCharacter());
    }
}
