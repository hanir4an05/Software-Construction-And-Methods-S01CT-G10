# Lab 1 and 2 Report: SLMS Software Construction Plan

## Lab 1 Activities: Repository and Team Setup
- **Formation of group members:** 
  1. HARIZ IRFAN BIN MOHD SHAMIR (Team Leader)
  2. MOHAMMAD DANISH DANIAL BIN MOHD ROSLI
  3. MUHAMAD IRFAN BIN ZUHAIMIN
  4. KESHAV KALAIVANI SURESH
- **Setup repository (codebase) in Github:**
  - The repository was initialized.
  - The team leader authorized main branch activities and invited all team members and the lecturer as collaborators.
- **Exploration:** Evaluated the main reference site (Moodle) and codebase structures to plan the development.

---

## Lab 2 Activities: Pre-set Software Construction Standards

### 1. Draft Use Case and Class Design
**Use Cases:**
- **Course Management:** Add Course, Search Course by Code, Edit Course, Delete Course, Display All Courses.
- **Student Management:** Add Student, Search Student by ID, Edit Student Info, Delete Student, Display All Students.
- **Enrollment Management:** Enroll Student to Course, Find Courses by Student ID, Find Students by Course ID.

**Class Design (Core Entities):**
- **`Student` Data Class:** Models a student with attributes `studentName`, `studentID`, `gmail`, `phoneNumber`. Includes getters, setters, and `displayStudent()` method.
- **`Course` Data Class:** Models a course with attributes `courseName`, `courseCode`, `creditHour`, `courseSummary`, `msTeamsLink`. Includes getters, setters, and `displayCourse()` method.
- **Engine Classes:** 
  - `StudentEngine`, `CourseEngine`, `EnrollmentEngine`: Act as controller classes to handle array operations, logic, and validations for their respective entities.
- **Main Class:** 
  - `MainMenu`: Central hub capturing user interaction via console inputs and seamlessly routing to engine classes.

### 2. Define Documentation Formatting
- **Standardized External Documentation:** Use Markdown (`.md`) format for clear, structured documentation (`README.md`, Reports). Utilize headings for organization and bullet points for ease of reading.
- **Inline Code Documentation:** Adopt JavaDoc conventions (`/** ... */`) for class definitions and complex methods. Provide single-line (`//`) descriptive comments to indicate logic sections cleanly.

### 3. Define Coding File Formatting
- **Indentation:** Adopt 4 spaces per indentation level. Avoid using raw tabs to prevent alignment issues across editors.
- **Encoding:** Encode all Java source files and text files in `UTF-8`.
- **Braces and Structure:** Use the K&R style where the opening curly brace `{` is placed on the same line as the statement (class, method, or loop declaration).

### 4. Define Naming Conventions – Dictionary
- **Classes & Interfaces:** Use `PascalCase` (e.g., `CourseEngine`, `MainMenu`).
- **Methods & Variables:** Use `camelCase` (e.g., `courseName`, `studentID`, `displayStudent()`).
- **Constants:** Use `UPPER_SNAKE_CASE` with the `final` keyword (e.g., `MAX_STUDENTS`).
- **Packages:** Use lowercased or exact project requirements (`SLMSWORKG10`).

### 5. Define Function and Methods Modularity
- **Single Responsibility Principle (SRP):** Each method should perform exactly one task to maximize readability and reusability. E.g., `displayCourse()` only handles printing, while search methods only handle looking up the array.
- **Separation of Concerns:** Distinct separation between pure Data classes (getters/setters without logic) and Controller/Engine classes (that perform operations). Avoid putting raw logic into the `MainMenu`.

### 6. Define Continuous Integration Rules
- **Version Control:** Maintain codebase using Git.
- **Branching Strategy:** Use a stable `main` branch. Features will be developed in separate localized branches and committed when tested.
- **Code Reviews:** Commits pushed to `main` must compile successfully without "Unresolved compilation problems" and pass manual console testing.
