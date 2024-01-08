import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used for managing the doctor
 * and also used for the main menu
 */
public class DoctorManagement {
    private List<Doctor> DoctorsList = new ArrayList<>();
    private static int NumberOfDoctors = 0;
    private int MODE;
    private CustomTable table = new CustomTable();
    private int doctorCodeCounter = 0;

    //final variables for the table header and menu
    private final String MainMenu[] = { "Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit" };
    private final String Report[] = { "Code   ", "Name          ", "Specialization ", "Availability " };
    private final String NormalReport[] = { "Name       ", "Specialization ", "Availability " };
    public DoctorManagement() {
        MODE = 0;
        NumberOfDoctors = 0;
    }

    /**
     * This method is used for creating the main menu
     * and also used for the user input
     */
    public void initMenu() {
        do {
            MODE = Integer.parseInt(
                    table.createMenu("Doctor Management\n\t\t(MainMenu)", MainMenu, CustomTable.NUMBER));
            HandleMode();
            table.createHR();
        } while (MODE != 5);
    }

    /**
     * this method is use for handling the user input,
     * then call the specified input for it
     */
    private void HandleMode() {
        switch (MODE) {
            case 1:
                Create();                       //Create the outline of the program to add doctors
                break;
            case 2:
                updateDoctor();                 //Display the table and then ask the user for the doctor code
                break;
            case 3:
                deleteDoctor();                 //Display the table and then ask the user for the code to delete
                break;
            case 4:
                searchDoctor();                 //Display the table and then ask the user for the code to search
                break;
            case 5:
                //TODO: Exit
                System.exit(0);
                break;
        }
    }

    /**
     * This method is used for creating the doctor
     * and also used for the user input
     */
    private void Create() {
        Scanner sc = new Scanner(System.in);

        try {
            Doctor temp = new Doctor();

            // Prompt user for doctor code and validate
            String doctorCode = null;
            boolean isValidCode = false;
            while (!isValidCode) {
                System.out.print("Enter Code: ");
                doctorCode = sc.nextLine();

                while (!checkValidCode(doctorCode)) {
                    System.out.print("Enter Code: ");
                    doctorCode = sc.nextLine();
                }

                String finalDoctorCode = doctorCode;
                /*creates a stream of the DoctorsList collection and checks if the code already exists
                 *if it does, it will print out an error message and ask the user to enter a new code
                 *if it doesn't, it will set the isValidCode to true and exit the loop
                 */
                if (DoctorsList.stream().anyMatch(d -> d.getCode().equals(finalDoctorCode))) {
                    System.out.println("Error: Code already exists in the database.");
                } else {
                    isValidCode = true;
                }
            }

            // Set doctor attributes
            temp.setCode(doctorCode);
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            // Validate name
            while (!checkValidName(name)) {
                System.out.print("Enter name: ");
                name = sc.nextLine();
            }
            temp.setName(name);
            System.out.print("Enter Specialization: ");
            String specialization = sc.nextLine();
            while (!checkValidSpecialization(specialization)) {
                System.out.print("Enter Specialization: ");
                specialization = sc.nextLine();
            }
            temp.setSpecialization(specialization);
            System.out.print("Enter Availability: ");
            //int availability = Integer.parseInt(sc.nextLine());
            String availability = sc.nextLine();
            while (!checkValidAvailability(availability)) {
                System.out.print("Enter Availability: ");
                availability = sc.nextLine();
                //availability = Integer.parseInt(sc.nextLine());
            }
            temp.setAvailability(availability);

            // Add doctor to list
            DoctorsList.add(temp);
            NumberOfDoctors++;
            System.out.println("Doctor added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    /**
     * This method is used for updating the doctor
     */
    private void updateDoctor() {
        Scanner sc = new Scanner(System.in);
        String code = "";

        if (DoctorsList.isEmpty()) {
            System.out.println("\t\tNo doctors have been added.");
            return;
        }

        displayTable();

        System.out.print("Enter code (ID) of the doctor to be updated: ");
        code = sc.nextLine();

        try {
            // Check if code is valid
            while (!checkValidCode(code)) {
                System.out.print("Enter code (ID) of the doctor to be updated: ");
                code = sc.nextLine();
            }

            // Check if doctor with given code exists
            boolean doctorExists = false;
            for (Doctor doctor : DoctorsList) {
                if (doctor.getCode().equals(code)) {
                    doctorExists = true;
                    System.out.println("Doctor found.");
                    System.out.println("Enter the new data for the doctor.");
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    // Validate name
                    while (!checkValidName(name)) {
                        System.out.print("Enter name: ");
                        name = sc.nextLine();
                    }
                    doctor.setName(name);
                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();
                    while (!checkValidSpecialization(specialization)) {
                        System.out.print("Enter Specialization: ");
                        specialization = sc.nextLine();
                    }
                    doctor.setSpecialization(specialization);
                    System.out.print("Enter Availability: ");
                    //int availability = Integer.parseInt(sc.nextLine());
                    String availability = sc.nextLine();
                    while (!checkValidAvailability(availability)) {
                        System.out.print("Enter Availability: ");
                        availability = sc.nextLine();
                        //availability = Integer.parseInt(sc.nextLine());
                    }
                    doctor.setAvailability(availability);
                    System.out.println("Doctor updated successfully.");
                    displayTable();
                    break;
                }
            }

            if (!doctorExists) {
                System.out.println("No doctor found with the given code.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Returning to main menu.");
        }
    }

    /**
     * check valid Specialization method
     * @param specialization
     * @return
     */
    private boolean checkValidSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            System.out.println("Error: Specialization cannot be empty.");
            return false;
        }
        //specialization cannot be number
        if(specialization.matches(".*\\d.*")){
            System.out.println("Error: Specialization cannot be number.");
            return false;
        }
        return true;
    }


    /**
     * Check valid name method
     * @param name
     * @return
     */
    private boolean checkValidName(String name) {
        // Check if the name is blank or contains numbers
        if (name.isBlank() || name.matches(".*\\d.*")) {
            System.out.println("Invalid name! Please enter a name without numbers or blank spaces.");
            return false;
        }
        //name cannot contain special characters
        if(!name.matches("[a-zA-Z ]+")){
            System.out.println("Error: Name cannot contain special characters.");
            return false;
        }
        return true;
    }

    /**
     * Check valid code method
     * @param code
     * @return
     */
    private boolean checkValidCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            System.out.println("Error: Code cannot be empty.");
            return false;
        }
        if (code.length() != 6 || !code.toLowerCase().startsWith("doc") || !code.substring(3).matches("\\d{3}")) {
            System.out.println("Error: Code must be in the format 'docxxx' (case-insensitive), where 'xxx' is a number from 000 to 999.");
            return false;
        }
        return true;
    }

