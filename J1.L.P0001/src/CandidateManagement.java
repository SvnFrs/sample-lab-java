import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The CandidateManagement class which is used to manage the list of candidates.
 * @author IuseArchBTW
 */
public class CandidateManagement {
    private ArrayList<Candidate> Ligma; //List to store Candidate objects
    private final String MenuOption = "Experience, Fresher, Internship, Searching, Exit"; //Options for the menu
    private CustomTable c = new CustomTable(); //Object of the CustomTable class to create table


    /**
     * Constructor to initialize the ArrayList
     */
    public CandidateManagement() {
        Ligma = new ArrayList<>(); //Instantiate the ArrayList
    }

    /**
     * Method to create menu and call the appropriate methods
     */
    public void CreateTable() {
        int option = 0; //Variable to store user's option
        do {
            //Create a menu and get user's input
            option = Integer.parseInt(c.createMenu("CANDIDATE MANAGEMENT SYSTEM", MenuOption.split(", "), CustomTable.NUMBER));
            handleChoices(option); //Call the handleChoices method and pass the user's option
        } while (option != 5);
    }


    /**
     * Method to handle user's choice
     *
     * @param option User's choice
     */
    private void handleChoices(int option) {
        switch (option) {
            case 1:
                createExperience(); //Create an Experience Candidate object
                //handleOrder(); //Call the handleOrder method to check if the user wants to sort the list
                break;
            case 2:
                createFresher(); //Create a Fresher Candidate object
                //handleOrder(); //Call the handleOrder method to check if the user wants to sort the list
                break;
            case 3:
                createIntern(); //Create an Intern Candidate object
                //handleOrder(); //Call the handleOrder method to check if the user wants to sort the list
                break;
            case 4:
                searchCandidates(); //Call the searchCandidates method to search for a specific candidate
                break;
            case 5:
                System.out.println("Thank you for using our system!");
                System.exit(0); //Exit the program
                break;
        }
    }

    /**
     * Method to handle user choice to continue or to stop creating candidates
     */
//    public void handleOrder() {
//        Scanner sc = new Scanner(System.in);
//        int option = 0;
//        String Types = "Experience, Fresher, Intern";
//        System.out.print("Do you want to order now (Y/N)? "); //Ask the user if they want to sort the list
//        String input = sc.nextLine();
//        //loop until user enters Y or N
//        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
//            System.out.println("Please enter only Y or N please!");
//            input = sc.nextLine();
//        }
//        if (input.equalsIgnoreCase("Y")) {
//            option = Integer.parseInt(c.createMenu("CANDIDATE TYPES", Types.split(", "), CustomTable.NUMBER));
//            handleChoices(option);
//        }
//        if (input.equalsIgnoreCase("N")) {
//            displayJustCreatedCandidate(); //Call the displayTable method to display all the candidates in the list
//            //CreateTable(); //Call the CreateTable method to show the menu again
//            return;
//        }
//    }


    /**
     * Method to create an Experience Candidate object
     */
    public void createExperience() {
        int id = Ligma.size() + 1; //Increment the id by 1
        Candidate temp = new Experience(); //Create a new Experience object
        temp.setCandidateID(id); //Set the id for the object
        temp.input(); //Get the input for the object
        Ligma.add(temp); //Add the object to the list
        //ask the user if they want to continue creating experience candidates

        System.out.print("Do you want to order now (Y/N)? ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
            System.out.print("Please enter only Y or N please! ");
            input = sc.nextLine();
        }
        if (input.equalsIgnoreCase("Y")) {
            createExperience();
        }
        if (input.equalsIgnoreCase("N")) {
            displayExperienceCandidate(); //Call the displayTable method to display all the candidates in the list
            //CreateTable(); //Call the CreateTable method to show the menu again
            return;
        }
    }

    /**
     * Method to create a Fresher Candidate object
     */
    public void createFresher() {
        int id = Ligma.size() + 1; //Increment the id by 1
        Candidate temp = new Fresher(); //Create a new Fresher object
        temp.setCandidateID(id); //Set the id for the object
        temp.input(); //Get the input for the object
        Ligma.add(temp); //Add the object to the list
        //ask the user if they want to continue creating fresher candidates
        System.out.print("Do you want to order now (Y/N)? ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
            System.out.print("Please enter only Y or N please! ");
            input = sc.nextLine();
        }
        if (input.equalsIgnoreCase("Y")) {
            createFresher();
        }
        if (input.equalsIgnoreCase("N")) {
            displayFresherCandidate(); //Call the displayTable method to display all the candidates in the list
            //CreateTable(); //Call the CreateTable method to show the menu again
            return;
        }
    }

