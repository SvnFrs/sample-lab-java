import java.util.Scanner;

public class CustomTable {
    private int ColumnGAP;
    public static final int DATA = 0;
    public static final int NUMBER = 1;

    public CustomTable() {
        ColumnGAP = 2;
    }

    public CustomTable(int columnGAP) {
        ColumnGAP = columnGAP;
    }

    public int getColumnGAP() {
        return ColumnGAP;
    }

    public void setColumnGAP(int columnGAP) {
        ColumnGAP = columnGAP;
    }

    @SuppressWarnings("resource")
    public String createMenu(String title, String[] option, int ReturnMode) {
        Scanner sc = new Scanner(System.in);
        int len = option.length;
        int mode = 0;
        System.out.println("\t" + title);
        for (int i = 0; i < len; i++) {
            System.out.println((i + 1) + ". " + option[i]);
        }
        System.out.print("\tPlease choose: ");
        do {
            try {
                mode = Integer.parseInt(sc.nextLine());
                if (!(mode >= 1 && mode <= len)) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please input from 1 to " + len + "!");
            }
        } while (!(mode >= 1 && mode <= len));

        if (ReturnMode == DATA)
            return option[mode - 1];
        else
            return mode + "";
    }

    @SuppressWarnings("resource")
    public String YesNoStatement(String Content) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Content);
        String option = "";

        do {
            try {
                option = sc.nextLine();
                if (!(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("N"))) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please input Y or N");
            }
        } while (!(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("N")));
        return option;
    }

    public void createTH(String[] TableHeader) {
        int len = TableHeader.length;
        int total_Table_Length = 0;
        // Counting all columns length
        for (String str : TableHeader) {
            total_Table_Length += (ColumnGAP * 3 + str.length());
        }
        total_Table_Length++;
        // Begin to draw the table header

        // Count the lenght of each column
        int SpaceCounting;
        int next;
        for (int i = 0; i < 3; i++) {

            // Reset the SpaceCounting each time begining the new line
            SpaceCounting = 0;
            next = 0;
            for (int j = 0; j < total_Table_Length; j++) {
                if (next < len && SpaceCounting - ColumnGAP == (TableHeader[next].length() + ColumnGAP * 2)) {
                    if (i == 0 || i == 2)
                        System.out.print("+");
                    else if (i == 1) {
                        System.out.print("|");
                    }
                    SpaceCounting = 1;
                    next++;
                } else {
                    // Normal drawing without exceptions
                    if ((i == 2 || i == 0)
                            && (j == 0 || j == total_Table_Length - 1))
                        System.out.print("+");
                    else if (i == 1 && (j == 0 || j == total_Table_Length - 1))
                        System.out.print("|");
                    else if (i == 0 || i == 2)
                        System.out.print("-");
                    else if (next < len
                            && i == 1
                            && (SpaceCounting - ColumnGAP < ColumnGAP
                                    || SpaceCounting - ColumnGAP > TableHeader[next].length() + ColumnGAP))
                        System.out.print(" ");
                    else if (next < len) {
                        System.out.print(TableHeader[next]);
                        for (int k = 0; k < ColumnGAP; k++) {
                            System.out.print(" ");
                        }
                        j += (TableHeader[next].length() + ColumnGAP - 1);
                        SpaceCounting += ((TableHeader[next].length()) + ColumnGAP - 1);
                    }
                    SpaceCounting++;
                }
            }
            System.out.println();
        }
    }

    public void createTB(String[] TableHeader, String[] DataRow) {
        int len = TableHeader.length;
        int total_Table_Length = 0;
        // Counting all columns length
        for (String str : TableHeader) {
            total_Table_Length += (ColumnGAP * 3 + str.length());
        }
        total_Table_Length++;
        // Begin to draw the table Body

        // Count the lenght of each column
        int SpaceCounting = 0;
        int next = 0;
        int SpaceBetweenColumns = 0;

        for (int i = 0; i < total_Table_Length; i++) {
            if (next < len && SpaceCounting - ColumnGAP == TableHeader[next].length() + ColumnGAP * 2) {
                System.out.print("|");
                SpaceCounting = 1;
                next++;
                if (next < len)
                    SpaceBetweenColumns = ColumnGAP * 2 + 1 + TableHeader[next].length();
            } else {
                if (i == 0) {
                    System.out.print("|");
                    SpaceBetweenColumns = ColumnGAP * 2 + 1 + TableHeader[next].length();
                } else {
                    for (int j = 0; j < ColumnGAP + 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print(DataRow[next]);
                    for (int j = 0; j < SpaceBetweenColumns - DataRow[next].length() - ColumnGAP - 1; j++) {
                        System.out.print(" ");
                    }

                    SpaceCounting += (SpaceBetweenColumns - 1);
                    i += (SpaceBetweenColumns - 1);
                }
                SpaceCounting++;
            }
        }
        System.out.println();
    }

    public void createTF(String[] TableFooter) {
        int len = TableFooter.length;
        int total_Table_Length = 0;
        // Counting all columns length
        for (String str : TableFooter) {
            total_Table_Length += (ColumnGAP * 3 + str.length());
        }
        total_Table_Length++;
        // Begin to draw the table footer

        // Count the lenght of each column
        int SpaceCounting = 0;
        int next = 0;

        for (int j = 0; j < total_Table_Length; j++) {
            if (next < len && SpaceCounting - ColumnGAP == (TableFooter[next].length() + ColumnGAP * 2)) {
                System.out.print("+");
                SpaceCounting = 1;
                next++;
            } else {
                // Normal drawing without exceptions
                if (j == 0)
                    System.out.print("+");
                else
                    System.out.print("-");
                SpaceCounting++;
            }
        }
        System.out.println();
    }

    public void createHR() {
        System.out.println("\n-------------------------------------------------------\n");
    }
}