    /**
     * Check valid availability method
     * @param availability
     * @return
     */
    public boolean checkValidAvailability(String availability) {
        //check if availability is null or empty or smaller than 0
        if (availability == null || availability.trim().isEmpty() || Integer.parseInt(availability) < 0) {
            System.out.println("Error: Availability cannot be empty or smaller than 0.");
            return false;
        }
        else if (availability.length() > 2) {
            return false;
        }
        return true;
    }

    /**
     * This method is used for deleting the doctor
     */
    private void deleteDoctor() {

        if (DoctorsList.isEmpty()) {
            System.out.println("\t\tNo doctors have been added.");
            return;
        }

        displayTable();
        Scanner sc = new Scanner(System.in);
        String code = "";

        System.out.print("Enter code (ID) of the doctor to be deleted: ");
        code = sc.nextLine();

        // Check if code is valid
        if (!checkValidCode(code)) {
            return;
        }

        // Check if doctor with given code exists
        boolean doctorExists = false;
        for (Doctor doctor : DoctorsList) {
            if (doctor.getCode().equals(code)) {
                doctorExists = true;
                DoctorsList.remove(doctor);
                NumberOfDoctors--;
                System.out.println("Doctor deleted successfully.");
                displayTable();
                break;
            }
        }

        if (!doctorExists) {
            System.out.println("No doctor found with the given code.");
        }
    }

    /**
     * This method is used for searching the doctor
     */
    private void searchDoctor() {

        if (DoctorsList.isEmpty()) {
            System.out.println("\t\tNo doctors have been added.");
            return;
        }

        displayTable();
        Scanner sc = new Scanner(System.in);

        String tempTable[] = new String[]
                { "Code   ", NormalReport[0], NormalReport[1],
                        NormalReport[2] }, temp[];

        temp = new String[4];

        String code = "", tempCode;

        boolean found = false;
        boolean THCreated = false;
        try {
            System.out.print("Enter code (id) of the doctor to be searched: ");
            code = sc.nextLine();

            // Check if code is valid
/*            if (!checkValidCode(code)) {
                return;
            }
*/
            // Check if doctor with given code exists
            for (Doctor doctor : DoctorsList) {
                tempCode = doctor.getSearchedCode();
                if (doctor.getCode().equals(tempCode) || doctor.getName().contains(tempCode)) {
                    temp[0] = doctor.getCode();
                    temp[1] = doctor.getName();
                    temp[2] = doctor.getSpecialization();
                    temp[3] = String.valueOf(doctor.getAvailability());
                    found = true;
                    if (!THCreated && found) {
                        table.createTH(tempTable);
                        THCreated = true;
                    }
                    if (found) {
                        table.createTB(tempTable, temp);
                    }
                }
            } if (!found) { // If doctor with given code does not exist
                System.out.println("No doctor found with the given code.");
            } else {
                table.createTF(tempTable);
            }
        } catch (Exception e) { // If any error occurs
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Displays the table of doctors
     */
    private void displayTable() {

        if (DoctorsList.isEmpty()) {
            System.out.println("\t\tNo doctors have been added.");
            return;
        }

        table.createTH(Report);
        String temp[] = new String[4];
        for (int i = 0; i < NumberOfDoctors; i++) {
            temp[0] = DoctorsList.get(i).getCode();
            temp[1] = DoctorsList.get(i).getName();
            temp[2] = DoctorsList.get(i).getSpecialization();
            temp[3] = String.valueOf(DoctorsList.get(i).getAvailability());
            table.createTB(Report, temp);
        }
        table.createTF(Report);
    }

}

