import java.util.Scanner;

/**
 * This class is used to print the menu,
 * create new array and display array in ascending and descending order
 * also call other methods from Sort class
 * and handle all exceptions
 */

public class GUI {

    private Sort sort; // Create an object from Sort class

    /**
     * Display main menu
     */
    public void menu() {
        System.out.println("========= Bubble Sort program =========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Descending");
        System.out.println("4. Exit");
    }

    /**
     * Create a constructor that initialize object from Sort class
     */
    public GUI() {
        sort = new Sort();
    }

    /**
     * Create new array with given length and elements
     */
    public void createArray() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class        

        System.out.println("----- Input Element -----");
        System.out.println("Input Length Of Array");

        /*Length input*/
        do { // Make sure length inputted is valid
            try {
                System.out.print("Enter Number: ");
                // Input and validate length with given range
                sort = new Sort(Validation.checkRange(input.nextInt(), 1));
                input.nextLine();

                break;
            } catch (NumberFormatException nfe) { // Throw when length is out of range
                System.out.println("Please input number and number is greater than zero");
                input.nextLine();
            } catch (Exception e) { // Throw when length is non-numerical
                System.out.println("Please input number and number is greater than zero");
                input.nextLine();
            }
        } while (true);

        // Loop and assign new value to array
        for (int i = 0; i < sort.getLength(); i++) {
            int value = 0; // Store new element value

            // Assign new array element
            do { // Make sure user input is valid
                try {
                    System.out.print("Enter Number " + (i + 1) + ": ");
                    // Input and validate value
                    value = input.nextInt();
                    input.nextLine();

                    break;
                } catch (Exception e) { // Throw when value is non-numerical
                    System.out.println("Please enter integer only");
                    input.nextLine();
                }
            } while (true);

            // Assign new element value into array at given index
            sort.add(i, value);
        }
    }

    /**
     * Get the array in ascending order with given format
     *
     * @return String
     */
    public String getAscendingArray() {
        if (sort.getLength() == 0) { // Display when array is empty
            return "Please create new array to start displaying";
        } else { // Display ascending order array
            System.out.println("----- Ascending -----");
            int[] ascendArr = sort.sortAscending(); // Store array
            String s = "[" + ascendArr[0] + "]"; // Display first element

            // Display the rest of array elements
            for (int i = 1; i < ascendArr.length; i++) {
                s += "->[" + ascendArr[i] + "]";
            }

            // Return array in ascending order
            return s;
        }
    }

    /**
     * Get the array in descending order with given format
     *
     * @return String
     */
    public String getDescendingArray() {
        if (sort.getLength() == 0) { // Display when array is empty
            return "Please create new array to start displaying";
        } else { // Display descending order array
            System.out.println("----- Descending -----");
            int[] descendArr = sort.sortDescending(); // Store array
            String s = "[" + descendArr[0] + "]"; // Display first element

            // Display the rest of array elements
            for (int i = 1; i < descendArr.length; i++) {
                s += "<-[" + descendArr[i] + "]";
            }

            // Return array in ascending order
            return s;
        }
    }
}
