# Student Learning Management System (SLMS)

![Java](https://img.shields.io/badge/Language-Java-orange.svg)
![Status](https://img.shields.io/badge/Status-Active-brightgreen.svg)
![Version](https://img.shields.io/badge/Version-1.0-blue.svg)

The **Student Learning Management System (SLMS)** is a robust, terminal-based Java application designed to simplify academic administration for students, teachers, and administrators. It provides a centralized, interactive environment for managing courses, tracking students, and handling enrollments.

This repository aligns with software construction best practices defined in labs, emphasizing clean code, modular architecture, and easy navigability.

---

## 🚀 Features

### Course Management System
1. **Add Course**: Enter complete course details (Name, Code, Credits, Summary, MS Teams Link).
2. **Search Course**: Quickly find a course by entering its unique Course Code.
3. **Edit Course**: Update course details dynamically over the CLI.
4. **Delete Course**: Remove courses via the Course Code.
5. **Display All**: View all actively registered courses in an organized list.

### Student Management System
1. **Add Student**: Register students with IDs, names, emails, and phone numbers.
2. **Search Student**: Locate students instantly via Student ID.
3. **Edit Student**: Safely modify student profiles using their Student ID.
4. **Delete Student**: Securely delete student records.
5. **Display All**: Show a summarized layout of all registered students.

### Enrollment Management System
1. **Enrollment**: Map and register students dynamically to their courses.
2. **Find Courses by Student ID**: View what courses a specific student is taking.
3. **Find Students by Course ID**: List all students enrolled in a targeted course.

---

## 📂 Project Structure (Modules and Classes)

* The system is carefully modularized strictly following the Single Responsibility Principle.

```text
Student-Learning-Management-System/
├── SRC CODE/
│   └── SLMSWORKG10/
│       ├── MainMenu.java           # Central user interface handling inputs/navigation
│       ├── Course.java             # Data class for course attributes
│       ├── CourseEngine.java       # Operations logic for Course array
│       ├── Student.java            # Data class for student attributes
│       ├── StudentEngine.java      # Operations logic for Student array
│       ├── EnrollmentEngine.java   # Relationship logic tying Students & Courses
│       └── CacheAPI.java           # Handles data caching mechanisms
├── README.md                       # Main project documentation
└── Lab_1_and_2_Report.md           # Software Design plan & rules
```

---

## 🛠️ Software Construction Standards
As established during our initial structural planning sessions:
- **Coding Standards:** K&R Brace style, exactly 4-space indentation, clear variable naming (`camelCase` for fields/methods, `PascalCase` for classes).
- **Modularity:** Pure separation of Data representation and CLI management classes (`Course` vs `CourseEngine`).

---

## 🤝 Contributing

Contributions are heavily encouraged to further improve SLMS methodologies.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/NewSystemModule`)
3. Commit changes (`git commit -m "Added modern X feature"`)
4. Push to the branch (`git push origin feature/NewSystemModule`)
5. Open a carefully detailed Pull Request

---

## 📄 License & Team

This project is authored by and maintained under **G10**. 

**Team Members:**
1. HARIZ IRFAN BIN MOHD SHAMIR (Leader)
2. MOHAMMAD DANISH DANIAL BIN MOHD ROSLI
3. MUHAMAD IRFAN BIN ZUHAIMIN
4. KESHAV KALAIVANI SURESH
