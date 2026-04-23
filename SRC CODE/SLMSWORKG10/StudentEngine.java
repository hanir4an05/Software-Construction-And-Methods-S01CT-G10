package SLMSWORKG10;

import java.util.Scanner;

/**
 * Manages operations and storage for student records.
 * Follows Single Responsibility Principle (SRP) by handling arrays and logics centrally.
 */
public class StudentEngine {
    private Student[] students;
    private int studentCount;

    /**
     * Initializes the Student Engine.
     * @param capacity the maximum number of students to store
     */
    public StudentEngine(int capacity) {
        students = new Student[capacity];
        studentCount = 0;
    }

    /**
     * Prompts terminal input to capture and validate student details.
     * @param scanner Scanner instance for console input
     */
    public void inputNewStudent(Scanner scanner) {
        if (studentCount >= students.length) {
            System.out.println("Error: Storage full.");
            return;
        }

        System.out.println("\n--- ADD NEW STUDENT ---");

        String studentName;
        while (true) {
            System.out.print("Enter Student Name: ");
            studentName = scanner.nextLine().trim();
            if (studentName.isEmpty()) {
                System.out.println("Error: Student Name cannot be empty.");
            } else if (studentName.matches(".*\\d.*")) {
                System.out.println("Error: Student Name should not contain numbers.");
            } else {
                break;
            }
        }

        String studentID;
        while (true) {
            System.out.print("Enter Student ID: ");
            studentID = scanner.nextLine().trim();
            if (studentID.isEmpty()) {
                System.out.println("Error: Student ID cannot be empty.");
            } else {
                break;
            }
        }

        String gmail;
        while (true) {
            System.out.print("Enter Student Gmail: ");
            gmail = scanner.nextLine().trim();
            if (gmail.isEmpty()) {
                System.out.println("Error: Gmail cannot be empty.");
            } else if (!gmail.contains("@") || !gmail.contains(".")) {
                System.out.println("Error: Invalid Gmail format (must contain '@' and '.').");
            } else {
                break;
            }
        }

        String phoneNumber;
        while (true) {
            System.out.print("Enter Student Phone Number: ");
            phoneNumber = scanner.nextLine().trim();
            if (phoneNumber.isEmpty()) {
                System.out.println("Error: Phone Number cannot be empty.");
            } else if (!phoneNumber.matches("\\d+")) {
                System.out.println("Error: Phone Number should only contain digits.");
            } else {
                break;
            }
        }

        Student newStudent = new Student(studentName, studentID, gmail, phoneNumber);
        addStudent(newStudent);
    }

    public boolean addStudent(Student student) {
        if (studentCount >= students.length) {
            System.out.println("Error: Storage full.");
            return false;
        }

        students[studentCount++] = student;
        System.out.println("Student added successfully!");
        return true;
    }

    public Student searchStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(id)) {
                return students[i];
            }
        }
        return null;
    }

    public void searchStudentUI(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();

        Student s = searchStudent(id);

        if (s != null) {
            System.out.println("\nStudent Found:");
            s.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void editStudent(Scanner scanner) {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine().trim();

        Student s = searchStudent(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nCurrent Student Info:");
        s.displayStudent();
        System.out.println("\nPress Enter to keep current value.");

        // Edit Name
        while (true) {
            System.out.print("New Name (" + s.getStudentName() + "): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                break; // Skip edit
            } else if (name.matches(".*\\d.*")) {
                System.out.println("Error: Name should not contain numbers.");
            } else {
                s.setStudentName(name);
                break;
            }
        }

        // Edit Gmail
        while (true) {
            System.out.print("New Gmail (" + s.getGmail() + "): ");
            String gmail = scanner.nextLine().trim();
            if (gmail.isEmpty()) {
                break; // Skip edit
            } else if (!gmail.contains("@") || !gmail.contains(".")) {
                System.out.println("Error: Invalid Gmail format (must contain '@' and '.').");
            } else {
                s.setGmail(gmail);
                break;
            }
        }

        // Edit Phone Number
        while (true) {
            System.out.print("New Phone (" + s.getPhoneNumber() + "): ");
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()) {
                break; // Skip edit
            } else if (!phone.matches("\\d+")) {
                System.out.println("Error: Phone Number should only contain digits.");
            } else {
                s.setPhoneNumber(phone);
                break;
            }
        }

        System.out.println("\nUpdated Successfully:");
        s.displayStudent();
    }
   
    public void displayAllStudents() {
        System.out.println("\n===== ALL STUDENTS =====");

        if (studentCount == 0) {
            System.out.println("No records found.");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.print("[" + (i + 1) + "] ");
            students[i].displayStudent();
        }

        System.out.println("Total: " + studentCount);
    }

    public void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(id)) {

                students[i].displayStudent();

                System.out.print("Confirm delete (Y/N): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    for (int j = i; j < studentCount - 1; j++) {
                        students[j] = students[j + 1];
                    }

                    students[--studentCount] = null;

                    System.out.println("Deleted successfully!");
                } else {
                    System.out.println("Cancelled.");
                }
                return;
            }
        }

        System.out.println("Student not found.");
    }
}
