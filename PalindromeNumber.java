import java.util.Scanner;
class Palindrome {
    public static void main(String[] args) {
        		int n,i, sum=0,temp,rem;
		System.out.println("Enter any number: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		temp=n;
		while(n>0) {
			rem=n%10;
			sum = sum+rem;
			n=n/10;
		}
		if(n==temp) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not palindrome");
		}
	}

    }
