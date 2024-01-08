import java.util.Scanner;

public class Calculator {

    private static Scanner sc = new Scanner(System.in);

    /**
     * display the calculator menu
     * Do the same as the menu
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        do {
            // Display the menu
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal calculator");
            System.out.println("2. BMI calculator");
            System.out.println("3. Exit");
            System.out.print("Please choice an option: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("----- Normal Calculator -----");
                    normalCalculate();
                    break;
                case "2":
                    System.out.println("----- BMI Calculator -----");
                    BMICalculate();
                    break;
                case "3":
                    System.out.println("THANKS YOU FOR USING MY PROGRAM!");
                    break;
                default:
                    System.out.println("Please choice again (1-3)! ");
            }
        }   // If user enters 3 then exit the program
        while (!choice.equals("3"));
    }

    /**
     * Normal calculator
     * Which prompts user to enter two numbers and an operator (+, -, *, /, ^)
     * and displays the result
     * Do the same as the normal calculator
     */
    private void normalCalculate() {
        double num1 = 0,
                num2 = 0,
                result = 0;
        String operator = "";

        System.out.print("Enter number: ");

        // If user enters letters or leave blank space, ask user to enter it again
        while (true) {
            try {
                num1 = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Must be a number. Please try again: ");
            }
        }
        result = num1;

        // If user does not enter any operator, ask user to enter it again
        while (true) {
            System.out.print("Enter operator (+, -, *, /, ^). ( = to return to menu): ");
            while (true) {
                operator = sc.nextLine();
                if (operator.trim().isBlank()) {
                    System.out.println("Invalid operator! Please try again!");
                    System.out.print("Enter operator (+, -, *, /, ^). ( = to return to menu): ");
                } else {
                    break;
                }
            }
            // If user enters '=' then display the result
            if (operator.equals("=")) {
                break;
            }

            // If user enters invalid operator, ask user to enter it again
            while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")
                    && !operator.equals("^")) {
                System.out.println("Invalid operator! Please try again!");
                System.out.print("Enter operator (+, -, *, /, ^). ( = to return to menu): ");
                operator = sc.next();
            }

            System.out.print("Enter number: ");

            // If user enters letters or enter 0 in a division, ask user to enter it again
            while (true) {
                try {
                    num2 = Double.parseDouble(sc.nextLine());
                    if (operator.equals("/") && num2 == 0) {
                        System.out.print("Cannot divide by zero. Please enter a non-zero number: ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input! Must be a number. Please try again: ");
                }
            }

            // Calculate the result based on the operator
            switch (operator) {
                case "+":
                    result += num2;
                    break;
                case "-":
                    result -= num2;
                    break;
                case "*":
                    result *= num2;
                    break;
                case "/":
                    result /= num2;
                    break;
                case "^":
                    result = Math.pow(result, num2);
                    break;
            }
            System.out.println("Memory: " + result);
        }
        System.out.println("Result: " + result);
    }

    /**
     * BMI calculator
     * Which prompts user to enter weight (kg) and height (cm) and displays the BMI
     * and the BMI status
     * Do the same as what the BMI calculator does
     */
    private void BMICalculate() {
        double weight,
                height,
                bmi;
        String bmiStatus = "";

        System.out.print("Enter Weight(kg): ");

        // If user enters letters, leave blank space, or negative number than ask user to enter it again
        while (true) {
            try {
                weight = Double.parseDouble(sc.nextLine());
                if (weight < 0) {
                    System.out.println("BMI must be positive");
                    System.out.print("Enter Weight(kg): ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("BMI is digit");
                System.out.print("Enter Weight(kg): ");
            }
        }

        System.out.print("Enter Height(cm): ");

        // If user enters letters, leave blank space, or negative number then ask user to enter again
        while (true) {
            try {
                height = Double.parseDouble(sc.nextLine());
                if (height < 0) {
                    System.out.print("BMI must be positive");
                    System.out.print("Enter Height(cm): ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("BMI is digit");
                System.out.print("Enter Height(cm): ");
            }
        }

        // Calculate the BMI
        bmi = weight / ((height / 100) * (height / 100));
        if (bmi < 19) {                                 // If BMI is less than 19 then the BMI status is under-standard
            bmiStatus = "UNDER-STANDARD";
        } else if (bmi >= 19 && bmi <= 25) {            // If BMI is between 19 and 25 then the BMI status is standard
            bmiStatus = "STANDARD";
        } else if (bmi > 25 && bmi <= 30) {             // If BMI is between 25 and 30 then the BMI status is overweight
            bmiStatus = "OVERWEIGHT";
        } else if (bmi > 30 && bmi <= 40) {             // If BMI is between 30 and 40 then the BMI status is fat
            bmiStatus = "FAT - SHOULD LOSE WEIGHT";
        } else if (bmi > 40) {                          // If BMI is greater than 40 then the BMI status is very fat
            bmiStatus = "VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY";
        }

        System.out.println("BMI Number: " + String.format("%.2f", bmi));
        System.out.println("BMI Status: " + bmiStatus);
    }
}
