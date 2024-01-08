public class Student {
    private int ID = 0;
    private String name;
    private String Semester;
    private String Coursename;

    public Student() {
        name = "";
        Semester = "";
        Coursename = "";
    }

    public Student(String name, String semester, String coursename) {
        this.name = name;
        Semester = semester;
        Coursename = coursename;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getCoursename() {
        return Coursename;
    }

    public void setCoursename(String coursename) {
        Coursename = coursename;
    }

    public String[] toStringArray() {
        return new String[] { ID + "", name, Semester, Coursename };
    }

    public void setAllAttributes(String[] data) {
        ID = Integer.parseInt(data[0]);
        name = data[1];
        Semester = data[2];
        Coursename = data[3];
    }
}