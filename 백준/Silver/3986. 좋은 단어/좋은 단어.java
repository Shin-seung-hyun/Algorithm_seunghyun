
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int cnt =0;
        for(int i=1; i<=N; i++){
            char[] charArr = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();

            for(char c : charArr){

                if(stack.isEmpty()) stack.push(c);
                else {
                    if( stack.peek() == c) stack.pop();
                    else stack.push(c);
                }
            }

            if(stack.isEmpty()) cnt++;
        }

        System.out.println(cnt);

    }//end main
}
