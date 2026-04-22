package SLMSWORKG10;
import java.util.Scanner;

public class StudentEngine {
    private Student[] students;
    private int studentCount;

    public StudentEngine(int capacity) {
        students = new Student[capacity];
        studentCount = 0;
    }


    // Task 1: ADD STUDENT

    public boolean addStudent(Student student) {
        if (studentCount >= students.length) {
            System.out.println("Error: Storage full.");
            return false;
        }

        students[studentCount++] = student;
        System.out.println("Student added successfully!");
        return true;
    }

    

    // Task 3: SEARCH

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

    // Task 4: EDIT

    public void editStudent(Scanner scanner) {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();

        Student s = searchStudent(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        s.displayStudent();

        System.out.print("New Name: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) s.setStudentName(name);

        System.out.print("New Gmail: ");
        String gmail = scanner.nextLine();
        if (!gmail.isEmpty()) s.setGmail(gmail);

        System.out.print("New Phone: ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) s.setPhoneNumber(phone);

        System.out.println("Updated Successfully:");
        s.displayStudent();
    }
   
    // Task 5: VIEW ALL
   
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

    // Task 6: DELETE

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
