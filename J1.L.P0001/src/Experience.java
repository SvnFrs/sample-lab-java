import java.util.Date;
import java.util.Scanner;
/**
 * The Experience class which extends the Candidate class.
 * This class is used to store information of an experience candidate.
 * @author IuseArchBTW
 */
public class Experience extends Candidate {
    private int ExpInYear;
    private String ProSkill;

    /**
     * The experience input method which overrides the input method in the Candidate class.
     * This method is used to input the information of an experience candidate.
     */
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        // call input method from superclass to input Name, Age, and Address
        super.input();
        // set candidate type to 0
        super.setCandidateType(0);
        // set candidate type to Experience
        super.setCandidateTypeName("Experience");

        System.out.print("Professional Skill: ");
        // loop to input and validate the professional skill
        while (true) {
            try {
                // read the input for professional skill
                this.ProSkill = sc.nextLine().trim();
                // check if the input is a string with minimum 2 characters
                if (!isValidProSkill(getProSkill())) {
                    System.out.println("ProSkill: Must be a set of characters with minimum 2 characters");
                    System.out.print("Professional Skill: ");
                } else {
                    this.ProSkill = toTitleCase(this.ProSkill);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

        System.out.print("Year of experience: ");
        // loop to input and validate the year of experience
        while (true) {
            try {
                this.ExpInYear = Integer.parseInt(sc.nextLine().trim());
                //if birthdate is equal to current year then exp can only be  0
                if (super.getBirthDate() == (new Date().getYear() + 1900) && this.ExpInYear != 0) {
                    System.out.println("Experience can only be 0 as your birthdate: " + super.getBirthDate() + " is equal to current year: " + (new Date().getYear() + 1900));
                    System.out.print("Year of experience: ");
                }
                // check if the experience is between 0 and current year - birthdate
                else
                if (this.ExpInYear < 0 || this.ExpInYear > (new Date().getYear() + 1900 - super.getBirthDate())) {
                    System.out.println("Experience must be from 0 to " + (new Date().getYear() + 1900 - super.getBirthDate()) + " [Birthdate: " + super.getBirthDate() + ", Current year: " + (new Date().getYear() + 1900) + "]");
                    System.out.print("Year of experience: ");
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Year of experience must be an integer");
                System.out.print("Year of experience: ");
            }
        }
    }


    /**
     * The method which check if the professional skill is valid.
     *
     * @param proSkill
     * @return
     */
    private boolean isValidProSkill(String proSkill) {
        return proSkill.length() >= 2 && proSkill.matches("[a-zA-Z ]+");
    }

    /**
     * Returns the number of years of experience.
     *
     * @return the number of years of experience
     */
    public int getExpInYear() {
        return ExpInYear;
    }

    /**
     * Sets the number of years of experience.
     *
     * @param expInYear the number of years of experience
     * @throws IllegalArgumentException if the input is not valid
     */
    public void setExpInYear(int expInYear) {
        if (isValidExp(expInYear)) {
            ExpInYear = expInYear;
        } else {
            throw new IllegalArgumentException("Experience must be from 0 to " + (new Date().getYear() + 1900 - super.getBirthDate()) + "");
        }
    }

    /**
     * Returns the professional skill of the candidate.
     *
     * @return the professional skill of the candidate
     */
    public String getProSkill() {
        //if proskill is longer than 20 characters then return the first letter of each word
        if (ProSkill.length() > 17) {
            String[] words = ProSkill.split(" ");
            String result = "";
            for (String word : words) {
                result += word.charAt(0);
            }
            return result;
        }
        return ProSkill;
    }

    /**
     * Sets the professional skill of the candidate.
     *
     * @param proSkill the professional skill of the candidate
     */
    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    /**
     * Checks whether the input is a valid number of years of experience.
     *
     * @param expInYear the number of years of experience to check
     * @return true if the input is valid, false otherwise
     */
    public boolean isValidExp(int expInYear) {
        return expInYear >= 0 && expInYear <= new Date().getYear() + 1900 - super.getBirthDate();
    }
    /**
     * The toString method which overrides the toString method in the Candidate class.
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "Experience [ExpInYear=" + ExpInYear + ", ProSkill=" + ProSkill + "]";
    }
}
