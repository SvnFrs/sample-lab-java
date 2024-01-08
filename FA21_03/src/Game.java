import java.util.Random;

public class Game {
    // Give the game the range of pseudorandom number
    private final int maxNum = 11;
    // Contain player guessing number
    private int playerNumber;
    // Contain pseudorandom number
    private int randomNumber;
    // Contain total number of guesses per game
    private int guessCount;

    /**
     * Create a default constructor that generate a random integer
     */
    public Game() {
        random();
    }

    /**
     * Get the number from player
     * @return playerNumber
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * Set the number for player
     * @param playerNumber int
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     * Get the random number
     * @return randomNumber
     */
    public int getRandomNumber() {
        return randomNumber;
    }

    /**
     * Get the total number of guess per game
     * @return guessCount
     */
    public int getGuessCount() {
        return guessCount;
    }

    /**
     * Generate a random integer
     */
    public void random() {
        Random rand = new Random(); // Create an instance from Random class

        randomNumber = rand.nextInt(maxNum); // Generate random integer with given range
    }

    /**
     * Return decrement value for comparison
     * @return playerNumber - randomNumber
     */
    public int checkNum() {
        return playerNumber - randomNumber;
    }

    /**
     * Increase number of guess by 1
     */
    public void countGuess() {
        guessCount++;
    }

}
