public class Main {
    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            Algo utils = new Algo();
            utils.begin();
            utils.midTerm();
            utils.finalTerm();
            utils.homework();
            utils.report();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}