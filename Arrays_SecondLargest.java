  public class SecondLargest {
	
	public static void main(String[] args) {
		
		int[] myArray = {10,10,20,30,40,20,15};
		int secondLargest = getSecondLargest(myArray);
		System.out.println("Second largest number in the array is: " + secondLargest);
		
	}
	

    public static int getSecondLargest(int[] arr) {
      
        int len = arr.length;
        int largest =-1, secondLargest=-1;
        
        for(int i=0;i<len;i++){
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }else if(arr[i]<largest && arr[i]>secondLargest){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }
}

/*
 * Time Complexity: O(n), as we are traversing the array only once. Auxiliary
 * space: O(1)
 */
