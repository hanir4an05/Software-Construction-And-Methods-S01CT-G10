package SLMSWORKG10;

import java.util.*;

class CourseEngine {

    private Course[] courses;
    private int courseCount;

    public CourseEngine(int maxCourses) {
        courses = new Course[maxCourses];
        courseCount = 0;
    }

    public void inputNewCourse(Scanner scanner) {
        if (courseCount >= courses.length) {
            System.out.println("Course list is full.");
            return;
        }

        System.out.println("\n--- ADD NEW COURSE ---");

        String name;
        while (true) {
            System.out.print("Enter Course Name: ");
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("Error: Course Name cannot be empty.");
        }

        String code;
        while (true) {
            System.out.print("Enter Course Code: ");
            code = scanner.nextLine().trim();
            if (!code.isEmpty()) {
                break;
            }
            System.out.println("Error: Course Code cannot be empty.");
        }

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

        Course newCourse = new Course(name, code, credit, summary, link);
        addCourse(newCourse);
    }

    public void addCourse(Course course) {
        courses[courseCount] = course;
        courseCount++;
        System.out.println("Course added successfully.");
    }

    public Course searchCourse(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equalsIgnoreCase(code)) {
                return courses[i];
            }
        }
        return null;
    }

    public void displaySearchResult(String code) {
        Course course = searchCourse(code);
        if (course != null) {
            System.out.println("\nCourse Found:");
            course.displayCourse();
        } else {
            System.out.println("Course not found.");
        }
    }

    public void editCourse(String code, Scanner scanner) {
        Course course = searchCourse(code);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("\nCurrent Course Info:");
        course.displayCourse();
        System.out.println("\nPress enter to keep current value.");

        System.out.print("New Course Name (" + course.getCourseName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            course.setCourseName(name);
        }

        System.out.print("New Credit Hour (" + course.getCreditHour() + "): ");
        String creditInput = scanner.nextLine();
        if (!creditInput.isEmpty()) {
            try {
                course.setCreditHour(Integer.parseInt(creditInput));
            } catch (Exception e) {
                System.out.println("Invalid number. Keeping original.");
            }
        }

        System.out.print("New Summary (" + course.getCourseSummary() + "): ");
        String summary = scanner.nextLine();
        if (!summary.isEmpty()) {
            course.setCourseSummary(summary);
        }

        System.out.print("New MS Teams Link (" + course.getMsTeamsLink() + "): ");
        String link = scanner.nextLine();
        if (!link.isEmpty()) {
            course.setMsTeamsLink(link);
        }

        System.out.println("\nCourse updated successfully.");
    }

    public void deleteCourse(String code, Scanner scanner) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equalsIgnoreCase(code)) {
                System.out.println("\nCourse Found:");
                courses[i].displayCourse();

                System.out.print("Confirm delete (Y/N): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    for (int j = i; j < courseCount - 1; j++) {
                        courses[j] = courses[j + 1];
                    }
                    courses[courseCount - 1] = null;
                    courseCount--;
                    System.out.println("Course deleted successfully.");
                }
                return;
            }
        }
        System.out.println("Course not found.");
    }

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
