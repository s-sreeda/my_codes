package array.foundation;

import java.util.ArrayList;
import java.util.List;

/*Using Boyer-Moore's voting algorithm: O(n) Time and O(1) Space
 * The idea is based on the observation that there can be at most two majority elements, which appear more than n/3 times. 
 * so we can use Boyer-Moore’s Voting algorithm. As we iterate the array, We identify potential majority elements by keeping track of two candidates
 *  and their respective counts.

 *  Steps:

Initialize two variables ele1 = -1 and ele2 = -1, for candidates and two variables cnt1 = 0 and cnt2 = 0, for counting.
In each iteration,
If an element is equal to any candidate, update that candidate's count.
If count of a candidate reaches zero then replace that candidate with current element.
If neither candidate matches and both counts are non zero, decrement the counts.
After this, in second pass we check if the chosen candidates appear more than n/3 times in the array. If they do then include them in result array.*/

public class Arrays_MajorityElement {
	
	//Function to find majority element in an array
	 static List<Integer> findMajority(int[] arr) {
		
		int len = arr.length;
		
		//Initialize two candidates and their counts
		int element1=-1, element2=-1;
		int count1=0, count2=0;
		
		for(int element:arr) {
			
			//Increment count for candidate1
			if(element1==element) {
				count1++;
			}
			//Increment count for candidate2
			else if(element2==element) {
				count2++;
			}
			//New candidate 1 if count is zero
			else if(count1==0) {
				element1=element;
				count1++;
			}
			//New candidate 2 if count is zero
			else if(count2==0) {
				element2=element;
				count2++;
			}
			//Decrease count if neither candidate
			else {
				count1--;
				count2--;
			}
			
		}
		
		List<Integer> result = new ArrayList<>();
		count1=0;
		count2=0;
		
		//Count the occurences of candidates
		for(int element:arr) {
			if(element1==element)count1++;
			if(element2==element)count2++;
		}
		
		//Add to result if they are majority elements
		if(count1>len/3)result.add(element1);
		if(count2>len/3 && element1!=element2)result.add(element2);
		
		if(result.size()==2 && result.get(0)>result.get(1)) {
			int temp=result.get(0);
			result.set(0, result.get(1));
			result.set(1, temp);
		}
		return result;
		
	}

	public static void main(String[] args) {
		
		int[] arr= {2,2,3,1,3,2,1,1};
		List<Integer> result = findMajority(arr);
		for(int element:result) {
			System.out.println(element + " ");
		}
	}

}