    /**
     * Method to create an Intern Candidate object
     */
    public void createIntern() {
        int id = Ligma.size() + 1; //Increment the id by 1
        Candidate temp = new Intern(); //Create a new Intern object
        temp.setCandidateID(id); //Set the id for the object
        temp.input(); //Get the input for the object
        Ligma.add(temp); // Add the new Intern object to the list
        //ask the user if they want to continue creating intern candidates
        System.out.print("Do you want to order now (Y/N)? ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
            System.out.print("Please enter only Y or N please! ");
            input = sc.nextLine();
        }
        if (input.equalsIgnoreCase("Y")) {
            createIntern();
        }
        if (input.equalsIgnoreCase("N")) {
            displayInternCandidate(); //Call the displayTable method to display all the candidates in the list
            //CreateTable(); //Call the CreateTable method to show the menu again
            return;
        }
    }

    /**
     * Search for a candidate based on name and type
     */
    public void searchCandidates() {
        //Check if the list is empty
        if (Ligma.isEmpty()) {
            System.out.println("No candidates in the list!");
            return;
        }
        //Sort the list by candidate type
        sortByType();
        //Display the table
        displayTable();
        //Header for the table
        String tableHeader = "No., Fullname             , Birthdate, Address         , Phone          , Email                 , Type         ";
        //Check if the table header has been printed
        boolean checkTableHeader = false;
        //Scanner object to get input
        Scanner sc = new Scanner(System.in);
        //Prompt for the candidate name and loop if user enter empty, number, or special characters
        String input;
        do {
            System.out.print("Input Candidate name (First name or Last name): ");
            input = sc.nextLine();
            try {
                if (input.isEmpty()) {
                    throw new Exception("Please enter a name!");
                }
                if (input.matches(".*\\d.*")) {
                    throw new Exception("Please enter a name without numbers!");
                }
                if (input.matches(".*\\W.*")) {
                    throw new Exception("Please enter a name without special characters!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (input.isEmpty() || input.matches(".*\\d.*") || input.matches(".*\\W.*"));

        //Prompt for the candidate type and loop if user enter empty, string or special characters or if the input is not 1, 2, or 3
        String intput;
        do {
            System.out.print("Input Candidate type (0-Experience, 1-Fresher, 2-Intern): ");
            intput = String.valueOf(sc.nextLine());
        } while (intput.isEmpty() || intput.matches(".*\\D.*") || intput.matches(".*\\W.*") || !intput.matches("[0-2]"));
        //Loop through the list of candidates
        int found = 0;
        //default id is 1
        int count = 1;
        for (Candidate i : Ligma) {
            //Check if the candidate name contains the input and if the candidate type matches the input type
            if (i.getCandidateType() == Integer.parseInt(intput) && i.getFirstName().toLowerCase().contains(input.toLowerCase()) || i.getLastName().toLowerCase().contains(input.toLowerCase()) && i.getCandidateType() == Integer.parseInt(intput)) {
                //If the table header hasn't been printed yet, print it
                if (!checkTableHeader) {
                    c.createTH(tableHeader.split(", "));
                    checkTableHeader = true;
                }
                //if the candidate is found, increment the found variable by 1
                found++;
                //Create a table row for the candidate with id incremented by 1
                c.createTB(tableHeader.split(", "), new String[]{count + "", i.getFirstName() + " " + i.getLastName(), i.getBirthDate() + "", i.getAddress(), i.getPhone(), i.getEmail(), i.getCandidateTypeName() + ""});
                //if the candidate is found, increment the id by 1
                count++;
            }
        }
        //If no candidate is found, print a message
        if (found == 0) {
            System.out.println("No candidate found!");
        }
        //If the table header has been printed, print the footer
        if (checkTableHeader) {
            c.createTF(tableHeader.split(", "));
        }
    }

    /**
     * Method to display the just created candidate
     */
    public void displayJustCreatedCandidate() {
        //Check if the list is empty
        if (Ligma.isEmpty()) {
            System.out.println("No candidates in the list!");
            return;
        }
        //Sort the list by candidate type
        //sortByType();
        //Header for the table
        String tableHeader = "No., Fullname             , Birthdate, Address     , Phone          , Email                 , Type         ";
        //Check if the table header has been printed
        boolean checkTableHeader = false;
        //Loop through the list of candidates
        for (Candidate i : Ligma) {
            //Check if the candidate type is 0
            if (i.getCandidateType() == 0 || i.getCandidateType() == 1 || i.getCandidateType() == 2) {
                //If the table header hasn't been printed yet, print it
                if (!checkTableHeader) {
                    c.createTH(tableHeader.split(", "));
                    checkTableHeader = true;
                }
                //Create a table row for the candidate with id incremented by 1
                c.createTB(tableHeader.split(", "), new String[]{i.getCandidateID() + "", i.getFirstName() + " " + i.getLastName(), i.getBirthDate() + "", i.getAddress(), i.getPhone(), i.getEmail(), i.getCandidateTypeName() + ""});
            }
        }
        //If the table header has been printed, print the footer
        if (checkTableHeader) {
            c.createTF(tableHeader.split(", "));
        }


//        //loop through the list of candidates, and use the correct method to display the candidate
//        for (Candidate i : Ligma) {
//            if (i.getCandidateType() == 0) {
//                displayExperienceCandidate();
//            }
//            else if (i.getCandidateType() == 1) {
//                displayFresherCandidate();
//            }
//            else if (i.getCandidateType() == 2) {
//                displayInternCandidate();
//            }
//        }
//        back to the main menu
        CreateTable();
    }

    /**
     * Method to display the just created experience candidate
     */
    public void displayExperienceCandidate() {
        //Check if the list is empty
        if (Ligma.isEmpty()) {
            System.out.println("No candidates in the list!");
            return;
        }
        System.out.println("===========EXPERIENCE CANDIDATE============"); //Print the header
        //Header for the table
        String tableHeader = "No., Fullname             , Birthdate, Address     , Phone          , Email                 , Professional Skill , Year of experience , Type         ";
        //Check if the table header has been printed
        boolean checkTableHeader = false;
        int count = 1;
        //Loop through the list of candidates
        for (Candidate i : Ligma) {
            //Check if the candidate type is 0
            if (i.getCandidateType() == 0) {
                //If the table header hasn't been printed yet, print it
                if (!checkTableHeader) {
                    c.createTH(tableHeader.split(", "));
                    checkTableHeader = true;
                }
                //Create a table row for the candidate with default id = 1 then increment by 1
                c.createTB(tableHeader.split(", "), new String[]{count + "", i.getFirstName() + " " + i.getLastName(), i.getBirthDate() + "", i.getAddress(), i.getPhone(), i.getEmail(), ((Experience) i).getProSkill(), ((Experience) i).getExpInYear() + "", i.getCandidateTypeName() + ""});
                //c.createTB(tableHeader.split(", "), new String[]{i.getCandidateID() + "", i.getFirstName() + " " + i.getLastName(), i.getBirthDate() + "", i.getAddress(), i.getPhone(), i.getEmail(), ((Experience) i).getProSkill(), ((Experience) i).getExpInYear() + "", i.getCandidateTypeName() + ""});
                count++;
            }
        }
        //If the table header has been printed, print the footer
        if (checkTableHeader) {
            c.createTF(tableHeader.split(", "));
        }
    }

    /**
     * Method to display the just created fresher candidate
     */
    public void displayFresherCandidate() {
        //Check if the list is empty
        if (Ligma.isEmpty()) {
            System.out.println("No candidates in the list!");
            return;
        }
        System.out.println("===========FRESHER CANDIDATE============"); //Print the header
        //Header for the table
        String tableHeader = "No., Fullname             , Birthdate, Address     , Phone          , Email                 , Graduation Date , Graduation Rank , Education               , Type         ";
        //Check if the table header has been printed
        boolean checkTableHeader = false;
        int count = 1;
        //Loop through the list of candidates
        for (Candidate i : Ligma) {
            //Check if the candidate type is 0
            if (i.getCandidateType() == 1) {
                //If the table header hasn't been printed yet, print it
                if (!checkTableHeader) {
                    c.createTH(tableHeader.split(", "));
                    checkTableHeader = true;
                }
                //Create a table row for the candidate with id incremented by 1
                c.createTB(tableHeader.split(", "), new String[]{count + "", i.getFirstName() + " " + i.getLastName(), i.getBirthDate() + "", i.getAddress(), i.getPhone(), i.getEmail(), ((Fresher) i).getGraduationDate() + "", ((Fresher) i).getGraduationRank(), ((Fresher) i).getEducation(), i.getCandidateTypeName() + ""});
                count++;
            }
        }
        //If the table header has been printed, print the footer
        if (checkTableHeader) {
            c.createTF(tableHeader.split(", "));
        }
    }

    /**
     * Method to display the just created intern candidate
     */
    public void displayInternCandidate() {
        //Check if the list is empty
        if (Ligma.isEmpty()) {
            System.out.println("No candidates in the list!");
            return;
        }
        System.out.println("===========INTERN CANDIDATE============"); //Print the header
        //Header for the table
        String tableHeader = "No., Fullname             , Birthdate, Address     , Phone          , Email                 , Majors , Semester , University , Type         ";
        //Check if the table header has been printed
        boolean checkTableHeader = false;
        int count = 1;
        //Loop through the list of candidates
        for (Candidate i : Ligma) {
            //Check if the candidate type is 0
            if (i.getCandidateType() == 2) {
                //If the table header hasn't been printed yet, print it
                if (!checkTableHeader) {
                    c.createTH(tableHeader.split(", "));
                    checkTableHeader = true;
                }
                //Create a table row for the candidate with id incremented by 1
                c.createTB(tableHeader.split(", "), new String[]{count + "", i.getFirstName() + " " + i.getLastName(), i.getBirthDate() + "", i.getAddress(), i.getPhone(), i.getEmail(), ((Intern) i).getMajors(), ((Intern) i).getSemester() + "", ((Intern) i).getUniversityName(), i.getCandidateTypeName() + ""});
                count++;
            }
        }
        //If the table header has been printed, print the footer
        if (checkTableHeader) {
            c.createTF(tableHeader.split(", "));
        }
    }

    /**
     * The `displayTable` method displays the list of candidates sorted by type,
     * with headers to differentiate between the different types of candidates
     */
    public void displayTable() {
        int lenght = Ligma.size(); //Get the length of the candidate list
        boolean Ex = false; //Initialize a boolean value to track if the Experience candidates have been printed
        boolean Fr = false; //Initialize a boolean value to track if the Fresher candidates have been printed
        boolean In = false; //Initialize a boolean value to track if the Intern candidates have been printed

        //Loop through the candidate list
        for (int i = 0; i < lenght; i++) {
            //Check if the current candidate is an Experience candidate, and if the header has not been printed yet
            if (!Ex && Ligma.get(i).getCandidateType() == 0) {
                System.out.println("===========EXPERIENCE CANDIDATE============"); //Print the header
                Ex = true; //Update the flag to indicate that the header has been printed
            }
            //Check if the current candidate is a Fresher candidate, and if the header has not been printed yet
            if (!Fr && Ligma.get(i).getCandidateType() == 1) {
                System.out.println("===========FRESHER CANDIDATE============"); //Print the header
                Fr = true; //Update the flag to indicate that the header has been printed
            }
            //Check if the current candidate is an Intern candidate, and if the header has not been printed yet
            if (!In && Ligma.get(i).getCandidateType() == 2) {
                System.out.println("===========INTERN CANDIDATE============"); //Print the header
                In = true; //Update the flag to indicate that the header has been printed
            }
            //Print the first and last name of the current candidate
            System.out.println(Ligma.get(i).getFirstName() + " " + Ligma.get(i).getLastName());
        }
    }

    /**
     * The `sortByType` method sorts the list of candidates by the candidate type
     */
    private void sortByType() {
        //Sort the list of candidates using the `Collections.sort` method, with a comparator that compares the candidate type
        Ligma.sort((Comparator.comparingInt(Candidate::getCandidateType)));
    }
}
