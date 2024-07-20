import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        for( char c : br.readLine().toCharArray()){

            if(check){
                if( c == '>') check = false;
                sb.append(c);
                continue;
            }
            else {

                if (c == '<') {
                    check = true;
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }
                else if( c == ' ') {
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
                else{
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}