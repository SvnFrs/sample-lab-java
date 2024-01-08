public class Main {

    private static GameManagement gm;

    /**
     * The main method of this program
     * @param args
     */
    public static void main(String[] args) {
        try {

            gm = new GameManagement(); // Create an instance of GameManagement class

            gm.play(); // Start the game

        }   // Catch all exceptions
            catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

