
import java.util.*;
import java.io.*;


//Stack
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){

            Stack<Character> stack = new Stack<>();

            boolean isVPS = true;
            for(char c : br.readLine().toCharArray()){

                if(c == '(') stack.push(c);
                else{
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else isVPS = false;
                }
            }

            if(!stack.isEmpty()) isVPS = false;

            //출력
            if( isVPS) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb.toString());

    }//end main
}
