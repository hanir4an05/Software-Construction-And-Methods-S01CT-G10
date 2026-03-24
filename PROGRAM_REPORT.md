# Student and Course Management System Report

Date: March 24, 2026
Project Path: `c:\Users\Me\Desktop\SLMSWORKG10`

## 1. Program Overview
This Java console application provides two modules:
- Course Management
- Student Management

Users can add, search, edit, delete, and display records through menu-driven input.

## 2. Current Architecture
The intended (refactored) package-based structure is:
- `model/`
  - `Course.java`
  - `Student.java`
- `engine/`
  - `CourseEngine.java`
  - `StudentEngine.java`
- `ui/`
  - `Main.java`
  - `DefineStudent.java`

The project now uses only the package-based structure above.

## 3. Functional Assessment
### Course Module
Implemented features:
- Add course
- Search by course code
- Edit course fields
- Delete with confirmation
- Display all courses

Status: Working under packaged run path.

### Student Module
Implemented features:
- Add student
- Search by student ID
- Edit student fields
- Delete with confirmation
- Display all students
- Duplicate student ID prevention

Status: Working under packaged run path.

## 4. Build and Runtime Verification
### Successful path (recommended)
Command:
- `javac model\*.java engine\*.java ui\*.java`
- `java ui.Main`

Result:
- Compiles successfully
- Runs successfully
- Main menu displays and exits correctly

### Legacy path note
The previous default-package duplicate files were removed, so compile behavior is now consistent with the package-based design.

## 5. Hiccups / Risks
- Data storage uses fixed-size arrays (capacity limit set by constructor).
- No persistence layer (data resets every run).
- Input validation is basic (no strict email format or ID format checks).
- No automated tests currently included.

## 6. Overall Quality Verdict
The program is in a good working state when using the package-based entrypoint (`ui.Main`).

The build path is now straightforward and package-based.

## 7. Recommended Next Steps
Priority 1:
- Add duplicate course-code validation in `engine/CourseEngine.java`.
- Add stronger input validation (ID format, email format, empty fields).

Priority 2:
- Replace arrays with `ArrayList` for flexible capacity.
- Add file/database persistence.

Priority 3:
- Add unit tests for core engine methods.
