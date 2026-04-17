package SLMSWORKG10;

import java.util.*;

/*
-CourseEngine manages a collection of Course objects
- provides functionality to add, search, edit, delete, and display courses  using a fixed-size array.
*/
class CourseEngine {

    private Course[] courses;
    private int courseCount;

    /* Initializes the engine with a maximum capacity.*/
    public CourseEngine(int maxCourses) {
        courses = new Course[maxCourses];
        courseCount = 0;
    }

    /*
     - Handles user interaction to input details for a new course.
     -Includes validation to ensure required fields (eg. Name, Code, Credit) are provided.
     */
    public void inputNewCourse(Scanner scanner) {

        // Check if there is space in the array
        if (courseCount >= courses.length) {
            System.out.println("Course list is full.");
            return;
        }

        System.out.println("\n--- ADD NEW COURSE ---");/*task 1:add new course */

        /* Validation for Course Name(not null)*/
        String name;
        while (true) {
            System.out.print("Enter Course Name: ");
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("Error: Course Name cannot be empty.");
        }

        /*Validation for Course Code(not null)*/
        String code;
        while (true) {
            System.out.print("Enter Course Code: ");
            code = scanner.nextLine().trim();
            if (!code.isEmpty()) {
                break;
            }
            System.out.println("Error: Course Code cannot be empty.");
        }

        // Validation for Credit Hour (Must be an integer)
        int credit;
        while (true) {
            try {
                System.out.print("Enter Credit Hour: ");
                credit = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }

        System.out.print("Enter Course Summary: ");
        String summary = scanner.nextLine();

        System.out.print("Enter MS Teams Link: ");
        String link = scanner.nextLine();

        // Create and save the object
        Course newCourse = new Course(name, code, credit, summary, link);
        addCourse(newCourse);
    }

    /*
     Stores a Course object in the array and increments the counter.
      */
    public void addCourse(Course course) {
        courses[courseCount] = course;
        courseCount++;
        System.out.println("Course added successfully.");
    }

    /*
      Finds a course by its unique course code.
     */
    public Course searchCourse(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equalsIgnoreCase(code)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Searches for a course and prints its details to the console.
     * @param code The code of the course to find.
     */
    public void displaySearchResult(String code) {
        Course course = searchCourse(code);
        if (course != null) {
            System.out.println("\nCourse Found:");
            course.displayCourse();
        } else {
            System.out.println("Course not found.");
        }
    }

    /*
     - Allows updating of existing course details. 
     - Users can press Enter to skip fields they don't want to change.
     */
    public void editCourse(String code, Scanner scanner) {
        Course course = searchCourse(code);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("\nCurrent Course Info:");
        course.displayCourse();
        System.out.println("\nPress enter to keep current value.");

        // Update name
        System.out.print("New Course Name (" + course.getCourseName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            course.setCourseName(name);
        }

        // Update credit hours with basic error handling
        System.out.print("New Credit Hour (" + course.getCreditHour() + "): ");
        String creditInput = scanner.nextLine();
        if (!creditInput.isEmpty()) {
            try {
                course.setCreditHour(Integer.parseInt(creditInput));
            } catch (Exception e) {
                System.out.println("Invalid number. Keeping original.");
            }
        }

        // Update summary
        System.out.print("New Summary (" + course.getCourseSummary() + "): ");
        String summary = scanner.nextLine();
        if (!summary.isEmpty()) {
            course.setCourseSummary(summary);
        }

        // Update link
        System.out.print("New MS Teams Link (" + course.getMsTeamsLink() + "): ");
        String link = scanner.nextLine();
        if (!link.isEmpty()) {
            course.setMsTeamsLink(link);
        }

        System.out.println("\nCourse updated successfully.");
    }

    /* Removes a course from the array and shifts subsequent elements to fill the gap.*/
    public void deleteCourse(String code, Scanner scanner) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equalsIgnoreCase(code)) {
                System.out.println("\nCourse Found:");
                courses[i].displayCourse();

                System.out.print("Confirm delete (Y/N): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    /*Shift elements left to maintain array integrity*/
                    for (int j = i; j < courseCount - 1; j++) {
                        courses[j] = courses[j + 1];
                    }
                    courses[courseCount - 1] = null; // Clear the last reference
                    courseCount--;
                    System.out.println("Course deleted successfully.");
                }
                return;
            }
        }
        System.out.println("Course not found.");
    }

    /*Prints the details of all currently enrolled courses. */
    public void displayAllCourses() {
        if (courseCount == 0) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\n=== COURSE LIST ==");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("\nCourse " + (i + 1));
            System.out.println("-----------------");
            courses[i].displayCourse();
        }
    }
}
