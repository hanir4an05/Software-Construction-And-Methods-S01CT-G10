package SLMSWORKG10;

import java.util.Scanner;

/**
 * Data class representing an individual Student.
 * Serves purely as a data structure with getters, setters, and basic display logic.
 */
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
