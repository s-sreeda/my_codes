import java.util.Arrays;

public class MoveZeroesToEnd {

	public static void main(String[] args) {
		int[] myArray = {1,2,4,0,0,5,7,0,0,11,0,12,0};
		pushZeroesToEnd(myArray);
		System.out.println("Updated array is: "+ Arrays.toString(myArray));
	}
	
	public static void pushZeroesToEnd(int[] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				int temp=arr[i];
				arr[i]=arr[count];
				arr[count]=temp;
				count++;
			}
			
		}
	}

}

/*
 * Time Complexity: O(n), as we are traversing the array only once. 
 * Auxiliary Space: O(1)
 */
