package ui;

import java.util.Scanner;
import model.Student;

public class DefineStudent {

    public Student inputStudent(Scanner scanner) {
        System.out.println("\n=== ADD NEW STUDENT ===");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Program: ");
        String program = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        return new Student(studentId, studentName, program, email);
    }
}
