package model;

public class Student {

    private String studentId;
    private String studentName;
    private String program;
    private String email;

    public Student(String studentId, String studentName, String program, String email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.program = program;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getProgram() {
        return program;
    }

    public String getEmail() {
        return email;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayStudent() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Name         : " + studentName);
        System.out.println("Program      : " + program);
        System.out.println("Email        : " + email);
    }
}
