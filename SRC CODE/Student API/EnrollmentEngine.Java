public class EnrollmentEngine {

    private String[][] enrollments;
    private int count;

    private StudentEngine studentEngine;
    private CourseEngine courseEngine;

    public EnrollmentEngine(StudentEngine studentEngine, CourseEngine courseEngine, int size) {
        this.studentEngine = studentEngine;
        this.courseEngine = courseEngine;

        enrollments = new String[size][2];
        count = 0;
    }

    public void enrollStudent(String studentID, String courseCode) {

        if (studentEngine.searchStudent(studentID) == null) {
            System.out.println("Student not found.");
            return;
        }

        if (courseEngine.searchCourse(courseCode) == null) {
            System.out.println("Course not found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (enrollments[i][0].equalsIgnoreCase(studentID)
                    && enrollments[i][1].equalsIgnoreCase(courseCode)) {

                System.out.println("Duplicate enrollment not allowed.");
                return;
            }
        }

        enrollments[count][0] = studentID;
        enrollments[count][1] = courseCode;
        count++;

        System.out.println("Enrollment successful.");
    }

    public void listCoursesByStudent(String studentID) {

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (enrollments[i][0].equalsIgnoreCase(studentID)) {

                Course c = courseEngine.searchCourse(enrollments[i][1]);

                if (c != null) {
                    c.displayCourse();
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("Student has no assigned course.");
    }

    public void listStudentsByCourse(String courseCode) {

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (enrollments[i][1].equalsIgnoreCase(courseCode)) {

                Student s = studentEngine.searchStudent(enrollments[i][0]);

                if (s != null) {
                    s.displayStudent();
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("Course has no assigned student.");
    }
}

