/**
 * Doctor class
 */
public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private String availability;

    /**
     * Default constructor
     */
    public Doctor() {
        name = "";
        code = "";
        specialization = "";
        availability = "";
    }

    /**
     * Constructor with parameters
     * @param code
     * @param name
     * @param specialization
     * @param availability
     */
    public Doctor(String code, String name, String specialization, String availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * get the searched code
     * @return code
     */
    public String getSearchedCode() {
        return code;
    }

    /**
     * set the searched code
     * @param code
     */
    public void setSearchedCode(String code) {
        this.code = code;
    }

    /**
     * get the code
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * set the code
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set the name
     * @param name
     */
    public void setName(String name) {

        //if name contain more than 3 parts, like Tran Le Hoang Long, it will return as T. L. H. Long,
        if (name.split(" ").length > 3) {
            String[] names = name.split(" ");
            String firstName = names[0].substring(0, 1);
            String middleName = names[1].substring(0, 1);
            String lastName = names[2].substring(0, 1);
            this.name = firstName.toUpperCase() + ". " + middleName.toUpperCase() + ". " + lastName.toUpperCase() + ". " + names[3].substring(0, 4);
        }
        // if name contain 3 parts, like Tran Le Hoang, it will return as T. L. Hoang
        else if (name.split(" ").length == 3) {
            String[] names = name.split(" ");
            String firstName = names[0].substring(0, 1);
            String middleName = names[1].substring(0, 1);
            this.name = firstName.toUpperCase() + ". " + middleName.toUpperCase() + ". " + names[2].substring(0, 4);
        }
        //check if name is longer than 15 characters and shorten the first and last name as the first character
        else if (name.length() > 12) {
            String[] names = name.split(" ");
            String firstName = names[0].substring(0, 1);
            String lastName = names[1].substring(0, 1);
            this.name = firstName.toUpperCase() + ". " + lastName.toUpperCase() + ".";
        }
        else {
            this.name = name;
        }
    }

    /**
     * get the specialization
     * @return specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * set the specialization
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
        //if specialization is longer than 15 characters, shorten it to 14 characters
        if (specialization.length() > 14) {
            this.specialization = specialization.substring(0, 14);
        }
    }

    /**
     * get the availability
     * @return availability
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * set the availability
     * @param availability
     */
    public void setAvailability(String availability) {
        /*if availability = 0, it will return as "Not available"
        if (availability.equals("0")) {
            this.availability = "Not available";
        } */
        //if availability = 0, it will display in the table as a blank space
        if (availability.equals("0")) {
            this.availability = "";
        }
        this.availability = availability;
    }

    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", availability=" + availability +
                '}';
    }
}
