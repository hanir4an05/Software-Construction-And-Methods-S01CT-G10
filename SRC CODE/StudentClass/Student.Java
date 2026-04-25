package SLMSWORKG10;

import java.util.Scanner;

/*
 - The Student class represents the data model for a student in the system.
 -It follows the Encapsulation principle by keeping fields private and 
 -providing controlled access through getters and setters.
 */
public class Student {
    private String studentName;
    private String studentID; // Primary identifier
    private String gmail;
    private String phoneNumber;

    /*
     Constructs a new Student with all required profile information.
     */
    public Student(String studentName, String studentID, String gmail, String phoneNumber) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.gmail = gmail;
        this.phoneNumber = phoneNumber;
    }

    //  Methods (Getters)
    
    public String getStudentName() { return studentName; }
    public String getStudentID() { return studentID; }
    public String getGmail() { return gmail; }
    public String getPhoneNumber() { return phoneNumber; }
    
    // Methods (Setters) 
  

    public void setStudentName(String name) { this.studentName = name; }
    public void setGmail(String gmail) { this.gmail = gmail; }
    public void setPhoneNumber(String phone) { this.phoneNumber = phone; }

    /**
     * Prints a formatted summary of the student's profile to the console.
     */
    public void displayStudent() {
        System.out.println("-------------------------------------------");
        System.out.println("ID    : " + studentID);
        System.out.println("Name  : " + studentName);
        System.out.println("Gmail : " + gmail);
        System.out.println("Phone : " + phoneNumber);
        System.out.println("-------------------------------------------");
    }
}

/*
 Helper class to handle the creation logic of Student objects.
 */
class DefineStudent {
    
    /*
      Prompts the user via console to enter details for a new student.
     */
    public Student inputStudent(Scanner scanner) {
        System.out.println("\n--- Entering New Student Details ---");
        
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
