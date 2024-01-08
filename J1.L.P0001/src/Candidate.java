import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The Candidate class which is used to store information of a candidate.
 * And the parent class of Experience, Fresher, and Intern classes.
 * @author IuseArchBTW
 */
public class Candidate {
    private int CandidateID;
    private String FirstName;
    private String LastName;
    private int BirthDate;
    private String Address;
    private String Phone;
    private String Email;

    private int candidateType;
    private String candidateTypeName;

    // Set to keep track of unique email addresses
    private static Set<String> emailSet = new HashSet<>();

    // Set to keep track of unique phone numbers
    private static Set<String> phoneSet = new HashSet<>();

    /**
     * Constructor for the Candidate class.
     *
     * @param CandidateID
     * @param FirstName
     * @param LastName
     * @param BirthDate
     * @param Address
     * @param Phone
     * @param Email
     */

    public Candidate(int CandidateID, String FirstName, String LastName, int BirthDate, String Address, String Phone, String Email) {
        this.CandidateID = CandidateID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BirthDate = BirthDate;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
    }

    /*
     * Empty constructor
     */
    public Candidate() {
    }


    /**
     * The method which handle each information of candidate and check for its availability
     * @return
     */
    public void input() {
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Prompt the user for their first name
        System.out.print("First Name: ");
        do {
            try {
                // Read the user's first name
                this.FirstName = sc.nextLine().trim();

                // Check if the first name is valid
                if (!isValidFirstName(getFirstName())) {
                    // If the first name is not valid, print an error message
                    System.out.println("First name: Must be a set of letters with the minimum of 2 characters");
                    System.out.print("First Name: ");
                } else {
                    // If the first name is too long, trim it to only the fifth character
                    if (this.FirstName.length() > 5) {
                        this.FirstName = this.FirstName.substring(0,1).toUpperCase() + this.FirstName.substring(1,5).toLowerCase();
                    }
                    // If the first name is valid, capitalize the first letter and break out of the loop
                    this.FirstName = this.FirstName.substring(0,1).toUpperCase() + this.FirstName.substring(1).toLowerCase();
                    break;
                }
            } catch (Exception e) {
                // If an exception is thrown, print an error message
                System.out.println("Invalid input");
            }
        } while (true);

        // Prompt the user for their last name
        System.out.print("Last Name: ");
        do {
            try {
                // Read the user's last name
                this.LastName = sc.nextLine().trim();

                // Check if the last name is valid
                if (!isValidLastName(getLastName())) {
                    // If the last name is not valid, print an error message
                    System.out.println("Last name: Must be a set of letters with the minimum of 2 characters");
                    System.out.print("Last Name: ");
                } else {
                    // If the last name is too long, trim it to only the first character with a . at the end
                    if (this.LastName.length() > 9) {
                        this.LastName = this.LastName.substring(0,1).toUpperCase() + ".";
                    }
                    // If the last name is valid, capitalize the first letter and break out of the loop
                    this.LastName = this.LastName.substring(0,1).toUpperCase() + this.LastName.substring(1);
                    break;
                }
            } catch (Exception e) {
                // If an exception is thrown, print an error message
                System.out.println("Invalid input");
            }
        } while (true);

        // Prompt the user for their birthdate
        System.out.print("Birth Date: ");
        do {
            try {
                // Read the user's birthdate as an integer
                this.BirthDate = Integer.parseInt(sc.nextLine().trim());

                // Check if the birthdate is valid
                if (!isValidBirthDate(getBirthDate())) {
                    // If the birthdate is not valid, print an error message
                    System.out.println("BirthDate : Must be from 1900 to " + (new Date().getYear() + 1900));
                    System.out.print("Birth Date: ");
                }
            } catch (Exception e) {
                // If an exception is thrown, print an error message
                System.out.println("BirthDate : Must be from 1900 to " + (new Date().getYear() + 1900));
                System.out.print("Birth Date: ");
            }
        } while (!isValidBirthDate(getBirthDate()));

        // Prompt the user for their address
        System.out.print("Address: ");

        // Loop to validate the user's input for address
        do {
            try {
                // Taking user input for address
                this.Address = sc.nextLine().trim();
                // Checking if the input is valid
                if (isValidAddress(getAddress())) {
                    System.out.println("Address: Can't be empty");
                    System.out.print("Address: ");
                } else {
                    // Capitalizing the first character of each word in the address
                    String[] words = getAddress().split("\\s");
                    StringBuilder sb = new StringBuilder();
                    for (String word : words) {
                        if (word.length() > 0) {
                            sb.append(Character.toUpperCase(word.charAt(0)));
                            sb.append(word.substring(1).toLowerCase());
                            sb.append(" ");
                        }
                    }
                    this.Address = sb.toString().trim();
                    // Breaking the loop if the input is valid
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (true);

        // Prompt the user for their phone number
        System.out.print("Phone Number: ");

        // Loop to validate the user's input for phone number
        do {
            try {
                // Taking user input for phone number
                this.Phone = sc.nextLine().trim();
                // Checking if the input is valid
                if (!isValidPhone(getPhone())) {
                    System.out.println("Phone number: Must be numbers with either 10 or 11 numbers and in the format 0xxxxxxxxx or 0xxxxxxxxxx");
                    System.out.print("Phone Number: ");
                } else if (isDuplicatePhone(getPhone())) {
                    System.out.println("Phone number: Is already in the database");
                    System.out.print("Phone Number: ");
                } else {
                    // Breaking the loop if the input is valid
                    phoneSet.add(getPhone());
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!isValidPhone(getPhone()) || phoneSet.contains(getPhone()));

        System.out.print("Email: ");

        // Loop to validate the user's input for email
        do {
            try {
                // Taking user input for email
                this.Email = sc.nextLine().trim();
                // Checking if the input is valid and check if the email is already in the database
                if (!isValidEmail(getEmail())) {
                    System.out.println("Email: Must follow this format <account name>@<domain>. (eg:huonglh3@fe.edu.vn)");
                    System.out.print("Email: ");
                } else if (isDuplicateEmail(getEmail())) {
                    System.out.println("Email: Is already in the database");
                    System.out.print("Email: ");
                } else {
                    // Breaking the loop if the input is valid
                    emailSet.add(getEmail());
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (!isValidEmail(getEmail()) || emailSet.contains(getEmail()));
    }

    /**
     * A helper method that converts a string to title case and check if the string is longer than 12 characters
     * @param str the string to convert
     * @return the title-cased string
     */
    public String toTitleCase(String str) {
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : str.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                sb.append(c);
            } else {
                if (capitalizeNext) {
                    sb.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    /**
     * The method which check if the address is valid or not
     *
     * @param address
     * @return
     */
    private boolean isValidAddress(String address) {
        //address cant be empty
        return address.isEmpty();
    }

    /**
     * The method which check if the last name is valid or not
     *
     * @param lastName
     * @return
     */
    private boolean isValidLastName(String lastName) {
        return lastName.length() >= 2 && lastName.matches("[a-zA-Z ]+");
    }

    /**
     * The method which check if the first name is valid or not
     *
     * @param firstName
     * @return
     */
    private boolean isValidFirstName(String firstName) {
        return firstName.length() >= 2 && firstName.matches("[a-zA-Z ]+");
    }

    /**
     * The method which check if the email is valid or not
     * @param email
     * @return
     */
    private boolean isValidEmail(String email) {
        if (email.length() > 15) {
            email = email.substring(0, 10) + "..." + email.substring(email.length() - 3);
        }
        return email.matches("^[a-zA-Z0-9][a-zA-Z0-9._%+-]*[a-zA-Z0-9]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    }
    /**
     * The method which check if the email is duplicate or not
     * @param email
     * @return
     */
    private boolean isDuplicateEmail(String email) {
        return emailSet.contains(email);
    }


    /**
     * The method which check if the birthdate is valid or not
     * @param birthDate
     * @return
     */
    private boolean isValidBirthDate(int birthDate) {
        //only accept birthdate as numbers only from 1900 to current year
        return birthDate >= 1900 && birthDate <= new Date().getYear() + 1900 && String.valueOf(birthDate).matches("^[0-9]*$");
    }

    /**
     * The method which check if the phone number is valid or not
     * @param Phone
     * @return
     */
    private boolean isValidPhone(String Phone) {
        // Check if the phone number is valid
        return Phone.length() == 11 && Phone.matches("^[0-9]*$") && Phone.charAt(0) == '0' && Phone.charAt(1) != '0' ||
                Phone.length() == 10 && Phone.matches("^[0-9]*$") && Phone.charAt(0) == '0' && Phone.charAt(1) != '0';
    }
    /**
     * The method which check if the phone number is duplicate or not
     * @param Phone
     * @return
     */
    private boolean isDuplicatePhone(String Phone) {
        return phoneSet.contains(Phone);
    }


    /**
     * The method which get the candidate ID
     * @return
     */
    public int getCandidateID() {
        return CandidateID;
    }

    /**
     * The method which set the candidate ID
     * @param candidateID
     */
    public void setCandidateID(int candidateID) {
        CandidateID = candidateID++;
    }

    /**
     * The method which get the first name
     * @return
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * The method which set the first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    /**
     * The method which get the last name
     * @return
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * The method which set the last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    /**
     * The method which get the birthdate
     * @return
     */
    public int getBirthDate() {
        return BirthDate;
    }

    /**
     * The method which set the birthdate
     *
     * @param birthDate
     */
    public void setBirthDate(int birthDate) {
        BirthDate = birthDate;
        if (isValidBirthDate(birthDate)) {
            birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("Invalid date format");
        }
        if (isValidBirthDate(birthDate)) {
            birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    /**
     * The method which get the address
     *
     * @return
     */
    public String getAddress() {
        //if length of address is greater than 15, then it will be shortened
        if (Address.length() > 15) {
            Address = Address.substring(0, 10) + "..." + Address.substring(Address.length() - 3);
        }
        return Address;
    }

    /**
     * The method which set the address
     *
     * @param address
     */
    public void setAddress(String address) {
        Address = address;
    }

    /**
     * The method which get the phone number
     *
     * @return
     */
    public String getPhone() {
        return Phone;
    }


    /**
     * The method which set the phone number
     *
     * @param phone
     */
    public void setPhone(String phone) {
        if (isValidPhone(phone)) {
            Phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone format");
        }
    }

    /**
     * The method which get the email
     *
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     * The method which set the email
     *
     * @param email
     */
    public void setEmail(String email) {
        if (isValidEmail(email)) {
            Email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    /**
     * The method which get the candidate type
     *
     * @return
     */
    public int getCandidateType() {
        return candidateType;
    }

    /**
     * The method which set the candidate type
     *
     * @param candidateType
     */
    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    /**
     * The method which get the candidate type name
     *
     * @return
     */
    public void setCandidateTypeName(String candidateTypeName) {
        this.candidateTypeName = candidateTypeName;
    }

    /**
     * The method which get the candidate type name depending on the candidate type
     * @return
     */
    public String getCandidateTypeName() {
        if(getCandidateType() == 0){
            return "Experience";
        }
        else if(getCandidateType() == 1){
            return "Fresher";
        }
        else if(getCandidateType() == 2){
            return "Internship";
        }
        else{
            return "Invalid";
        }
    }

    /**
     * The method which display the information of the candidate
     */
    @Override
    public String toString() {
        return "Candidate [CandidateID=" + CandidateID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", BirthDate=" + BirthDate + ", Address=" + Address + ", Phone=" + Phone + ", Email=" + Email;
    }
}
