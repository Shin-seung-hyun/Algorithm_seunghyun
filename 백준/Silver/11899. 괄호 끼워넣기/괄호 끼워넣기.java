import java.io.*;
import java.util.*;

// Stack
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character>stack = new Stack<>();

        for(int i=0; i< s.length(); i++){

            if( stack.isEmpty()) stack.push(s.charAt(i));
            else{

                if(stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                }
                else stack.push(s.charAt(i));
            }
        }
        
        System.out.println(stack.size());

    }

}