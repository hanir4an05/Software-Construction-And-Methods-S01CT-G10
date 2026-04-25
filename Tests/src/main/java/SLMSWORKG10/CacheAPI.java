package SLMSWORKG10;

/*
 -The CacheAPI class provides a lightweight, in-memory storage mechanism 
 - to track the most recently accessed student and course data.
 */
public class CacheAPI {

    // Stores the unique identifier for the last processed student
    private String lastStudentID = "";
    
    // Stores the unique code for the last processed course
    private String lastCourseCode = "";

    /*
      Updates the cache with a new Student ID.
     @param id The unique String identifier of the student to be cached.
     */
    public void saveStudent(String id) {
        if (id != null) {
            this.lastStudentID = id;
        }
    }

    /*
     Updates the cache with a new Course Code.
      @param code The alphanumeric code of the course to be cached.
     */
    public void saveCourse(String code) {
        if (code != null) {
            this.lastCourseCode = code;
        }
    }

    /*
     -Retrieves the most recently saved Student ID.
    -return a String representing the last student ID, or an empty string if none set.
     */
    public String getLastStudent() {
        return lastStudentID;
    }

    /*
     Retrieves the most recently saved Course Code.
     */
    public String getLastCourse() {
        return lastCourseCode;
    }
}
