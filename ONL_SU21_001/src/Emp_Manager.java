import java.util.ArrayList;
import java.util.Scanner;

public class Emp_Manager {

    private static ArrayList<Employee> employee; // Create a list to store employee data

    /**
     * Create a default constructor that generate new employee list
     */
    public Emp_Manager() {
        // Create new employee list
        employee = new ArrayList<>();
    }

    /**
     * Add new employee data to list
     */
    public void add() {
        Scanner input = new Scanner(System.in); // Create a new instance of Scanner class
        int num; // Store number of employee to input
        String id, name; // Store id and name of employee
        double salary, coe; // Store employee's salary and COE value

        System.out.print("+ Enter number of Employee: ");

        // Make sure user input is greater than 0
        while (true) {
            try {
                // Input number of employee data to add
                num = Validation.checkRange(Integer.parseInt(input.nextLine()), 1);

                break;
            } catch (NumberFormatException nfe) { // Throw when user input is non-numerical
                System.out.print("--------Error! Please enter number again (From 1): ");
            } catch (IllegalArgumentException iae) { // Throw when user input is less than 1
                System.out.print(iae.getMessage());
            }
        }

        int count = 1; // Keep track of number of employee
        while (count <= num) { // Loop until the number of new employee data is met
            System.out.printf("- Employee %d:\n", count);
            /*ID input*/
            System.out.print("-- Please enter ID number: ");
            while (true) { // Check valid employee's ID
                try {
                    // Input employee's ID
                    id = Validation.checkId(input.nextLine());
                    if (checkIdExist(id)) { // Check if ID is already existed
                        System.out.print("--------Error! ID already existed, ID again: ");
                    } else {
                        break;
                    }
                } catch (IllegalArgumentException iae) { // Throw when ID syntax is incorrect
                    System.out.print(iae.getMessage());
                }
            }

            /*Name input*/
            System.out.print("-- Please enter name: ");
            while (true) { // Loop until employee's name is not empty
                try {
                    // Input employee's name
                    name = Validation.checkName(input.nextLine());
                    break;
                } catch (IllegalArgumentException iae) { // Throw when employee's name is empty
                    System.out.println(iae.getMessage());
                }
            }

            /*Salary input*/
            System.out.print("-- Please enter salary: ");
            while (true) { // Loop until salary value is greater than 99
                try {
                    // Input salary value
                    salary = Validation.checkSalary(Double.parseDouble(input.nextLine()));
                    break;
                } catch (NumberFormatException nfe) { // Throw when salary input is non-numerical
                    System.out.print("--------Error! Please salary again (Salary >= 100 USD): ");
                } catch (IllegalArgumentException iae) { // Throw when salary input is less than 100
                    System.out.print(iae.getMessage());
                }
            }

            /*Input COE value*/
            System.out.print("-- Please enter coefficients salary: ");
            while (true) { // Loop until COE value is in range
                try {
                    // Input COE value
                    coe = Validation.checkCOE(Double.parseDouble(input.nextLine()));
                    break;
                } catch (NumberFormatException nfe) { // Throw when user input is non-numerical
                    System.out.print("-----Error! Please coefficients salary again (From 1 to 5): ");
                } catch (IllegalArgumentException iae) { // Throw when COE value is out of range
                    System.out.print(iae.getMessage());
                }
            }
            // Add new employee data to list
            employee.add(new Employee(id, name, salary, coe));

            System.out.println();
            // Track number of new data left to add
            count++;
        }
    }

    /**
     * Show the list of employee data
     */
    public void show() {
        if (employee.size() == 0) { // Display message when no employee data is available
            System.out.println("No employee information available!");
        } else { // Print the list when data is available
            System.out.println("===================List Employee===================");
            System.out.println("|ID       |Name              |Salary    |COE");
            for (Employee e : employee) { // Print employee data
                System.out.printf("|%-9s|%-18s|%-10.0f|%-10.1f\n", e.getId(), formatString(e.getName()), e.getSalary(), e.getCOE());
            }
        }
        System.out.println();
    }

    /**
     * Print user menu
     */
    public void menu() {
        System.out.println("----------MENU----------");
        System.out.println("1. Input employee.");
        System.out.println("2. Show list employee.");
        System.out.println("0. Exit.");
        System.out.print("Please choose: "); // Require input from user
    }

    /**
     * Check if inputted ID has already existed
     *
     * @param id Inputted ID
     * @return True if ID is found in list, false otherwise
     */
    private static boolean checkIdExist(String id) {
        for (Employee e : employee) { // Traverse through the list to find ID
            if (e.getId().equalsIgnoreCase(id)) { // Return true if ID is found in list
                return true;
            }
        }
        // Return false when no ID is found in list
        return false;
    }

    /**
     * Format inputted string with given length
     *
     * @param str Inputted string
     * @return Formatted string
     */
    private String formatString(String str) {
        String newStr = str; // Assign new string value

        // Change new string value if inputted length is out of range
        if (str.length() > 18) {
            newStr = str.substring(0, 15) + "...";
        }

        return newStr;
    }
}
