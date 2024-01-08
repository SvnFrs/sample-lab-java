import java.util.Scanner;
/**
 * The Intern class which extends the Candidate class.
 * This class is used to store information of a fresher candidate.
 * @author IuseArchBTW
 */
public class Intern extends Candidate {
    private String Majors;
    private String Semester;
    private String UniversityName;

    public Intern() {
    }

    /**
     * The input method which overrides the input method in the Candidate class.
     * This method is used to input the information of a fresher candidate.
     */
    @Override
    public void input() {
        // Initialize a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Call the input() method of the parent class (super class) to get common information for all candidate types
        super.input();

        // Set the candidate type to 2 (Student)
        super.setCandidateType(2);
        // set candidate type to Intern
        super.setCandidateTypeName("Intern");

        // Get the major of the student
        System.out.print("Major: ");
        // Keep asking for input until the user provides a valid major
        do {
            try {
                // Read the input for major
                this.Majors = sc.nextLine().trim();
                // Check if the input is valid according to the isValidMajors() method
                if (!isValidMajors(getMajors())) {
                    System.out.println("Major: Must be a set of letters with minimum 2 characters");
                    System.out.print("Major: ");
                } else {
                    // If the input is valid, break out of the loop
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (true);

        // Get the semester of the student
        System.out.print("Semester: ");
        // Keep asking for input until the user provides a valid semester
        do {
            try {
                // Read the input for semester
                this.Semester = sc.nextLine().trim();
                // Check if the input is valid according to the isValidSemester() method
                if (!isValidSemester(getSemester())) {
                    System.out.println("Semester: Must be a set of character with minimum 2 characters");
                    System.out.print("Semester: ");
                } else {
                    // If the input is valid, break out of the loop
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (true);

        // Get the name of the university the student is attending
        System.out.print("University name: ");
        // Keep asking for input until the user provides a valid university name
        do {
            try {
                // Read the input for university name
                this.UniversityName = sc.nextLine().trim();
                // Check if the input is valid according to the isValidUniversityName() method
                if (!isValidUniversityName(getUniversityName())) {
                    System.out.println("University name: Must be a set of characters and can't contain special character and empty");
                    System.out.print("University name: ");
                } else {
                    // If the input is valid, break out of the loop
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (true);
    }

    /**
     * The method which check if the university name is valid
     * @param universityName
     */
    private boolean isValidUniversityName(String universityName) {
        // cant contain special character
        return !universityName.isEmpty() && universityName.matches("[a-zA-Z0-9 ]+");
    }

    /**
     * The method which check if the semester is valid
     * @param semester
     */
    private boolean isValidSemester(String semester) {
        //allow number too
        return semester.length() >= 2 && semester.matches("[a-zA-Z0-9 ]+");
    }

    /**
     * The method which check if the major is valid
     * @param majors
     */
    private boolean isValidMajors(String majors) {
        return majors.length() >= 2 && majors.matches("[a-zA-Z ]+");
    }

    /**
     * Return the major of the student
     * @return
     */
    public String getMajors() {
        return Majors;
    }

    /**
     * Set the major of the student
     * @param majors
     */
    public void setMajors(String majors) {
        Majors = majors;
    }

    /**
     * Return the semester of the student
     * @return
     */
    public String getSemester() {
        return Semester;
    }

    /**
     * Set the semester of the student
     * @param semester
     */
    public void setSemester(String semester) {
        Semester = semester;
    }

    /**
     * Return the name of the university the student is attending
     * @return
     */
    public String getUniversityName() {
        return UniversityName;
    }

    /**
     * Set the name of the university the student is attending
     * @param universityName
     */
    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    /**
     * The getInformation() method which overrides the getInformation() method in the Candidate class.
     * This method is used to get the information of a fresher candidate.
     */
    @Override
    public String toString() {
        return super.toString() + "Intern [Majors=" + Majors + ", Semester=" + Semester + ", UniversityName=" + UniversityName + "]";
    }
}
