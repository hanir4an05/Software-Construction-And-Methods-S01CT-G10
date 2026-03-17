package SLMSWORKG10;

public class ViewAllFunction {
    private Student[] students;
    private int studentCount;

    // Method to display all entered student attributes
    // This acts as the 'logic' behind the View All button/option
    public void displayAllStudents() {
        System.out.println("=".repeat(50));
        System.out.println("            ALL REGISTERED STUDENTS            ");
        System.out.println("=".repeat(50));
        
        if (studentCount == 0) {
            System.out.println("        No student records found.        ");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.print("[" + (i + 1) + "] ");
                students[i].displayStudent();
            }
            System.out.println("\n" + "-".repeat(45));
            System.out.println("Total Registered Students: " + studentCount);
        }
    }
}
