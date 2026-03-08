class Course {

    // Attributes
    private String courseName;
    private String courseCode;
    private int creditHour;
    private String courseSummary;
    private String msTeamsLink;

    // Constructor
    public Course(String courseName, String courseCode,
                  int creditHour, String courseSummary,
                  String msTeamsLink) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHour = creditHour;
        this.courseSummary = courseSummary;
        this.msTeamsLink = msTeamsLink;
    }

    // Get Methods
    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public String getCourseSummary() {
        return courseSummary;
    }

    public String getMsTeamsLink() {
        return msTeamsLink;
    }

    // Setter Methods
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public void setCourseSummary(String courseSummary) {
        this.courseSummary = courseSummary;
    }

    public void setmsteamslink(String msTeamsLink) {
        this.msTeamsLink = msTeamsLink;
    }

    // Display Method
    public void displayCourse() {
        System.out.println("Course Name   : " + courseName);
        System.out.println("Course Code   : " + courseCode);
        System.out.println("Credit Hour   : " + creditHour);
        System.out.println("Summary       : " + courseSummary);
        System.out.println("MS Teams Link : " + msTeamsLink);
    }
}

// Number 3: Search Function
class CourseManager {
    private Course[] courses;
    private int courseCount;

    // Constructor
    public CourseManager(int maxCourses) {
        courses = new Course[maxCourses];
        courseCount = 0;
    }

    // Add course to the array
    public void addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount] = course;
            courseCount++;
        } else {
            System.out.println("Course list is full!");
        }
    }

    // Linear search function to find a course by course code
    public Course searchCourse(String searchCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equalsIgnoreCase(searchCode)) {
                return courses[i];
            }
        }
        return null; // Return null if not found
    }

    // Display search results
    public void displaySearchResult(String searchCode) {
        System.out.println("\n=== SEARCH RESULTS ===");
        System.out.println("Searching for course code: " + searchCode);
        
        Course foundCourse = searchCourse(searchCode);
        
        if (foundCourse != null) {
            System.out.println("\nCourse found!");
            System.out.println("===================");
            foundCourse.displayCourse();
        } else {
            System.out.println("\nCourse not found!");
        }
    }

    // Number 4: Edit Function
    public void editCourse(String searchCode, java.util.Scanner scanner) {
        System.out.println("\n=== EDIT COURSE ===");
        System.out.println("Searching for course code: " + searchCode);
        
        Course courseToEdit = searchCourse(searchCode);
        
        if (courseToEdit != null) {
            System.out.println("\nCourse found!");
            System.out.println("===================");
            courseToEdit.displayCourse();
            
            System.out.println("\n--- Edit Course Details ---");
            System.out.println("(Press Enter to keep current value)");
            
            // Edit course name
            System.out.print("\nEnter new Course Name [" + courseToEdit.getCourseName() + "]: ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) {
                courseToEdit.setCourseName(newName);
            }
            
            // Edit credit hour
            System.out.print("Enter new Credit Hour [" + courseToEdit.getCreditHour() + "]: ");
            String creditInput = scanner.nextLine();
            if (!creditInput.trim().isEmpty()) {
                try {
                    int newCredit = Integer.parseInt(creditInput);
                    courseToEdit.setCreditHour(newCredit);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number, keeping original value.");
                }
            }
            
            // Edit course summary
            System.out.print("Enter new Course Summary [" + courseToEdit.getCourseSummary() + "]: ");
            String newSummary = scanner.nextLine();
            if (!newSummary.trim().isEmpty()) {
                courseToEdit.setCourseSummary(newSummary);
            }
            
            // Edit MS Teams link
            System.out.print("Enter new MS Teams Link [" + courseToEdit.getMsTeamsLink() + "]: ");
            String newLink = scanner.nextLine();
            if (!newLink.trim().isEmpty()) {
                courseToEdit.setmsteamslink(newLink);
            }
            
            // Display edited course
            System.out.println("\n=== EDITED COURSE ===");
            courseToEdit.displayCourse();
            System.out.println("Course updated successfully!");
            
        } else {
            System.out.println("\nCourse not found!");
        }
    }

    // Display all courses
    public void displayAllCourses() {
        System.out.println("\n=== ALL COURSES ===");
        if (courseCount == 0) {
            System.out.println("No courses available.");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.println("\nCourse " + (i + 1) + ":");
                System.out.println("-------------------");
                courses[i].displayCourse();
            }
        }
    }
}

// Main class to test the search and edit functions
class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        CourseManager manager = new CourseManager(10);

        // Sample data
        manager.addCourse(new Course("Software Construction", "CS101", 3, 
                                     "Introduction to software development", 
                                     "https://teams.microsoft.com/cs101"));
        manager.addCourse(new Course("Data Structures", "CS201", 4, 
                                     "Advanced data structures and algorithms", 
                                     "https://teams.microsoft.com/cs201"));
        manager.addCourse(new Course("Database Systems", "CS301", 3, 
                                     "Database design and SQL", 
                                     "https://teams.microsoft.com/cs301"));

        boolean running = true;
        
        while (running) {
            System.out.println("\n===== COURSE MANAGEMENT SYSTEM =====");
            System.out.println("1. Display All Courses");
            System.out.println("2. Search Course");
            System.out.println("3. Edit Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    manager.displayAllCourses();
                    break;
                    
                case "2":
                    System.out.print("\nEnter Course Code to search: ");
                    String searchCode = scanner.nextLine();
                    manager.displaySearchResult(searchCode);
                    break;
                    
                case "3":
                    System.out.print("\nEnter Course Code to edit: ");
                    String editCode = scanner.nextLine();
                    manager.editCourse(editCode, scanner);
                    break;
                    
                case "4":
                    System.out.println("\nExiting program. Goodbye!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}