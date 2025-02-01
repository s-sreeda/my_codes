package array.foundation;

import java.util.Arrays;

/*Using reversal algorithm:
The idea is based on the observation that if we left rotate the array by d positions, the last (n - d) elements will be at the front and the first d elements will be at the end.

Reverse the subarray containing the first d elements of the array.
Reverse the subarray containing the last (n - d) elements of the array.
Finally, reverse all the elements of the array.
Time Complexity: O(n)
Auxiliary Space: O(1) */


public class Arrays_LeftRotate {
    
    // Function to rotate an array by d elements to the left
static void rotateArr(int[] arr, int d) {
    int n = arr.length;

    // Handle the case where d > size of array
    d %= n;

    // Reverse the first d elements
    reverse(arr, 0, d - 1);

    // Reverse the remaining n-d elements
    reverse(arr, d, n - 1);

    // Reverse the entire array
    reverse(arr, 0, n - 1);
}

// Function to reverse a portion of the array
static void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6 };
    int d = 2;
    
    System.out.println("Original array:\n" + Arrays.toString(arr));

    rotateArr(arr, d);

    System.out.println("\nLeft shifted array by "+ d + " times:");
    System.out.print(Arrays.toString(arr));
}
}
