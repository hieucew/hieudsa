/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Studentt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Student {
    private final int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank() {
        if (score < 5.0) return "Fail";
        else if (score < 6.5) return "Medium";
        else if (score < 7.5) return "Good";
        else if (score < 9.0) return "Very Good";
        else return "Excellent";
    }

    public void printInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Score: " + score + ", Rank: " + getRank());
    }

    // Danh sách lưu trữ sinh viên và Scanner
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (scanner) {
            boolean running = true;
            while (running) {
                System.out.println("\nOptions:");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Sort Students by Score");
                System.out.println("6. Search Student by ID");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> editStudent();
                    case 3 -> deleteStudent();
                    case 4 -> displayAllStudents();
                    case 5 -> sortStudentsByScore();
                    case 6 -> searchStudentById();
                    case 7 -> {
                        running = false;
                        System.out.println("Exiting program.");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Score: ");
        double score = scanner.nextDouble();

        students.add(new Student(id, name, score));
        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter the ID of the student to edit: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter new Name: ");
            scanner.nextLine(); // Clear buffer
            String name = scanner.nextLine();
            System.out.print("Enter new Score: ");
            double score = scanner.nextDouble();

            student.setName(name);
            student.setScore(score);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter the ID of the student to delete: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void displayAllStudents() {
        System.out.println("\nStudent List:");
        for (Student student : students) {
            student.printInfo();
        }
    }

    private static void sortStudentsByScore() {
        students.sort(Comparator.comparingDouble(Student::getScore).reversed());
        System.out.println("Students sorted by score.");
        displayAllStudents();
    }

    private static void searchStudentById() {
        System.out.print("Enter the ID of the student to search: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.println("Student found:");
            student.printInfo();
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
