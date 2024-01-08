import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * This class implements a word counting algorithm.
 * Given a string, it can count the number of occurrences of each character and each word in the string.
 */
public class WordCountBackEnd {

    /**
     * Create a HashMap to store the count of each word in the input string.
     */
    private HashMap<String, Integer> letterCounter;

    /**
     * Create HashMap to store the count of each character in the input string.
     */
    private HashMap<Character, Integer> characterCounter;

    /**
     * The input string to be processed.
     */
    private String content;

    /**
     * Creates a new WordCount object with a specified input string.
     *
     * @param content The input string to be processed.
     * @throws Exception If the input string is empty.
     */
    public WordCountBackEnd(String content) throws Exception {
        setString(content);
    }

    /**
     * Get the input string to be processed.
     *
     * @return The input string to be processed.
     */
    public String getString() {
        return content;
    }

    /**
     * Sets the input string to be processed.
     *
     * @param content The input string to be processed.
     * @throws Exception If the input string is empty.
     */
    public void setString(String content) throws Exception {
        if (content.trim().equals("")) {
            throw new Exception("The string cannot be empty!");
        }

        this.content = content;
    }

    /**
     * Count the number of occurrences of each character in the input string.
     * The spaces in the input string are removed before counting.
     */
    public void countCharacter() {
        int count;
        characterCounter = new HashMap<>();

        String newStr = content.replaceAll(" ", ""); // Remove spaces from the input string
        for (int index = 0; index < newStr.length(); index++) {
            char c = newStr.charAt(index);                              // Get the character at the current index
            if (characterCounter.containsKey(c)) {
                count = characterCounter.get(c);                        // Get the count of the character
                characterCounter.put(c, count + 1);
            } else {
                characterCounter.put(c, 1);
            }
        }
    }

    /**
     * Counts the number of occurrences of each word in the input string.
     * The input string is first converted to lowercase, and then the words are separated based on specified delimiters.
     */
    public void countLetter() {
        int count;
        String newStr = content.toLowerCase();
        StringTokenizer stk = new StringTokenizer(newStr, "~`!@#$%^&*()_=+[{]}\\|;:'\",<.>/? "); // Specify delimiters to remove special characters

        letterCounter = new HashMap<>();

        while (stk.hasMoreTokens()) {
            // Get the next token (word) from the string
            String letter = stk.nextToken();

            if (letterCounter.containsKey(letter)) {
                // If the word already exists in the map, increment its count
                count = letterCounter.get(letter);
                letterCounter.put(letter, count + 1);
            } else {
                // If the word does not exist in the map, add it with a count of 1
                letterCounter.put(letter, 1);
            }
        }
    }

    /**
     * Returns a string containing the count of each character in the input string.
     *
     * @return A string containing the count of each character in the input string.
     */
    public String printCharacter() {
        String s = "{";
        int count = 0;
        for (Map.Entry<Character, Integer> set : characterCounter.entrySet()) {

            if (count == 0) {
                s += set.getKey() + "=" + set.getValue();           // Add the first entry to the string
            } else {
                s += ", " + set.getKey() + "=" + set.getValue();    // Add the rest of the entries to the string
            }
            count++;
        }
        s += "}";
        return s;
    }


    /**
     * Return a string containing the count of each word in the input string.
     *
     * @return A string containing the count of each word in the input string.
     */
    public String printLetter() {
        String s = "{";
        int count = 0;
        for (Map.Entry<String, Integer> set : letterCounter.entrySet()) {

            if (count == 0) {
                s += set.getKey() + "=" + set.getValue();          // Add the first entry to the string
            } else {
                s += ", " + set.getKey() + "=" + set.getValue();   // Add the rest of the entries to the string
            }
            count++;
        }
        s += "}";
        return s;
    }
}
