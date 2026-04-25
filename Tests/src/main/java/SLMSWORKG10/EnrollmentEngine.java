package SLMSWORKG10;

/*
- The EnrollmentEngine manages the relationship between students and courses.
- It handles the registration process, prevents duplicate enrollments,and provides lookup capabilities for student-course associations.
 */
public class EnrollmentEngine {

    // A 2D array where each row is a pair: [0] = studentID, [1] = courseCode
    private String[][] enrollments;
    
    // Tracks the current number of active enrollments in the array
    private int count;

    // References to the engines responsible for student and course data
    private StudentEngine studentEngine;
    private CourseEngine courseEngine;

    /*
     Initializes the enrollment system with necessary dependencies and capacity.
     */
    public EnrollmentEngine(StudentEngine studentEngine, CourseEngine courseEngine, int size) {
        this.studentEngine = studentEngine;
        this.courseEngine = courseEngine;
        this.enrollments = new String[size][2];
        this.count = 0;
    }

    /*
    - Links a student to a course after performing validation checks.
    */
    

   
    public void enrollStudent(String studentID, String courseCode) {

        // 1. Validate Student existence
        if (studentEngine.searchStudent(studentID) == null) {
            System.out.println("Error: Student ID " + studentID + " not found.");
            return;
        }

        // 2. Validate Course existence
        if (courseEngine.searchCourse(courseCode) == null) {
            System.out.println("Error: Course code " + courseCode + " not found.");
            return;
        }

        // 3. Prevent duplicate enrollment records
        for (int i = 0; i < count; i++) {
            if (enrollments[i][0].equalsIgnoreCase(studentID)
                    && enrollments[i][1].equalsIgnoreCase(courseCode)) {

                System.out.println("Notice: Duplicate enrollment not allowed.");
                return;
            }
        }

        // 4. Store the enrollment and increment counter
        enrollments[count][0] = studentID;
        enrollments[count][1] = courseCode;
        count++;

        System.out.println("Success: Enrollment completed.");
    }

    /*
     Searches through enrollments and displays all courses associated with a specific student.
     */
    public void listCoursesByStudent(String studentID) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            // Match the student ID in the first column
            if (enrollments[i][0].equalsIgnoreCase(studentID)) {
                Course c = courseEngine.searchCourse(enrollments[i][1]);

                if (c != null) {
                    c.displayCourse();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No courses found for student: " + studentID);
        }
    }

    /*
     Searches through enrollments and displays all students registered for a specific course.
     */
    public void listStudentsByCourse(String courseCode) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            // Match the course code in the second column
            if (enrollments[i][1].equalsIgnoreCase(courseCode)) {
                Student s = studentEngine.searchStudent(enrollments[i][0]);

                if (s != null) {
                    s.displayStudent();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No students registered for course: " + courseCode);
        }
    }
}
