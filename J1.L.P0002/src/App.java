/**
 * The App class contains the main method for the student management application.
 */
public class App {

    /**
     * The main method initializes a StudentManagement object and calls its initMenu method to start the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        StudentManagement MyClassRoom = new StudentManagement();
        MyClassRoom.initMenu();
    }
}
