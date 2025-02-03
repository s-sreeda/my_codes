package array.foundation;

import java.util.Arrays;

/*Given an array arr[] of size n, the task is to print the lexicographically next greater permutation of the given array. If there does not exist any greater permutation, then find the lexicographically smallest permutation of the given array.

examples:
1.Input: arr = [2, 4, 1, 7, 5, 0]

Output: arr = [2,4,5,0,1,7,] --1,7 and 5,0 gets swapped

2.Input: arr = [3, 2, 1]

Output: arr =[1,2,3] -- smallest permutation of the array

3.Input: arr = [1, 2, 3, 4, 5]

Output: arr = [1,2,3,5,4] -- 5 and 4 gets swapped

next, arr = [1,2,4,3,5] --

4.Input: arr = [1, 2, 3, 6, 4, 5]

Output: arr = [1,2,3,6,5,4] -- 4 and 5 gets swapped
*************************
Observation:
1.To get the next permutation we change the number in a position which is as right as possible.
2.The first number to be moved is the rightmost number smaller than its next.
3.The number to come in-place is the rightmost greater number on right side of the pivot.

Follow the steps below to implement the above observation:

1.Iterate over the given array from end and find the first index (pivot) which doesn't follow property of non-increasing suffix, (i.e,  arr[i] < arr[i + 1]).
2.If pivot index does not exist, then the given sequence in the array is the largest as possible. So, reverse the complete array. For example, for [3, 2, 1], the output would be [1, 2, 3]
3.Otherwise, Iterate the array from the end and find for the successor (rightmost greater element) of pivot in suffix.
4.Swap the pivot and successor
5.Minimize the suffix part by reversing the array from pivot + 1 till n.
*/

public class Arrays_NextPermutation {
	
	public static void nextPermutation(int[] arr) {
		int len = arr.length;
		
		//Find the pivot index
		int pivot=-1;
		for(int i=len-2;i>=0;i--) {
			if(arr[i]<arr[i+1]) {
				pivot = i;
				break;
			}
		}
		
		//If pivot does not exist, reverse the whole array
		if(pivot==-1) {
			reverse(arr,0,len-1);
			return;
		}
		
		//Find the element from the right which is greater than the pivot
		for(int i=len-1;i>pivot;i--) {
			if(arr[i]>arr[pivot]) {
				swap(arr,i,pivot);
				break;
			}
		}
		
		//Reverse the elements from pivot+1 to the end
		reverse(arr,pivot+1,len-1);
		
	}

	//Helper method to reverse the array
	private static void reverse(int[]arr,int start, int end){
		while(start<end) {
			swap(arr, start++, end--);
		}
	}
	
	//Helper method to swap array elements
	private static void swap(int[] arr,int i,int j ) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		int[] arr= {3,2,1};
		System.out.println("Original array is:\n" + Arrays.toString(arr));
		
		nextPermutation(arr);
		
		System.out.println("Next permutation of the array is:\n" + Arrays.toString(arr));

	}

}
