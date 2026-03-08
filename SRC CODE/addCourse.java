import java.util.Scanner;

public class addCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 2.c: Create a list or array to store multiple course objects
        // We'll use an array of size 10 to match the Course2.java pattern
        Course[] courses = new Course[10];
        int courseCount = 0;

        System.out.println("===== TASK 2: COURSE INPUT IMPLEMENTATION =====");

        boolean adding = true;
        while (adding) {
            // Task 2.d: Implement checks / coding technique to prevent array out-of-bound
            // error
            if (courseCount >= courses.length) {
                System.out.println("\nError: Course list is full! (Max 10 courses)");
                break;
            }

            System.out.println("\nEntering Course Details (Course #" + (courseCount + 1) + "):");

            // Task 2.a: Input fields for each course attribute
            System.out.print("Enter Course Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Course Code: ");
            String code = scanner.nextLine();

            int credit = 0;
            while (true) {
                System.out.print("Enter Credit Hour: ");
                try {
                    credit = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a numeric value.");
                }
            }

            System.out.print("Enter Course Summary: ");
            String summary = scanner.nextLine();

            System.out.print("Enter MS Teams Link: ");
            String link = scanner.nextLine();

            // Task 2.b: Create and 'Submit' (add) the course profile
            courses[courseCount] = new Course(name, code, credit, summary, link);
            courseCount++;
            System.out.println("\nCourse added successfully!");

            if (courseCount < courses.length) {
                System.out.print("Do you want to add another course? (yes/no): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    adding = false;
                }
            } else {
                System.out.println("Capacity reached.");
                adding = false;
            }
        }

        // Display summary of entered courses
        System.out.println("\n--- Summary of Entered Courses ---");
        for (int i = 0; i < courseCount; i++) {
            System.out.println((i + 1) + ". " + courses[i].getCourseName() + " [" + courses[i].getCourseCode() + "]");
        }

        scanner.close();
    }
}
