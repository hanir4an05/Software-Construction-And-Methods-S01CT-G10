package engine;

import java.util.Scanner;
import model.Student;

public class StudentEngine {

	private Student[] students;
	private int studentCount;

	public StudentEngine(int maxStudents) {
		students = new Student[maxStudents];
		studentCount = 0;
	}

	public void addStudent(Student student) {
		if (student == null) {
			System.out.println("Invalid student data.");
			return;
		}

		if (findStudentIndexById(student.getStudentId()) != -1) {
			System.out.println("Student ID already exists.");
			return;
		}

		if (studentCount >= students.length) {
			System.out.println("Student list is full.");
			return;
		}

		students[studentCount] = student;
		studentCount++;
		System.out.println("Student added successfully.");
	}

	private int findStudentIndexById(String studentId) {
		for (int i = 0; i < studentCount; i++) {
			if (students[i].getStudentId().equalsIgnoreCase(studentId)) {
				return i;
			}
		}
		return -1;
	}

	public void searchStudentUI(Scanner scanner) {
		System.out.print("Enter Student ID to search: ");
		String studentId = scanner.nextLine();

		int index = findStudentIndexById(studentId);
		if (index == -1) {
			System.out.println("Student not found.");
			return;
		}

		System.out.println("\nStudent Found:");
		students[index].displayStudent();
	}

	public void editStudent(Scanner scanner) {
		System.out.print("Enter Student ID to edit: ");
		String studentId = scanner.nextLine();

		int index = findStudentIndexById(studentId);
		if (index == -1) {
			System.out.println("Student not found.");
			return;
		}

		Student student = students[index];

		System.out.println("\nCurrent Student Info:");
		student.displayStudent();
		System.out.println("\nPress ENTER to keep current value.");

		System.out.print("New Name (" + student.getStudentName() + "): ");
		String newName = scanner.nextLine();
		if (!newName.isEmpty()) {
			student.setStudentName(newName);
		}

		System.out.print("New Program (" + student.getProgram() + "): ");
		String newProgram = scanner.nextLine();
		if (!newProgram.isEmpty()) {
			student.setProgram(newProgram);
		}

		System.out.print("New Email (" + student.getEmail() + "): ");
		String newEmail = scanner.nextLine();
		if (!newEmail.isEmpty()) {
			student.setEmail(newEmail);
		}

		System.out.println("Student updated successfully.");
	}

	public void deleteStudent(Scanner scanner) {
		System.out.print("Enter Student ID to delete: ");
		String studentId = scanner.nextLine();

		int index = findStudentIndexById(studentId);
		if (index == -1) {
			System.out.println("Student not found.");
			return;
		}

		System.out.println("\nStudent Found:");
		students[index].displayStudent();
		System.out.print("Confirm delete (Y/N): ");
		String confirm = scanner.nextLine();

		if (!confirm.equalsIgnoreCase("Y")) {
			System.out.println("Delete cancelled.");
			return;
		}

		for (int i = index; i < studentCount - 1; i++) {
			students[i] = students[i + 1];
		}
		students[studentCount - 1] = null;
		studentCount--;

		System.out.println("Student deleted successfully.");
	}

	public void displayAllStudents() {
		if (studentCount == 0) {
			System.out.println("No students available.");
			return;
		}

		System.out.println("\n=== STUDENT LIST ===");
		for (int i = 0; i < studentCount; i++) {
			System.out.println("\nStudent " + (i + 1));
			System.out.println("-----------------");
			students[i].displayStudent();
		}
	}
}
