package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamFun {

	public static void main(String[] args) {
		
		//Print elements of a list
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		myList.add(8);
		myList.add(2);
		myList.add(3);
		myList.add(13);
		
		System.out.println("My List is" + myList);
		//Print the list
		System.out.println("\nPrint the list elements using forEach");
		myList.forEach(element -> System.out.println(element));
		
		//Even numbers
		
		List<Integer> myList1 = myList.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("\nmyList1 " + myList1);
		myList1.forEach(element -> System.out.println(element));
		
		//Sum of even numbers
		
		int evenSum = myList.stream().filter(i->i%2==0).mapToInt(Integer::intValue).sum();
		System.out.println("\nevenSum " + evenSum);
		
		//Number of occurence of a character
		
		String s = "Sreeda";
		long myD = s.chars().filter(a->a=='e').count();
		System.out.println("\nNo of occurence of 'e' is: " + myD);
		
		//Filter even numbers from the list
		
		List<Integer> evenNumbers = myList.stream().filter(n->n%2 == 0).collect(Collectors.toList());
		System.out.println("\nEven numbers from the list: " + evenNumbers);
		evenNumbers.forEach(i->System.out.println(i));
		
		//Maximum value in the list
		Optional<Integer> max = myList.stream().max(Integer::compare);
		
		//or
		
		int max1 = myList.stream().max(Integer::compare).orElse(0);
		System.out.println("\nMaximum value in the list: " + max + max1);
		
		//Convert a list of strings to uppercase
		List<String> names = Arrays.asList("apple","banana","orange");
		List<String> upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("\nUpper case names: " + upperCaseNames);
		
		
		
		
		

	}

}
