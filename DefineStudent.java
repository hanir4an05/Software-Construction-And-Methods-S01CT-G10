package SLMSWORKG10;

import java.util.Scanner;

// Task 1: Student Profile input and submit function
public class DefineStudent {
    private Student[] students;
    private int studentCount;

    public DefineStudent(int capacity) {
        this.students = new Student[capacity];
        this.studentCount = 0;
    }

    // Adds a student profile into the array and prevents out-of-bounds insertion.
    public boolean submitStudentProfile(String studentName, String studentID, String gmail, String phoneNumber) {
        if (studentCount >= students.length) {
            System.out.println("Error: Student storage is full. Cannot add more records.");
            return false;
        }

        students[studentCount] = new Student(studentName, studentID, gmail, phoneNumber);
        studentCount++;
        return true;
    }

    // Collects Task 1 input and displays the submitted student profile.
    public void inputAndSubmitStudentProfile(Scanner scanner) {
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter Student Gmail: ");
        String gmail = scanner.nextLine();

        System.out.print("Enter Student Phone Number: ");
        String phoneNumber = scanner.nextLine();

        boolean isAdded = submitStudentProfile(studentName, studentID, gmail, phoneNumber);
        if (isAdded) {
            System.out.println("\nSuccess: Student profile submitted.");
            students[studentCount - 1].displayStudent();
        }
    }

    public int getStudentCount() {
        return studentCount;
    }

    public Student[] getStudents() {
        return students;
    }
}
