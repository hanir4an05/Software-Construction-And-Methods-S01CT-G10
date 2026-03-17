package SLMSWORKG10;

import java.util.Scanner;

// Main Class for Student Operations
public class DeleteStudent {
    private Student[] students;
    private int studentCount;

    public DeleteStudent(int capacity) {
        this.students = new Student[capacity];
        this.studentCount = 0;
    }

    // --- Search Logic ---
    public Student searchStudent(String studentID) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(studentID)) {
                return students[i];
            }
        }
        return null;
    }

    public void displaySearchResult(String studentID) {
        Student foundStudent = searchStudent(studentID);
        if (foundStudent != null) {
            System.out.println("\n=== PRODUCT OF SEARCH ===");
            foundStudent.displayStudent(); // Invoked display function
        } else {
            System.out.println("\nError: Student not found with ID: " + studentID);
        }
    }

    // --- Edit Logic ---
    public void editStudent(String studentID, Scanner scanner) {
        Student student = searchStudent(studentID);
        if (student == null) {
            System.out.println("Error: Student record not found.");
            return;
        }

        System.out.println("\n--- Current Student Data ---");
        student.displayStudent();

        System.out.println("\nEnter new details (Leave blank to keep current):");
        System.out.print("New Name [" + student.getStudentName() + "]: ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) student.setStudentName(name);

        System.out.print("New Gmail [" + student.getGmail() + "]: ");
        String gmail = scanner.nextLine();
        if (!gmail.trim().isEmpty()) student.setGmail(gmail);

        System.out.print("New Phone [" + student.getPhoneNumber() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.trim().isEmpty()) student.setPhoneNumber(phone);

        System.out.println("\n--- Update Successful. New Attributes: ---");
        student.displayStudent(); // Invoked display function
    }

    // --- Delete Logic ---
    public void deleteStudent(String studentID, Scanner scanner) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(studentID)) {
                
                System.out.println("\n=== TARGETED STUDENT RECORD ===");
                students[i].displayStudent(); // Invoked display function before delete

                System.out.print("\nCAUTION: Confirm deletion of this record? (Y/N): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    for (int j = i; j < studentCount - 1; j++) {
                        students[j] = students[j + 1];
                    }
                    students[studentCount - 1] = null;
                    studentCount--;
                    System.out.println("Success: Student record deleted.");
                    displayAllStudents(); // Validate deletion
                } else {
                    System.out.println("Deletion aborted.");
                }
                return;
            }
        }
        System.out.println("Error: Student with ID [" + studentID + "] not found.");
    }

    // --- Data Display (View All) ---
    public void displayAllStudents() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("            ALL REGISTERED STUDENTS            ");
        System.out.println("=".repeat(50));
        
        if (studentCount == 0) {
            System.out.println("        No student records found.        ");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.print("[" + (i + 1) + "] ");
                students[i].displayStudent();
            }
            System.out.println("\n" + "-".repeat(50));
            System.out.println("Total Registered Students: " + studentCount);
        }
    }
}

// Helper Class (Defined in same file to avoid creating new files)
class Student {
    private String studentName;
    private String studentID;
    private String gmail;
    private String phoneNumber;

    public Student(String studentName, String studentID, String gmail, String phoneNumber) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.gmail = gmail;
        this.phoneNumber = phoneNumber;
    }

    // Getters/Setters
    public String getStudentName() { return studentName; }
    public String getStudentID() { return studentID; }
    public String getGmail() { return gmail; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setStudentName(String name) { this.studentName = name; }
    public void setGmail(String gmail) { this.gmail = gmail; }
    public void setPhoneNumber(String phone) { this.phoneNumber = phone; }

    // Formatted Display Method
    public void displayStudent() {
        System.out.println("-------------------------------------------");
        System.out.println("ID    : " + studentID);
        System.out.println("Name  : " + studentName);
        System.out.println("Gmail : " + gmail);
        System.out.println("Phone : " + phoneNumber);
        System.out.println("-------------------------------------------");
    }
}