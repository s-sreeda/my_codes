import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * 'isBalanced' function.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    
    Stack<Character> stack = new Stack<>();
    
    for(char ch:s.toCharArray()){
         // If the character is an opening bracket, push it onto the stack
        if(ch=='{' || ch=='[' || ch=='('){
            stack.push(ch);
        }
        // If the character is a closing bracket, check for a matching opening bracket
        else if(ch=='}' || ch==']' || ch==')'){
             // If stack is empty or top of the stack does not match, return "NO"
            if(stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                return "NO";
            }
        }
    }
    // If the stack is empty, all opening brackets had matching closing brackets
    return stack.isEmpty() ? "YES" : "NO";
    }
    
        private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '{' && close == '}') || 
               (open == '[' && close == ']');
    }
    
}



public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
