import java.util.Scanner;
import java.util.ArrayList;

public class GameManagement {
    // Contain total games
    private int totalGames;
    // Contain total guesses of every game
    private int totalGuesses;
    // Contain average guess per game
    private double guessAvg;
    // Contain best game number
    private int bestGame;
    // Store array of each game number of guesses
    private static ArrayList<Integer> gameStatistic;

    /**
     * Start the game
     */
    public void play() {
        // Create an instance of Scanner class
        Scanner input = new Scanner(System.in);
        // Initialize game report list
        gameStatistic = new ArrayList<>();
        System.out.println("Welcome to \"NUMBER GUESSER\" game!");

        // Loop until player stop playing
        while (true) {
            System.out.println("===========================");
            System.out.println("Generating numbers...");
            Game game = new Game(); // Create an instance of Game class
            while (true) { // Loop until player answer is correct
                try {
                    game.countGuess(); // Increase the number for each guesses
                    System.out.print("Please enter your guess: ");
                    // Taking player input value
                    game.setPlayerNumber(Integer.parseInt(input.nextLine()));

                    // Checking winning condition
                    if (game.checkNum() == 0) { // Win condition
                        System.out.println("You win!");
                        break;
                    } else if (game.checkNum() < 0) { // Expect higher input value
                        System.out.println("- Higher number please!");
                    } else { // Expect lower input value
                        System.out.println("- Lower number please!");
                    }
                } catch (IllegalArgumentException iae) { // Throw when input value is non-numerical
                    System.out.println("- Please enter integer value only!");
                }
            }
            // Add new data to list
            gameStatistic.add(game.getGuessCount());

            // Continue new game
            System.out.print("Please input \"Yes\" or \"Y\" to continue playing: ");
            // Finish the game in print game report
            if (!checkGameLoop(input.nextLine())) {
                // Print report
                System.out.println("===========================");
                System.out.println("Game Results:");
                System.out.println(report());
                System.out.println("== Thanks for playing my game! ==");
                return;
            }
        }
    }

    /**
     * Display game report
     * @return String
     */
    /**
     * Display game report
     * @return String
     */
    public String report() {
        countGuess(); // Get total number of guess and average guess
        findBestGame(); // Get the index of the least guess game

        String rp = "Total games played: " + gameStatistic.size(); // Get total game played
        rp += "\nTotal guesses made: " + totalGuesses;
        rp += "\nAverage guess was: " + guessAvg;
        rp += "\nBest game had " + gameStatistic.get(bestGame - 1) + " guesses";

        return rp;
    }


    /**
     * Get the order number of game with the least guesses
     */
    public void findBestGame() {
        int min = gameStatistic.get(0); // Initial first element as the least element
        int index = 0;
        for (int i = 1; i < gameStatistic.size(); i++) {
            if (i < min) { // get new index and new element if new element is less than current element
                min = gameStatistic.get(i);
                index = i;
            }
        }

        // Set the order number of game with the least guesses
        bestGame = index + 1;
    }

    /**
     * Check if player want to continue playing
     * @param loop String
     * @return boolean
     */
    public static boolean checkGameLoop(String loop) {
        loop = loop.trim();

        // Looping condition
        return loop.equalsIgnoreCase("Y") || loop.equalsIgnoreCase("YES");
    }

    /**
     * Get number of guesses of every game
     */
    public void countGuess() {
        int total = 0; // Store number of guesses
        for (int i : gameStatistic) {
            total += i;
        }
        // Set number of guesses
        totalGuesses = total;
        //Set average number of guesses per game
        guessAvg = (double) total / gameStatistic.size();
    }
}
