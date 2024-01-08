
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to calculate the weighted score of the midterm, final term
 * exam and homework
 */

public class Algo {
    static Scanner myInput = new Scanner(System.in);
    // A static variable that is used to store the maximum weight of the course.
    static int MAX_WEIGHT = 100;
    // A static variable that is used to store the maximum weight of the course.
    static int MAX_ATTEND_POINT = 30;
    // A static variable that is used to store the maximum score of the assignment.
    static int MAX_ASSIGNMENT_SCORE = 150;

    // A static variable that is used to store the weighted score of the midterm
    // exam.
    static double midTermWeightScore = 0.0;
    // A static variable that is used to store the weighted score of the final exam.
    static double finalTermWeightScore = 0.0;
    // A static variable that is used to store the weighted score of the homework.
    static double homeworkWeightScore = 0.0;

    // Creating an integerListay list of IntPair objects.
    static ArrayList<IntPair> valuesPair = new ArrayList<>();

    /**
     * This function prints out a message to the user
     */
    public void begin() {
        System.out.println("This program read exam/homework scores " + "\n" + "and report your overall course grade.");
    }

    /**
     * This function is used to calculate the weighted score of the midterm exam
     */
    public void midTerm() {
        int weight;
        int scoreEarned;
        int shiftAmount;
        int totalScore;
        String choice;
        System.out.println("Midterm: ");
        System.out.print("Weight (0-100)? ");
        weight = weightValidate();
        System.out.print("Score earned? ");
        scoreEarned = scoreValidate();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        while (true) {
            choice = myInput.nextLine();
            if (choice.equals("1")) {
                System.out.print("Shift amount? ");
                shiftAmount = ShiftAmountValidate();
                totalScore = scoreEarned + shiftAmount;
                if (totalScore > 100) {
                    totalScore = 100;
                }
                System.out.println("Total score = " + totalScore + " / " + "100");
                midTermWeightScore = (double) totalScore / 100 * weight;
                System.out.println(
                        "Weighted score = " + String.format("%.01f", midTermWeightScore)
                                + " / " + weight);
                break;
            } else if (choice.equals("2")) {
                System.out.println("Total score = " + scoreEarned + " / " + "100");
                midTermWeightScore = (double) scoreEarned / 100 * weight;
                System.out.println("Weighted score = " + String.format("%.01f", midTermWeightScore)
                        + " / " + weight);

                break;
            } else {
                System.out.print("Error! Must choose 1=yes or 2=no. PLease choose again: ");
            }
        }
        MAX_WEIGHT -= weight;
    }

    /**
     * This function is used to calculate the weighted score of the final term
     * exam
     */
    public void finalTerm() {
        int weight;
        int scoreEarned;
        String choice;
        int shiftAmount;
        System.out.println("\nFinal: ");
        System.out.print("Weight (0-" + MAX_WEIGHT + ")? ");
        while (true) {
            weight = weightValidate();
            if (weight >= MAX_WEIGHT) {
                System.out.println("Error! The sum of weights exceeds the maximum weight of " + MAX_WEIGHT + ".");
                System.out.print("Please adjust the weights and try again: ");
            } else {
                break;
            }
        }
        System.out.print("Score earned? ");
        scoreEarned = scoreValidate();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        while (true) {
            choice = myInput.nextLine();
            if (choice.equals("1")) {
                System.out.print("Shift amount? ");
                shiftAmount = ShiftAmountValidate();
                int totalScore = scoreEarned + shiftAmount;
                if (totalScore > 100) {
                    totalScore = 100;
                }
                System.out.println("Total score = " + totalScore + " / " + "100");
                finalTermWeightScore = (double) totalScore / 100 * weight;
                System.out.println(
                        "Weighted score = " + String.format("%.01f", finalTermWeightScore)
                                + " / " + weight);
                break;
            } else if (choice.equals("2")) {
                System.out.println("Total score = " + scoreEarned + " / " + "100");
                finalTermWeightScore = (double) scoreEarned / 100 * weight;
                System.out.println("Weighted score = " + String.format("%.01f", finalTermWeightScore)
                        + " / " + weight);
                break;
            } else {
                System.out.print("Error! Must choose 1=yes or 2=no. PLease choose again: ");
            }
        }
        MAX_WEIGHT -= weight;
    }

