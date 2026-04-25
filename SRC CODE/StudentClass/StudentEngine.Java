package SLMSWORKG10;

import java.util.Scanner;

/* -The StudentEngine class acts as a controller for Student data operations.
   -It manages an array-based database, handling CRUD (Create, Read, Update, Delete)
    operations and array shifting logic.
 */
public class StudentEngine {
    private Student[] students;
    private int studentCount;

    /*
     Initializes the storage array with a fixed size.
     */
    public StudentEngine(int capacity) {
        this.students = new Student[capacity];
        this.studentCount = 0;
    }

    //Task 1: ADD STUDENT

    /*
    Adds a new student object to the next available index in the array.
     */
    public boolean addStudent(Student student) {
        if (studentCount >= students.length) {
            System.err.println("Error: Storage limit reached. Cannot add more students.");
            return false;
        }

        students[studentCount++] = student;
        System.out.println("Success: Student record created.");
        return true;
    }

    // --- Task 3: SEARCH ---

    /*
     Internal logic to find a student by their unique ID.
     */
    public Student searchStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(id)) {
                return students[i];
            }
        }
        return null;
    }

    /*
     User Interface wrapper for the search functionality. 
     */
    public void searchStudentUI(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();

        Student s = searchStudent(id);

        if (s != null) {
            System.out.println("\n--- Match Found ---");
            s.displayStudent();
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }

    // Task 4: EDIT

    /*
     * Allows partial updates to a student's profile. 
     */
    public void editStudent(Scanner scanner) {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();

        Student s = searchStudent(id);

        if (s == null) {
            System.out.println("Error: Student record not found.");
            return;
        }

        System.out.println("Current details for " + s.getStudentName() + " (Press Enter to skip change):");

        System.out.print("New Name: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) s.setStudentName(name);

        System.out.print("New Gmail: ");
        String gmail = scanner.nextLine();
        if (!gmail.isEmpty()) s.setGmail(gmail);

        System.out.print("New Phone: ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) s.setPhoneNumber(phone);

        System.out.println("Profile updated successfully.");
    }
   
    // --- Task 5: VIEW ALL ---
   
    /**
     * Iterates through the active records and displays them in a numbered list.
     */
    public void displayAllStudents() {
        System.out.println("\n---------- STUDENT DIRECTORY ----------");

        if (studentCount == 0) {
            System.out.println("Database is currently empty.");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.print("Record #" + (i + 1) + " ");
            students[i].displayStudent();
        }

        System.out.println("Total Records: " + studentCount);
        System.out.println("---------------------------------------");
    }

    // --- Task 6: DELETE ---

    /*
     - Removes a student record by ID.
     */
     // Logic: Finds the index, shifts all subsequent elements left to close the gap, and nullifies the last element to prevent memory leaks.
   
    public void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(id)) {

                students[i].displayStudent();
                System.out.print("Are you sure you want to delete this record? (Y/N): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    // Shifting Logic: Moves every student after the deleted one one spot to the left
                    for (int j = i; j < studentCount - 1; j++) {
                        students[j] = students[j + 1];
                    }

                    // Clean up the duplicate reference at the end and decrease count
                    students[--studentCount] = null;

                    System.out.println("Record successfully purged.");
                } else {
                    System.out.println("Operation cancelled.");
                }
                return;
            }
        }

        System.out.println("Error: Student ID not found.");
    }
}
