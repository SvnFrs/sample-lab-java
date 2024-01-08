import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> StuList = new ArrayList<>();
    private static int NumberOfStudents;
    private int MODE;
    private CustomTable table = new CustomTable();

    // Some final variables
    private final int MIN_STUDENTS = 10;
    private final String AllAtrributeTH[] = { "No.", "Student name", "Semester", "Course" };
    private final String NormalTH[] = { "Student name", "Semester", "Course" };
    private final String ReportTH[] = { "No.", "Student name", "Course", "Total of course" };
    private final String MainMenu[] = { "Create", "Find and Sort", "Update/Delete", "Report", "Exit" };
    private final String CreateMenu[] = { "Manual input", "Random 10 Students (For Testing Purpose)",
            "Random 100 Students (For Testing Purpose)" };
    private final String UpdateMenu[] = { "Name", "Semester", "Course", "Exit Update" };
    private final String Semester[] = { "SP", "SU", "FA" };
    private final String Course[] = { "Java", ".Net", "C/C++" };
    private final String RandomName[] = { "Nguyen Van ", "Tran Van ", "Le Thi ",
            "Nguyen Ha ", "Lam Thi ", "Le Chan ",
            "Ton Le ", "Dang Van ", "Nguyen Le " };

    public StudentManagement() {
        MODE = 0;
        NumberOfStudents = 0;
    }

    // Initialize the table

    // Initialize the Menu
    public void initMenu() {
        do {
            MODE = Integer.parseInt(
                    table.createMenu("Welcome to Student Management\n\t\t(Main Menu)", MainMenu, CustomTable.NUMBER));
            HandleMode();
            table.createHR();
        } while (MODE != 5);
    }

    private void HandleMode() {
        switch (MODE) {
            case 1:
                Create();
                break;
            case 2:
                Find();
                break;
            case 3:
                HandleUpdateDelete();
                break;
            case 4:
                Report();
                break;
            case 5:
                // TODO : will do something later;
                System.exit(0);
                break;
        }
    }

    // Create Sections
    @SuppressWarnings("resource")
    private void Create() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        // Handle the Create Menu Input
        table.createHR();
        option = Integer
                .parseInt(table.createMenu("\t\t(Create Menu)\n\tSelect Create Modes:", CreateMenu,
                        CustomTable.NUMBER));

        // Handling 2 Modes
        if (option == 1) {
            // Manual input
            try {
                // TODO: handle manual input
                do {
                    Student temp = new Student();
                    table.createHR();
                    temp.setID(NumberOfStudents + 1);
                    System.out.print("Name of the student: ");
                    temp.setName(sc.nextLine());
                    temp.setSemester(table.createMenu("\tPlease choose a semester", Semester, CustomTable.DATA));
                    temp.setCoursename(table.createMenu("\tPlease choose a course", Course, CustomTable.DATA));
                    StuList.add(temp);
                    NumberOfStudents++;
                } while (StuList.size() < MIN_STUDENTS);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (option == 2 || option == 3) {
            // Generate 10 random Students for Testing Purpose
            Random rand = new Random();
            int Number = MIN_STUDENTS * (option == 3 ? 10 : 1);
            for (int i = 0; i < Number; i++) {
                Student temp = new Student();
                temp.setID(StuList.size() + 1);
                temp.setName(RandomName[rand.nextInt(RandomName.length)] + (char) (65 + rand.nextInt(26)));
                temp.setSemester(Semester[rand.nextInt(Semester.length)]);
                temp.setCoursename(Course[rand.nextInt(Course.length)]);
                StuList.add(temp);
                NumberOfStudents++;
            }
        }
        // TODO: Change this later
        System.out.println("Creating 10" + (option == 3 ? "0" : "") + " Students successfully!!!!!!");
    }

    // Find and Sort Students Sections
    @SuppressWarnings("resource")
    private void Find() {
        Scanner sc = new Scanner(System.in);
        SortByName();
        String temp[] = new String[3];
        table.createTH(NormalTH);
        for (int i = 0; i < StuList.size(); i++) {
            temp[0] = StuList.get(i).getName() + "";
            temp[1] = StuList.get(i).getSemester() + "";
            temp[2] = StuList.get(i).getCoursename() + "";
            table.createTB(NormalTH, temp);
        }
        table.createTF(NormalTH);
        table.createHR();
        // Begin to find
        temp = null;
        temp = new String[4];
        String tempTable[] = new String[] { "ID", NormalTH[0], NormalTH[1], NormalTH[2] };
        String name = "", tempName;
        boolean found = false;
        boolean THcreated = false;
        try {
            System.out.print("Find name : ");
            name = sc.nextLine();
            for (Student index : StuList) {
                tempName = index.getName();
                if (index != null && name.length() <= tempName.length() &&
                        tempName.substring(0, name.length()).equalsIgnoreCase(name)) {
                    temp[0] = index.getID() + "";
                    temp[1] = index.getName() + "";
                    temp[2] = index.getSemester() + "";
                    temp[3] = index.getCoursename() + "";
                    found = true;
                    if (!THcreated && found) {
                        table.createTH(tempTable);
                        THcreated = true;
                    }
                    if (found) {
                        table.createTB(tempTable, temp);
                    }
                }
            }
            if (!found) {
                table.createTH(new String[] { "\"" + name + "\"" + " didn't exist in the database." });
            } else {
                table.createTF(tempTable);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update and Delete Students Sections
    @SuppressWarnings("resource")
    private void HandleUpdateDelete() {
        int tempID = 0;
        int tempIndex = 0;
        String tempData[] = new String[4];
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        SortByID();
        do {
            try {
                System.out.print("Find ID: ");
                tempID = Integer.parseInt(sc.nextLine());
                for (Student i : StuList) {
                    if (tempID == i.getID()) {
                        found = true;
                        tempData = i.toStringArray();
                        tempIndex = StuList.indexOf(i);
                        break;
                    }
                }
                if (!found) {
                    table.createTH(new String[] { "\"" + tempID + "\"" + " didn't exist in the database" });
                } else {
                    table.createTH(AllAtrributeTH);
                    table.createTB(AllAtrributeTH, tempData);
                    table.createTF(AllAtrributeTH);
                }
                break;
            } catch (Exception e) {
                System.out.println("Please input number!");
            }
        } while (true);
        if (found) {
            do {
                try {
                    System.out.println("Do you want to update (U) or delete (D) student? ");
                    String temp = sc.nextLine();
                    if (temp.equalsIgnoreCase("U")) {
                        Update(tempIndex);
                        break;
                    } else if (temp.equalsIgnoreCase("D")) {
                        Delete(tempIndex);
                        table.createTH(new String[] { "Delete " + "\"" + tempID + "\"" + " successfully!" });
                        break;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Please input U or D");
                }
            } while (true);
        }
    }

    private void Update(int index) {
        int option = 0;
        String before[] = StuList.get(index).toStringArray();
        String after[] = StuList.get(index).toStringArray();
        String tempHeader[] = new String[5];
        String tempData[] = new String[5];
        tempHeader[0] = "  State  ";
        for (int i = 1; i < 5; i++) {
            tempHeader[i] = AllAtrributeTH[i - 1];
        }
        boolean changed = false;
        // Begining the Update loop
        do {
            table.createHR();
            option = Integer
                    .parseInt(table.createMenu("Which one do you want to update?", UpdateMenu, CustomTable.NUMBER));

            if (option != 4) {
                UpdateData(after, option);
                table.createTH(AllAtrributeTH);
                table.createTB(AllAtrributeTH, after);
                table.createTF(AllAtrributeTH);
                changed = true;
            }
        } while (option != 4);
        // Ask the user to confirm the update
        if (changed) {
            // Show before and after the update
            table.createTH(tempHeader);
            tempData[0] = "Before";
            for (int i = 1; i < 5; i++) {
                tempData[i] = before[i - 1];
            }
            table.createTB(tempHeader, tempData);
            tempData[0] = "After";
            for (int i = 1; i < 5; i++) {
                tempData[i] = after[i - 1];
            }
            table.createTB(tempHeader, tempData);
            table.createTF(tempHeader);
            String confirm = table.YesNoStatement("Do you want to keep the update? (Y/N)");
            if (confirm.equalsIgnoreCase("Y")) {
                StuList.get(index).setAllAttributes(after);
                System.out.print("Update successfully!");
            } else {
                System.out.print("The data didn't change");
            }
        }
    }

    @SuppressWarnings("resource")
    private void UpdateData(String[] data, int mode) {
        String tempData = "";
        Scanner sc = new Scanner(System.in);
        try {
            switch (mode) {
                case 1:
                    System.out.print("Name: ");
                    tempData = sc.nextLine();
                    break;
                case 2:
                    table.createHR();
                    tempData = table.createMenu("Please choose a Semester", Semester, CustomTable.DATA);
                    break;
                case 3:
                    table.createHR();
                    tempData = table.createMenu("Please choose a Course", Course, CustomTable.DATA);
                    break;
            }
            data[mode] = tempData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void Delete(int index) {
        StuList.remove(index);
    }

    // Report Student Section
    private void Report() {
        SortByID();
        table.createTH(ReportTH);
        String temp[] = new String[4];
        List<Student> tempList = new ArrayList<>(StuList);

        int count = 1;
        while (!tempList.isEmpty()) {
            String tempName = tempList.get(0).getName();
            String tempCoursename = tempList.get(0).getCoursename();
            temp[0] = count + "";
            temp[1] = tempName;
            temp[2] = tempCoursename;
            temp[3] = TotalCourse(tempList.get(0), tempList) + "";
            table.createTB(ReportTH, temp);
            count++;
        }
        table.createTF(ReportTH);
    }

    private int TotalCourse(Student student, List<Student> list) {
        int total = 0;
        int len = list.size();
        String tempN, tempN2, tempCN, tempCN2;
        tempN = student.getName();
        tempCN = student.getCoursename();
        for (int i = 0; i < len; i++) {
            tempN2 = list.get(i).getName();
            tempCN2 = list.get(i).getCoursename();
            if (tempN.equalsIgnoreCase(tempN2) && tempCN.equalsIgnoreCase(tempCN2)) {
                total++;
                // Remove the Object when done counting
                list.remove(i);
                i--;
                len = list.size();
            }
        }
        return total;
    }

    // Sort Sections
    private void SortByID() {
        Collections.sort(StuList, (Id1, Id2) -> Integer.compare(Id1.getID(), Id2.getID()));
    }

    private void SortByName() {
        Collections.sort(StuList, (name1, name2) -> name1.getName().compareTo(name2.getName()));
    }

    // Getter and Setter Section
    public String[] getReportTH() {
        return ReportTH;
    }

    public String[] getNormalTH() {
        return NormalTH;
    }

    public CustomTable getTable() {
        return table;
    }

    public void setTable(CustomTable table) {
        this.table = table;
    }
}