    /**
     * This function is used to calculate the homework score
     */
    public void homework() {
        int numberOfAssignment;
        int section;
        int sectionPoint;
        double earnedScore = 0;
        double maxScore = 0;
        System.out.println("\nHomework: ");
        System.out.println("Weight: " + MAX_WEIGHT);

        System.out.print("Number of assignment? ");
        numberOfAssignment = numberOfAssignmentValidate();
        int index = 1;
        int score, max;
        while (index <= numberOfAssignment) {
            System.out.print("Assignment " + index + " score and max? ");
            while (true) {
                try {
                    String[] input = myInput.nextLine().split(" ");
                    score = Integer.parseInt(input[0]);
                    max = Integer.parseInt(input[1]);
                    if (input[0].isEmpty() || input[1].isEmpty()) {
                        System.out.println("Error! score and max score must be a positive number.");
                        System.out.print("Please try again: ");
                    } else if (score > max) {
                        System.out.println("Error! score must not be larger than max score.");
                        System.out.print("Please adjust the score and try again: ");
                    } else if (score < 0 || max < 0) {
                        System.out.println("Error! score and max score must be a positive number.");
                        System.out.print("Please try again: ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error! score and max score must be a positive number.");
                    System.out.print("Please try again: ");
                }
            }
            index++;
            valuesPair.add(new IntPair(score, max));
        }
        System.out.print("How many sections did you attend? ");
        while (true) {
            section = sectionValidate();
            if (section > numberOfAssignment) {
                System.out.println("Error! number of sections must not be larger than number of assignments.");
                System.out.print("Please try again: ");
            } else {
                break;
            }
        }
        sectionPoint = section * 5;
        if (sectionPoint > 30) {
            sectionPoint = MAX_ATTEND_POINT;
        }
        System.out.println("Section points = " + sectionPoint + " / " + MAX_ATTEND_POINT);

        for (IntPair p : valuesPair) {
            earnedScore += p.getX();
        }
        earnedScore += sectionPoint;

        for (IntPair p : valuesPair) {
            maxScore += p.getY();
        }
        maxScore += MAX_ATTEND_POINT;

        if (earnedScore > MAX_ASSIGNMENT_SCORE) {
            earnedScore = MAX_ASSIGNMENT_SCORE;
        }

        if (maxScore > MAX_ASSIGNMENT_SCORE) {
            maxScore = MAX_ASSIGNMENT_SCORE;
        }
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println("Total points = " + df.format(earnedScore) + " / " + df.format(maxScore));

        homeworkWeightScore = (earnedScore / maxScore) * MAX_WEIGHT;
        System.out.println("Weighted score = " + df.format(homeworkWeightScore) + " / " + MAX_WEIGHT);
        System.out.println();
    }

    /**
     * This function calculates the overall percentage of the student's grade and
     * prints out the grade
     * that the student will get
     */
    public void report() {
        double grade = 0.0;
        grade = midTermWeightScore + finalTermWeightScore + homeworkWeightScore;
        System.out.println("Overal percentage: " + String.format("%.01f", grade));
        if (grade == 100.0) {
            System.out.println("You reach max grade: 4.0");
        } else if (grade > 85.0) {
            System.out.println("Your grade will be at least: 3.0");
        } else if (grade > 75.0 && grade < 84.99) {
            System.out.println("Your grade will be at least: 2.0");
        } else if (grade > 60.0 && grade < 74.99) {
            System.out.println("Your grade will be at least: 0.7");
        } else if (grade < 60.0) {
            System.out.println("Your grade will be at least: 0.0");
        }
        System.out.println("Thanks for using this program.");
    }

    /**
     * The above function is used to validate the term weight.
     *
     * @return The term weight.
     */
    private int weightValidate() {
        int number;
        while (true)
            try {
                number = Integer.parseInt(myInput.nextLine());
                if (number <= 0 || number >= 100) {
                    System.out.print("Error! Weight must in between 0 - 100. Please input again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Error! Weight must in between 0 - 100. PLease input again: ");
            }
        return number;
    }

    /**
     * The above function is used to validate the input score .
     *
     * @return The score of the student.
     */
    private int scoreValidate() {
        int number;
        while (true)
            try {
                number = Integer.parseInt(myInput.nextLine());
                if (number < 0) {
                    System.out.print("Error! Must be a positive integer number. Please input again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Error! Must be a positive integer number. Please input again: ");
            }
        return number;
    }

    /**
     * The above function is used to validate the input shift amount of score.
     *
     * @return The shift amount.
     */
    private int ShiftAmountValidate() {
        int number;
        while (true)
            try {
                number = Integer.parseInt(myInput.nextLine());
                if (number < 0) {
                    System.out.print("Error! Must be a positive integer number. Please input again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Error! Must be a positive integer number. Please input again: ");
            }
        return number;
    }

    /**
     * The above function is used to validate the input of the number of assignment.
     *
     * @return The number of assignments
     */
    private int numberOfAssignmentValidate() {
        int number;
        while (true)
            try {
                number = Integer.parseInt(myInput.nextLine());
                if (number < 0) {
                    System.out.print("Error! Must be a positive integer number. Please input again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Error! Must be a positive integer number. Please input again: ");
            }
        return number;
    }

    /**
     * The above function is used to validate the input of the number of section.
     *
     * @return The number of section.
     */
    private int sectionValidate() {
        int number;
        while (true)
            try {
                number = Integer.parseInt(myInput.nextLine());
                if (number < 0) {
                    System.out.print("Error! Must be a positive integer number. Please input again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Error! Must be a positive integer number. Please input again: ");
            }
        return number;
    }

    // public static double roundToNDigits(double value, int nDigits) {
    // return Math.round(value * (10 ^ nDigits)) / (double) (10 ^ nDigits);
    // }


}