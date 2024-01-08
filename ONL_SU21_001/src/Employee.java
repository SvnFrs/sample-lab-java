public class Employee {

    private String id;
    private String name;
    private double salary;
    private double COE;

    /**
     * Create a default constructor
     */
    public Employee() {

    }

    /**
     * Create a constructor with given data
     *
     * @param id Employee ID
     * @param name Employee name
     * @param salary Employee salary
     * @param COE Employee COE
     */
    public Employee(String id, String name, double salary, double COE) {
        setId(id);
        setName(name);
        setSalary(salary);
        setCOE(COE);
    }

    /**
     * Get the employee ID
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Set employee ID
     *
     * @param id Employee ID
     */
    public void setId(String id) {
        Validation.checkId(id); // Validate ID
        this.id = id;
    }

    /**
     * Get the employee name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the employee name
     *
     * @param name Employee name
     */
    public void setName(String name) {
        Validation.checkString(name); // Validate name
        this.name = name;
    }

    /**
     * Get the employee salary
     *
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Set the employee salary
     *
     * @param salary Employee salary
     */
    public void setSalary(double salary) {
        Validation.checkSalary(salary); // Validate salary
        this.salary = salary;
    }

    /**
     * Get the employee COE value
     *
     * @return COE
     */
    public double getCOE() {
        return COE;
    }

    /**
     * Set the employee COE value
     *
     * @param COE COE value
     */
    public void setCOE(double COE) {
        Validation.checkCOE(COE); // Validate COE value
        this.COE = COE;
    }

    /**
     * Calculate employee salary
     *
     * @return salary
     */
    public double calSalary() {
        return salary; // Return employe salary
    }

    /**
     * Input data
     */
    public void input() {

    }

    /**
     * Output data
     */
    public void output() {

    }
}