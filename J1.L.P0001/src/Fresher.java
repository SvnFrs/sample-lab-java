import java.util.Scanner;
import java.util.Date;
/**
 * The Fresher class which extends the Candidate class.
 * This class is used to store information of a fresher candidate.
 * @author IuseArchBTW
 */
public class Fresher extends Candidate {
    private String GraduationDate;
    private String GraduationRank;
    private String Education;
    private Date currentDate = new Date();

    public Fresher() {
    }

    /**
     * The input method which overrides the input method in the Candidate class.
     * This method is used to input the information of a fresher candidate.
     */
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);

        // Call the input method from the superclass to input common information
        super.input();

        // Set candidate type as Fresher
        super.setCandidateType(1);
        // set candidate type to Fresher
        super.setCandidateTypeName("Fresher");

        // Input Graduation Date
        System.out.print("Graduation Date: ");
        do {
            try {
                this.GraduationDate = sc.nextLine().trim();
                // if birthday equal to current year then graduation date can only be current year
                if (String.valueOf(getBirthDate()).equals(String.valueOf(currentDate.getYear() + 1900))) {
                    if (!isValidGraduationDate(getGraduationDate()) || !getGraduationDate().equals(String.valueOf(currentDate.getYear() + 1900))) {
                        System.out.println("Graduation Date: Must only be " + (currentDate.getYear() + 1900) + " as your birthdate: " + getBirthDate() + " is equal to current year: " + (currentDate.getYear() + 1900));
                        System.out.print("Graduation Date: ");
                    }
                    else if (getBirthDate() > Integer.parseInt(getGraduationDate())) {
                        System.out.println("Graduation Date:  Cannot be less than your birthdate: " + getBirthDate() + " [Birthdate: " + getBirthDate() + ", Current year: " + (currentDate.getYear() + 1900) + "]");
                        System.out.print("Graduation Date: ");
                    }
                    else {
                        break;
                    }
                }
                // Validate Graduation Date input
                else
                if (!isValidGraduationDate(getGraduationDate())) {
                    System.out.println("Graduation Date: Must be from " + getBirthDate() +" to "+ (currentDate.getYear()+ 1900) + " and in the format yyyy");
                    System.out.print("Graduation Date: ");
                }

                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (true);

        // Create a menu to select the rank of graduation
        GraduationRank = new CustomTable().createMenu("Rank of Graduation", "Excellence, Good, Fair, Poor".split(", "), CustomTable.DATA);

        // Input Education
        System.out.print("Education: ");
        do {
            try {
                this.Education = sc.nextLine().trim();
                // Validate Education input
                if (!isValidEducation(getEducation())) {
                    System.out.println("Education: Must be a set of string with a minimum of 2 characters");
                    System.out.print("Education: ");
                } else {
                    // Shorten long university names
                    String[] words = getEducation().split("\\s+");
                    if (words.length > 4) {
                        StringBuilder sb = new StringBuilder();
                        for (String word : words) {
                            sb.append(Character.toUpperCase(word.charAt(0))).append(". ");
                        }
                        sb.append("Uni");
                        this.Education = sb.toString();
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (true);
    }


    /**
     * The method which check if the education is valid.
     * @param education
     * @return
     */
    private boolean isValidEducation(String education) {
        return education.length() >= 2 && education.matches("[a-zA-Z ]+");
    }

    /**
     * The method which check if the graduation date is valid.
     * @param graduationDate
     * @return
     */
    private boolean isValidGraduationDate(String graduationDate) {
        return graduationDate.length() == 4 && graduationDate.matches("[0-9]+") && Integer.parseInt(graduationDate) >= super.getBirthDate() && Integer.parseInt(graduationDate) <= currentDate.getYear()+ 1900;
    }

    /**
     * return the graduation date
     * @return
     */
    public String getGraduationDate() {
        return GraduationDate;
    }

    /**
     * set the graduation date
     * @param graduationDate
     */
    public void setGraduationDate(String graduationDate) {
        GraduationDate = graduationDate;
    }

    /**
     * return the graduation rank
     * @return
     */
    public String getGraduationRank() {
        return GraduationRank;
    }

    /**
     * set the graduation rank
     * @param graduationRank
     */
    public void setGraduationRank(String graduationRank) {
        GraduationRank = graduationRank;
    }

    /**
     * return the education
     * @return
     */
    public String getEducation() {
        return Education;
    }

    /**
     * set the education
     * @param education
     */
    public void setEducation(String education) {
        Education = education;
    }

    /**
     * The method which overrides the toString method in the Candidate class.
     * This method is used to display the information of a fresher candidate.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "Fresher [GraduationDate=" + GraduationDate + ", GraduationRank=" + GraduationRank + ", Education=" + Education + "]";
    }
}
