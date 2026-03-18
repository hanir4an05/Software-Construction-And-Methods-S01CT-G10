package SLMSWORKG10;

import java.util.Scanner;

// Task 2: Create function development (input, submit, list storage, bounds check)
public class AddStudent {
    private Student[] students;
    private int studentCount;

    public AddStudent(int capacity) {
        this.students = new Student[capacity];
        this.studentCount = 0;
    }

    // Creates one student object from console input fields.
    public Student collectStudentInput(Scanner scanner) {
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter Student Gmail: ");
        String gmail = scanner.nextLine();

        System.out.print("Enter Student Phone Number: ");
        String phoneNumber = scanner.nextLine();

        return new Student(studentName, studentID, gmail, phoneNumber);
    }

    // Simulates the Submit action: add a student into storage if there is space.
    public boolean submitStudent(Student student) {
        if (studentCount >= students.length) {
            System.out.println("Error: Student storage is full. Cannot add more records.");
            return false;
        }

        students[studentCount] = student;
        studentCount++;
        return true;
    }

    // Full Task 2 flow: input fields, submit, then display the added profile.
    public void inputAndSubmit(Scanner scanner) {
        Student newStudent = collectStudentInput(scanner);
        boolean isAdded = submitStudent(newStudent);

        if (isAdded) {
            System.out.println("\nSuccess: Student profile added.");
            students[studentCount - 1].displayStudent();
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public int getStudentCount() {
        return studentCount;
    }
}
