import java.util.List;

class Student {
    private String name;
    private int absenceCount;
    public Student(String name, int absenceCount) {
        this.name = name;
        this.absenceCount = absenceCount;
    }
    public String getName() {
        return name;
    }
    public int getAbsenceCount() {
        return absenceCount;
    }
}

public class SeatingChart {
    Student[][] seats;


    /************
    Part A
    ************/
    public SeatingChart(List<Student> studentList, int rows, int cols) {
        seats = new Student[rows][cols];
        int index = 0;
        for(int c = 0; c < cols; c++) {
            for(int r = 0; r < rows; r++) {
                if(index < studentList.size()) {
                    seats[r][c] = studentList.get(index);
                    index++;
                }
            }
        }
    }

    /************
    Part B
    ************/
    public int removeAbsentStudents(int allowedAbsences) {
        int count = 0;
        for(int r = 0; r < seats.length; r++) {
            for(int c = 0; c < seats[r].length; c++) {
                if(seats[r][c] != null && seats[r][c].getAbsenceCount() > allowedAbsences) {
                    seats[r][c] = null;
                    count++;
                }
            }
        }
        return count;
    }


}


/*

POINT BREAKDOWN


Part A: SeatingChart constructor (5pts)

+1 seats = new Student[rows][cols]; (or equivalent code)
+1 Accesses all elements of sudentList (No bounds errors on studentList)
+1 Accesses all necessary elements of seats array (No bounds errors on seats array, point lost if access not column-major order)
+1 Assigns value from studentList to at least one element in seats 	array
+1 On exit: All elements of seats have correct values (Minor loop bounds errors ok)


Part B: removeAbsentStudents (4pts)

+1 Accesses all elements of seats (No bounds errors)
+1 Calls getAbsenceCount() on Student object (Point lost if null case not handled correctly)
+1 Assigns null to all elements in seats array when absence count for occupying student > allowedAbsences (Point lost if seats array element changed in other cases)
+1 Computes and returns correct number of students removed

Question-Specific Penalties
-2 Consistently uses incorrect array name instead of seats/studentList


*/
