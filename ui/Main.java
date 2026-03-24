package ui;

import engine.CourseEngine;
import engine.StudentEngine;
import java.util.Scanner;
import model.Course;
import model.Student;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== COURSE MODULE (DO NOT TOUCH) =====
        CourseEngine engine = new CourseEngine(10);

        engine.addCourse(new Course("Software Construction", "CS101", 3,
                "Introduction to software development",
                "https://teams.microsoft.com/cs101"));
        engine.addCourse(new Course("Data Structures", "CS201", 4,
                "Advanced data structures and algorithms",
                "https://teams.microsoft.com/cs201"));
        engine.addCourse(new Course("Database Systems", "CS301", 3,
                "Database design and SQL",
                "https://teams.microsoft.com/cs301"));

        // ===== STUDENT MODULE =====
        DefineStudent studentInput = new DefineStudent();
        StudentEngine studentEngine = new StudentEngine(10);

        boolean running = true;

        while (running) {
            System.out.println("MAIN SYSTEM ");
            System.out.println("1. Course Management");
            System.out.println("2. Student Management");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String mainChoice = scanner.nextLine();

            switch (mainChoice) {

                // Course Module
                case "1":
                    boolean courseMenu = true;

                    while (courseMenu) {
                        System.out.println("\n===== COURSE MANAGEMENT SYSTEM =====");
                        System.out.println("1. Add New Course");
                        System.out.println("2. Search Course");
                        System.out.println("3. Edit Course");
                        System.out.println("4. Delete Course");
                        System.out.println("5. Display All Courses");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");

                        String choice = scanner.nextLine();

                        switch (choice) {
                            case "1":
                                engine.inputNewCourse(scanner);
                                break;

                            case "2":
                                System.out.print("Enter Course Code to search: ");
                                engine.displaySearchResult(scanner.nextLine());
                                break;

                            case "3":
                                System.out.print("Enter Course Code to edit: ");
                                engine.editCourse(scanner.nextLine(), scanner);
                                break;

                            case "4":
                                System.out.print("Enter Course Code to delete: ");
                                engine.deleteCourse(scanner.nextLine(), scanner);
                                break;

                            case "5":
                                engine.displayAllCourses();
                                break;

                            case "6":
                                courseMenu = false;
                                break;

                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                    break;

                // student module
                case "2":
                    boolean studentMenu = true;

                    while (studentMenu) {
                        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                        System.out.println("1. Add Student");
                        System.out.println("2. Search Student");
                        System.out.println("3. Edit Student");
                        System.out.println("4. Delete Student");
                        System.out.println("5. Display All Students");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");

                        String choice = scanner.nextLine();

                        switch (choice) {
                            case "1":
                                Student newStudent = studentInput.inputStudent(scanner);
                                studentEngine.addStudent(newStudent);
                                break;

                            case "2":
                                studentEngine.searchStudentUI(scanner);
                                break;

                            case "3":
                                studentEngine.editStudent(scanner);
                                break;

                            case "4":
                                studentEngine.deleteStudent(scanner);
                                break;

                            case "5":
                                studentEngine.displayAllStudents();
                                break;

                            case "6":
                                studentMenu = false;
                                break;

                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                    break;

                case "3":
                    System.out.println("Exiting system...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}