package model;

public class Course {

    private String courseName;
    private String courseCode;
    private int creditHour;
    private String courseSummary;
    private String msTeamsLink;

    // Constructor
    public Course(String courseName, String courseCode, int creditHour, String courseSummary, String msTeamsLink) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHour = creditHour;
        this.courseSummary = courseSummary;
        this.msTeamsLink = msTeamsLink;
    }

    // Getters
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

    // Setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public void setCourseSummary(String courseSummary) {
        this.courseSummary = courseSummary;
    }

    public void setMsTeamsLink(String msTeamsLink) {
        this.msTeamsLink = msTeamsLink;
    }

    // Display method
    public void displayCourse() {
        System.out.println("Course Name   : " + courseName);
        System.out.println("Course Code   : " + courseCode);
        System.out.println("Credit Hour   : " + creditHour);
        System.out.println("Summary       : " + courseSummary);
        System.out.println("MS Teams Link : " + msTeamsLink);
    }
}
