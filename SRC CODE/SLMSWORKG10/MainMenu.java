package SLMSWORKG10;

import java.util.Scanner;

 class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // course sample
        CourseEngine Courseengine = new CourseEngine(10);

        Courseengine.addCourse(new Course("Software Construction", "CS101", 3,
                "Introduction to software development",
                "https://teams.microsoft.com/cs101"));
        Courseengine.addCourse(new Course("Data Structures", "CS201", 4,
                "Advanced data structures and algorithms",
                "https://teams.microsoft.com/cs201"));
        Courseengine.addCourse(new Course("Database Systems", "CS301", 3,
                "Database design and SQL",
                "https://teams.microsoft.com/cs301"));

    
//String studentName, String studentID, String gmail, String phoneNumber
        // student module
        StudentEngine studentEngine = new StudentEngine(10);

          studentEngine.addStudent(new Student("aza", "sw001", "azaamelia00@gmail.com",
                "0191116674"));

            studentEngine.addStudent(new Student("aza", "sw001", "azaamelia00@gmail.com",
                "0191116674"));
       
            studentEngine.addStudent(new Student("aza", "sw001", "azaamelia00@gmail.com",
                "0191116674"));


        EnrollmentEngine enrollEngine =
        new EnrollmentEngine(studentEngine, Courseengine, 50);
            CacheAPI cache = new CacheAPI();

        boolean running = true;

        while (running) {
            System.out.println("\nMAIN SYSTEM ");
             System.out.println("------------ ");
            System.out.println("1. Course Management");
            System.out.println("2. Student Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String mainChoice = scanner.nextLine();

            switch (mainChoice) {

                // Course Module
                case "1":
                    boolean courseMenu = true;

                    while (courseMenu) {
                        System.out.println("\n---- COURSE MANAGEMENT SYSTEM ----");
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
                                Courseengine.inputNewCourse(scanner); /*create a error handling if any of the input is not entered */
                                break;

                            case "2":
                                System.out.print("Enter Course Code to search: ");
                                Courseengine.displaySearchResult(scanner.nextLine());//nice
                                break;

                            case "3":
                                System.out.print("Enter Course Code to edit: ");
                                Courseengine.editCourse(scanner.nextLine(), scanner);
                                break;

                            case "4":
                                System.out.print("Enter Course Code to delete: ");
                                Courseengine.deleteCourse(scanner.nextLine(), scanner);//can delete but alrweady there will show invalid insetad of course not found
                                break;

                            case "5":
                                Courseengine.displayAllCourses(); //nice  //maybe add a special option if its null
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
                                studentEngine.inputNewStudent(scanner);
                                break;

                            case "2":
                                studentEngine.searchStudentUI(scanner);//jjust like course
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
                                studentMenu = false;//what if add studemt already exist too?
                                break;

                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                    break;

                    case "3":

    boolean enrollMenu = true;

    while (enrollMenu) {

        System.out.println("\n===== ENROLLMENT SYSTEM =====");//gap problem
        System.out.println("1. Enroll Student To Course");
        System.out.println("2. Find Courses By Student");
        System.out.println("3. Find Students By Course");
        System.out.println("4. Back");
        System.out.print("Enter your choice: ");


        String choice = scanner.nextLine();

        switch (choice) {

            case "1":
                System.out.print("Enter Student ID: ");
                String sid = scanner.nextLine();

                System.out.print("Enter Course Code: ");
                String ccode = scanner.nextLine();

                enrollEngine.enrollStudent(sid, ccode);
                break;

            case "2":
                System.out.print("Enter Student ID: ");
                sid = scanner.nextLine();

                cache.saveStudent(sid);

                enrollEngine.listCoursesByStudent(sid);
                break;

            case "3":
                System.out.print("Enter Course Code: ");
                ccode = scanner.nextLine();

                cache.saveCourse(ccode);

                enrollEngine.listStudentsByCourse(ccode);//cleaning
                break;

            case "4":
                enrollMenu = false;
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
    break;

                case "4":
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
