/*Given an integer num, return the number of steps to reduce it to zero.
In one step, if the current number is even, we  have to divide by 2, otherwise, we need to subtract 1 from it.*/

public class StepsToZero{

  public static int  numberOfSteps(int n){
    int steps = 0;
    while(num >0){
      if(num%2 == 0){
        num/=2;
      }else{
        num--;
      }
      steps++;
    }
    return steps;
  }

  public static void main(String[] args){
    int result = numberOfSteps(30);
    System.out.println("Number of steps to reduce 30 to 0 is: "+ result);
  }
}
