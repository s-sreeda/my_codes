import java.util.Arrays;

public class A09_MinimizeHeights {
	
	/*
	 * Given the heights of n towers and a positive integer k, increase or decrease the height of all towers by k (only once). After modifications, the task is
	 * to find the minimum difference between the heights of the tallest and the shortest tower.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = [12, 6, 4, 15, 17, 10], k = 6 Output: 8 Explanation: Update arr[] as [12 - 6, 6 + 6, 4 + 6, 15 - 6, 17 - 6, 10 - 6] = [6, 12, 10, 9, 11,
	 * 4]. Now, the minimum difference is 12 - 4 = 8.
	 * 
	 * Input: arr[] = [1, 5, 10, 15], k = 3 Output: 8 Explanation: Update arr[] as
	 * [1 + 3, 5 + 3, 10 - 3, 15 - 3] = [4, 8, 7, 12]. Now, the minimum difference
	 * is 8.
	 * 
	 * In any sorted array, we can see that for any index i, the smallest height depends on arr[0] and arr[i] and the tallest height depends on arr[i - 1] and 
	 * arr[n - 1], so instead of modifying the subarrays arr[0...i-1] and arr[i...n-1], we can simply modify arr[0], arr[i - 1], arr[i] and arr[n - 1] to get the smallest difference between heights.
	 */

	public static void main(String[] args) {
		
		int k =6;
		int[] arr = {12, 6, 4, 15, 17, 10};
		
		int result = getMinDifference(arr,k);
		System.out.println("Minimum difference is: " + result);
		

	}
	
	public static int getMinDifference(int[] arr, int k) {
		
		int len=arr.length;
		Arrays.sort(arr);
		
		int result = arr[len-1] - arr[0];
		
		for(int i=1;i<len;i++) {
			if(arr[i] - k < 0) 
				continue;
			
			int minimumHeight = Math.min(arr[0] + k, arr[i] - k);
			int maximumHeight = Math.max(arr[i-1] +k, arr[len-1]-k);
			
			result = Math.min(result, maximumHeight - minimumHeight);
		}
		return result;
		
	}

}
