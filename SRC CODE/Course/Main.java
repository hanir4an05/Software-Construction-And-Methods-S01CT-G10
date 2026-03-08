package SLMSWORKG10;

class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        CourseEngine engine = new CourseEngine(10);

        // Sample data
        engine.addCourse(new Course("Software Construction", "CS101", 3,
                "Introduction to software development",
                "https://teams.microsoft.com/cs101"));
        engine.addCourse(new Course("Data Structures", "CS201", 4,
                "Advanced data structures and algorithms",
                "https://teams.microsoft.com/cs201"));
        engine.addCourse(new Course("Database Systems", "CS301", 3,
                "Database design and SQL",
                "https://teams.microsoft.com/cs301"));

        boolean running = true;

        while (running) {
            System.out.println("\n===== COURSE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add New Course");
            System.out.println("2. search Courses");
            System.out.println("3.edit Course");
            System.out.println("4.delete Course");
             System.out.println("5. display all Course");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    engine.inputNewCourse(scanner);
                    break;

                

                case "2":
                    System.out.print("\nEnter Course Code to search: ");
                    String searchCode = scanner.nextLine();
                   engine.displaySearchResult(searchCode);
                    break;

                case "3":
                    System.out.print("\nEnter Course Code to edit: ");
                    String editCode = scanner.nextLine();
                  engine.editCourse(editCode, scanner);
                    break;

                case "4":
                     System.out.print("Enter Course Code to delete: ");
                   engine.deleteCourse(scanner.nextLine(), scanner);
                    break;



                case "5":
                    engine.displayAllCourses();
                    break;

                case "6":
                    System.out.println("\nExiting program");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}


