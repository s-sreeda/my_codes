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
     * 'getMax' function.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    
    List<Integer> result = new ArrayList<>();
    
    for(String operation:operations){
        String[] op = operation.split(" ");
        
        switch(op[0]){
            case "1":
            int x=Integer.parseInt(op[1]);
            mainStack.push(x);
            
            if(maxStack.isEmpty() || x>maxStack.peek()){
                maxStack.push(x);
            }else{
                maxStack.push(maxStack.peek());
            }
            break;
            
            case "2":
            if(!mainStack.isEmpty()){
                mainStack.pop();
                maxStack.pop();
            }
            break;
            
            case "3":
            if(!maxStack.isEmpty()){
                result.add(maxStack.peek());
            }
            break;
        }
    }

    return result;
    
    }

}

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
