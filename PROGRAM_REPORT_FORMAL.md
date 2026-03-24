# Student Learning Management System (SLMS)
## Formal Project Report

Date: March 24, 2026  
Project Directory: `c:\Users\Me\Desktop\SLMSWORKG10`

## Abstract
This project is a Java console-based Student Learning Management System (SLMS) that provides two main modules: Course Management and Student Management. The system allows users to perform core CRUD operations (Create, Read, Update, Delete) through a menu-driven interface. The implementation uses object-oriented design with separate model, engine, and UI layers. The current version successfully compiles and runs through the package-based entry point and demonstrates stable behavior for standard user flows.

## 1. Introduction
Managing student and course information is a common requirement in academic systems. This project was developed to simulate a lightweight management platform suitable for learning object-oriented programming and basic software design principles.

The system focuses on:
- Organized data handling for courses and students
- Clear user interaction through command-line menus
- Separation of concerns using structured Java packages

## 2. Objectives
The primary objectives of the program are:
- Build a menu-driven Java application for academic data management
- Implement CRUD operations for both courses and students
- Apply OOP concepts such as classes, encapsulation, and modular design
- Improve maintainability through package-based project organization

## 3. System Design and Architecture
The refactored architecture follows a layered structure:

- `model` package:
  - `Course.java`
  - `Student.java`
- `engine` package:
  - `CourseEngine.java`
  - `StudentEngine.java`
- `ui` package:
  - `Main.java`
  - `DefineStudent.java`

### Design Notes
- The `model` layer contains data entities.
- The `engine` layer contains business logic and array-based storage handling.
- The `ui` layer manages input/output and menu navigation.

## 4. Functional Modules
### 4.1 Course Management Module
Implemented features:
- Add new course
- Search course by course code
- Edit existing course details
- Delete course with confirmation
- Display all courses

### 4.2 Student Management Module
Implemented features:
- Add new student
- Search student by student ID
- Edit existing student details
- Delete student with confirmation
- Display all students
- Duplicate student-ID validation (prevents repeated IDs)

## 5. Methodology
The development process followed these steps:
- Initial implementation of course and student models
- Creation of engine classes for CRUD logic
- Integration into a single menu-driven `Main` program
- Refactor into package-based structure (`model`, `engine`, `ui`)
- Runtime verification through scripted command-line test scenarios

## 6. Implementation and Tools
- Language: Java
- Runtime: Command-line Java execution
- Data Storage: In-memory arrays
- Interaction: `Scanner`-based console input

No external libraries were required.

## 7. Testing and Results
### 7.1 Build Verification
Recommended compile command:
- `javac model\*.java engine\*.java ui\*.java`

Result:
- Successful compilation

### 7.2 Runtime Verification
Recommended run command:
- `java ui.Main`

Result:
- Application starts correctly
- Main menu and module navigation function correctly
- Add/search/edit/delete/display flows execute as expected
- Duplicate student ID entry is correctly blocked

### 7.3 Important Observation
The project now uses a clean package-only structure (`model`, `engine`, `ui`) with no duplicate root-level Java source files. This removes the previous compile ambiguity and makes build behavior consistent across environments.

## 8. Limitations
Current limitations include:
- Data is not persistent (resets when program exits)
- Fixed-size arrays limit maximum records
- Basic input validation only
- No automated unit tests

## 9. Conclusion
The SLMS program meets its core functional goals and runs reliably in its package-based structure. The project demonstrates solid use of Java OOP fundamentals and modular code organization. The implemented validation for duplicate student IDs improves data integrity, and the overall application is suitable as a coursework-level management system prototype.

## 10. Future Enhancements
Recommended improvements:
- Add duplicate course-code validation for consistency
- Replace arrays with `ArrayList` for dynamic growth
- Add file or database persistence
- Introduce unit tests for engine methods
- Improve field-level validation (email format, required fields, ID patterns)

## 11. Current Project Status Update
As of March 24, 2026, the project cleanup has been completed:
- Duplicate root-level Java files were removed.
- Package-based architecture is the single source of truth.
- No compile errors are currently reported in the workspace.
- Program execution should use `ui.Main` as the entry point.
