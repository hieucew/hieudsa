/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

public class newpackage {
    public static void main(String[] args) {
        // Khởi tạo mảng với 5 phần tử
        int[] arr = {10, 20, 30, 40, 50};

        // Tính tổng của tất cả các phần tử trong mảng
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // O(1) for each iteration
        }

        // In ra tổng các phần tử
        System.out.println("Sum of elements: " + sum);
    }
}

