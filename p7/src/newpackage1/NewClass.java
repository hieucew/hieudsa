/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage1;

public class NewClass {
    public static void main(String[] args) {
        // Mảng đã được sắp xếp
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        
        // Giá trị cần tìm
        int target = 40;

        // Gọi phương thức tìm kiếm nhị phân
        int result = binarySearch(arr, target);
        
        // In ra kết quả
        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    // Phương thức tìm kiếm nhị phân
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Tính chỉ số giữa
            
            // Kiểm tra nếu phần tử ở vị trí giữa là target
            if (arr[mid] == target) {
                return mid;
            }
            
            // Nếu target nhỏ hơn phần tử giữa, tìm kiếm trong nửa trái
            if (arr[mid] > target) {
                right = mid - 1;
            } 
            // Nếu target lớn hơn phần tử giữa, tìm kiếm trong nửa phải
            else {
                left = mid + 1;
            }
        }

        // Nếu không tìm thấy phần tử
        return -1;
    }
}
