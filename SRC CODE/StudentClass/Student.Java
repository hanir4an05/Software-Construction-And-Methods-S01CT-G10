package SLMSWORKG10;

import java.util.Scanner;

public class Student {
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

    // Getters
    public String getStudentName() { return studentName; }
    public String getStudentID() { return studentID; }
    public String getGmail() { return gmail; }
    public String getPhoneNumber() { return phoneNumber; }
    
    // Setters
    public void setStudentName(String name) { this.studentName = name; }
    public void setGmail(String gmail) { this.gmail = gmail; }
    public void setPhoneNumber(String phone) { this.phoneNumber = phone; }

    public void displayStudent() {
        System.out.println("-------------------------------------------");
        System.out.println("ID    : " + studentID);
        System.out.println("Name  : " + studentName);
        System.out.println("Gmail : " + gmail);
        System.out.println("Phone : " + phoneNumber);
        System.out.println("-------------------------------------------");
    }
}

// Removed 'public' so it can stay in the same file, or move to DefineStudent.java
class DefineStudent {
    public Student inputStudent(Scanner scanner) {
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
}
