package SLMSWORKG10;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EnrollmentEngine.
 *
 * Covers:
 *  1. Successful enrollment of a valid student into a valid course
 *  2. Enrollment fails when the student ID does not exist
 *  3. Enrollment fails when the course code does not exist
 *  4. Duplicate enrollment is rejected
 *  5. listCoursesByStudent – returns enrolled courses for a student
 *  6. listCoursesByStudent – reports nothing when student has no enrollments
 *  7. listStudentsByCourse – returns enrolled students for a course
 *  8. listStudentsByCourse – reports nothing when course has no enrollees
 */
class EnrollmentEngineTest {

    private StudentEngine studentEngine;
    private CourseEngine courseEngine;
    private EnrollmentEngine enrollmentEngine;

    // Helper: capture System.out output produced by a Runnable
    private String captureOutput(Runnable action) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(baos));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return baos.toString();
    }

    @BeforeEach
    void setUp() {
        studentEngine    = new StudentEngine(10);
        courseEngine     = new CourseEngine(10);
        enrollmentEngine = new EnrollmentEngine(studentEngine, courseEngine, 20);

        // Pre-populate one student and one course for use across tests
        studentEngine.addStudent(new Student("Alice Smith", "S001", "alice@example.com", "555-1111"));
        courseEngine.addCourse(new Course("Software Construction", "SC101", 3, "Build software", "https://teams.link/SC101"));
    }

    // -----------------------------------------------------------------------
    // Test 1: Successful enrollment
    // -----------------------------------------------------------------------
    @Test
    @DisplayName("Enroll valid student into valid course -> success message")
    void testEnrollStudent_Success() {
        String output = captureOutput(() -> enrollmentEngine.enrollStudent("S001", "SC101"));

        assertTrue(output.contains("Success"), "Expected success message but got: " + output);
    }

    // -----------------------------------------------------------------------
    // Test 2: Student ID does not exist
    // -----------------------------------------------------------------------
    @Test
    @DisplayName("Enroll with unknown student ID -> error message")
    void testEnrollStudent_InvalidStudentID() {
        String output = captureOutput(() -> enrollmentEngine.enrollStudent("UNKNOWN", "SC101"));

        assertTrue(output.contains("Error") || output.contains("not found"),
                "Expected an error for unknown student but got: " + output);
    }

    // -----------------------------------------------------------------------
    // Test 3: Course code does not exist
    // -----------------------------------------------------------------------
    @Test
    @DisplayName("Enroll with unknown course code -> error message")
    void testEnrollStudent_InvalidCourseCode() {
        String output = captureOutput(() -> enrollmentEngine.enrollStudent("S001", "UNKNOWN"));

        assertTrue(output.contains("Error") || output.contains("not found"),
                "Expected an error for unknown course but got: " + output);
    }

    // -----------------------------------------------------------------------
    // Test 4: Duplicate enrollment is rejected
    // -----------------------------------------------------------------------
    @Test
    @DisplayName("Enroll same student-course pair twice -> duplicate notice on second attempt")
    void testEnrollStudent_DuplicateEnrollment() {
        enrollmentEngine.enrollStudent("S001", "SC101");   // first time – should succeed

        String secondOutput = captureOutput(() -> enrollmentEngine.enrollStudent("S001", "SC101"));

        assertTrue(secondOutput.contains("Duplicate") || secondOutput.contains("duplicate")
                        || secondOutput.contains("Notice"),
                "Expected duplicate notice but got: " + secondOutput);
    }

    // -----------------------------------------------------------------------
    // Test 5: listCoursesByStudent – student has at least one enrollment
    // -----------------------------------------------------------------------
    @Test
    @DisplayName("listCoursesByStudent returns course details after enrollment")
    void testListCoursesByStudent_Found() {
        enrollmentEngine.enrollStudent("S001", "SC101");

        String output = captureOutput(() -> enrollmentEngine.listCoursesByStudent("S001"));

        // The course name or code should appear in the output
        assertTrue(output.contains("SC101") || output.contains("Software Construction"),
                "Expected course info in output but got: " + output);
    }

    // -----------------------------------------------------------------------
    // Test 6: listCoursesByStudent – student has no enrollments
    // -----------------------------------------------------------------------
    @Test
    @DisplayName("listCoursesByStudent reports no courses when student has none")
    void testListCoursesByStudent_NotFound() {
        // Add a second student but do NOT enroll them
        studentEngine.addStudent(new Student("Bob Jones", "S002", "bob@example.com", "555-2222"));

        String output = captureOutput(() -> enrollmentEngine.listCoursesByStudent("S002"));

        assertTrue(output.contains("No courses") || output.contains("not found"),
                "Expected 'no courses' message but got: " + output);
    }

    // -----------------------------------------------------------------------
    // Test 7: listStudentsByCourse – course has at least one enrollee
    // -----------------------------------------------------------------------
    @Test
    @DisplayName("listStudentsByCourse returns student details after enrollment")
    void testListStudentsByCourse_Found() {
        enrollmentEngine.enrollStudent("S001", "SC101");

        String output = captureOutput(() -> enrollmentEngine.listStudentsByCourse("SC101"));

        assertTrue(output.contains("S001") || output.contains("Alice Smith"),
                "Expected student info in output but got: " + output);
    }

    // -----------------------------------------------------------------------
    // Test 8: listStudentsByCourse – course has no enrollees
    // -----------------------------------------------------------------------
    @Test
    @DisplayName("listStudentsByCourse reports no students when course has none")
    void testListStudentsByCourse_NotFound() {
        // Add a second course but do NOT enroll anyone in it
        courseEngine.addCourse(new Course("Data Structures", "DS201", 3, "DS basics", "https://teams.link/DS201"));

        String output = captureOutput(() -> enrollmentEngine.listStudentsByCourse("DS201"));

        assertTrue(output.contains("No students") || output.contains("not found"),
                "Expected 'no students' message but got: " + output);
    }
}
