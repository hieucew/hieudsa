/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
class Studentt {
    private final int id;
    private String name;
    private double score;

    public Studentt(int id, String name, double score) {
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
}

// Class quản lý hàng đợi
class StudentQueue {
    private final Queue<Studentt> queue;

    public StudentQueue() {
        queue = new LinkedList<>();
    }

    public void addStudent(Studentt student) {
        queue.offer(student);
    }

    public Studentt findStudentById(int id) {
        for (Studentt student : queue) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        queue.removeIf(student -> student.getId() == id);
    }

    public void displayAllStudents() {
        for (Studentt student : queue) {
            student.printInfo();
        }
    }
}

// Lớp chính chứa phương thức main
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentQueue studentQueue = new StudentQueue();

    public static void main(String[] args) {
        try (scanner) {
            boolean running = true;
            while (running) {
                System.out.println("\nOptions:");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Search Student by ID");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> editStudent();
                    case 3 -> deleteStudent();
                    case 4 -> studentQueue.displayAllStudents();
                    case 5 -> searchStudentById();
                    case 6 -> {
                        running = false;
                        System.out.println("Exiting program.");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt(); // Nhập ID (kiểu int)
            scanner.nextLine(); // Clear buffer

            System.out.print("Enter Name: ");
            String name = scanner.nextLine(); // Nhập tên (kiểu String)

            System.out.print("Enter Score: ");
            double score = scanner.nextDouble(); // Nhập điểm (kiểu double)

            // Thêm sinh viên vào hàng đợi
            studentQueue.addStudent(new Studentt(id, name, score));
            System.out.println("Student added successfully.");
        } catch (InputMismatchException e) {
            // Xử lý khi người dùng nhập sai kiểu dữ liệu
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); // Clear scanner buffer để người dùng có thể nhập lại
        }
    }

    private static void editStudent() {
        try {
            System.out.print("Enter the ID of the student to edit: ");
            int id = scanner.nextInt(); // Nhập ID sinh viên
            Studentt student = studentQueue.findStudentById(id); // Tìm sinh viên theo ID

            if (student != null) {
                System.out.print("Enter new Name: ");
                scanner.nextLine(); // Clear buffer
                String name = scanner.nextLine(); // Nhập tên mới

                System.out.print("Enter new Score: ");
                double score = scanner.nextDouble(); // Nhập điểm mới

                // Cập nhật tên và điểm cho sinh viên
                student.setName(name);
                student.setScore(score);
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (InputMismatchException e) {
            // Xử lý khi người dùng nhập sai kiểu dữ liệu (ví dụ nhập chữ thay vì số)
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); // Clear scanner buffer để người dùng có thể nhập lại
        } catch (Exception e) {
            // Xử lý bất kỳ lỗi nào khác không xác định
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter the ID of the student to delete: ");
        int id = scanner.nextInt();
        studentQueue.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }

    private static void searchStudentById() {
        try {
            System.out.print("Enter the ID of the student to search: ");
            int id = scanner.nextInt(); // Nhập ID sinh viên

            // Tìm sinh viên theo ID trong hàng đợi
            Studentt student = studentQueue.findStudentById(id);

            if (student != null) {
                System.out.println("Student found:");
                student.printInfo(); // In thông tin sinh viên nếu tìm thấy
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }

        } catch (InputMismatchException e) {
            // Xử lý lỗi nếu người dùng nhập sai kiểu dữ liệu (ví dụ nhập chữ thay vì số)
            System.out.println("Invalid input. Please enter a valid integer for the student ID.");
            scanner.nextLine(); // Dọn dẹp buffer của scanner để người dùng có thể nhập lại
        }
    }
}
