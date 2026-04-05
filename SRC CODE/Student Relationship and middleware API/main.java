/**
 * Manages students, courses, and their relationships
 */
public class SLMS_Manager {

    // Store courses and students
    private Course[] courses = new Course[100];
    private Student[] students = new Student[100];

    /**
     * 2D Array (Relationship Matrix)
     * Row = Student
     * Column = Course
     * 1 = enrolled, 0 = not enrolled
     */
    private int[][] enrollmentMatrix = new int[100][100];

    // Counters to track amount of objects
    private int courseCount = 0;
    private int studentCount = 0;

    // =====================================================
    // HELPER METHODS (SEARCH INDEX)
    // =====================================================

    // Find student index using ID
    private int getStudentIndex(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equalsIgnoreCase(studentId)) {
                return i;
            }
        }
        return -1; // not found
    }

    // Find course index using code
    private int getCourseIndex(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equalsIgnoreCase(courseCode)) {
                return i;
            }
        }
        return -1; // not found
    }

    // (a) Add Course to Student
 
    public void addCourse(String studentId, String courseCode) {

        int sIndex = getStudentIndex(studentId);
        int cIndex = getCourseIndex(courseCode);

        // Check errors
        if (sIndex == -1) {
            System.out.println("Student not found!");
            return;
        }
        if (cIndex == -1) {
            System.out.println("Course not found!");
            return;
        }

        // Check duplicate
        if (enrollmentMatrix[sIndex][cIndex] == 1) {
            System.out.println("Already enrolled!");
            return;
        }

        // Assign relationship
        enrollmentMatrix[sIndex][cIndex] = 1;
        System.out.println("Course added to student.");
    }


    // (b) Add Student to Course (same logic)

    public void addStudent(String courseCode, String studentId) {
        addCourse(studentId, courseCode); // reuse
    }

 
    // (c) Find Course of a Student

    public void findCourse(String studentId) {

        int sIndex = getStudentIndex(studentId);

        if (sIndex == -1) {
            System.out.println("Student not found!");
            return;
        }

        boolean found = false;

        for (int i = 0; i < courseCount; i++) {
            if (enrollmentMatrix[sIndex][i] == 1) {
                courses[i].displayCourse();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No courses found.");
        }
    }

 
    // (d) List Courses 
    public void listCourses(String studentId) {
        findCourse(studentId);
    }


    // (e) Find Student in Course

    public void findStudent(String courseCode) {

        int cIndex = getCourseIndex(courseCode);

        if (cIndex == -1) {
            System.out.println("Course not found!");
            return;
        }

        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (enrollmentMatrix[i][cIndex] == 1) {
                students[i].displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found.");
        }
    }


    // (f) List Students

    public void listStudents(String courseCode) {
        findStudent(courseCode);
    }


    // ADD DATA 
    // Add new course into system
    public void insertCourse(Course course) {
        if (courseCount >= courses.length) {
            System.out.println("Course list full!");
            return;
        }

        courses[courseCount] = course;
        courseCount++;
    }

    // Add new student into system
    public void insertStudent(Student student) {
        if (studentCount >= students.length) {
            System.out.println("Student list full!");
            return;
        }

        students[studentCount] = student;
        studentCount++;
    }
}

