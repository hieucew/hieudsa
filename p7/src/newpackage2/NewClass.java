/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage2;

public class NewClass {
    public static void main(String[] args) {
        // Khởi tạo mảng chưa sắp xếp
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(arr);

        // Gọi phương thức sắp xếp Bubble Sort
        bubbleSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    // Phương thức thực hiện sắp xếp Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Lặp qua tất cả các phần tử trong mảng
        for (int i = 0; i < n - 1; i++) {
            // Lặp qua mảng từ 0 đến n-i-1, phần tử cuối đã được sắp xếp
            for (int j = 0; j < n - i - 1; j++) {
                // Nếu phần tử hiện tại lớn hơn phần tử tiếp theo, hoán đổi chúng
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi phần tử arr[j] và arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Phương thức in mảng
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

