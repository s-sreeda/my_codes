package array.foundation;

import java.util.Arrays;

/*Given an array arr[], the task is to find the subarray that has the maximum sum and return its sum.

Examples:

Input: arr[] = {2, 3, -8, 7, -1, 2, 3}
Output: 11
Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.

Input: arr[] = {-2, -4}
Output: -2
Explanation: The subarray {-2} has the largest sum -2.

Input: arr[] = {5, 4, 1, 7, 8}
Output: 25
Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.

[Expected Approach] Using Kadane's Algorithm - O(n) Time and O(1) Space*/

public class Arrays_MaximumSum_SubArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,-6,-2,-1};
		System.out.println("Array is: " + Arrays.toString(arr));
		
		int maxSum_subarr = findMaxSumSubArr(arr);
		System.out.println("Maximum array of sub array: " + maxSum_subarr);

	}
	
	static int findMaxSumSubArr(int[] arr) {
		int result = arr[0];
		int len = arr.length;
		
		for(int i=0;i<len;i++) {
			int currSum = 0;
			for(int j=i;j<len;j++) {
				currSum = currSum + arr[j];
				result = Math.max(result, currSum);
			}
		}
		return result;
	}

}
