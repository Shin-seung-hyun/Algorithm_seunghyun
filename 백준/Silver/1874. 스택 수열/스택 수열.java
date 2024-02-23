import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //Stack 선언
        Stack<Integer> stack = new Stack<>();

        int current = 1;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            while (current <= num) {
                stack.push(current);
                sb.append("+").append("\n");
                current++;
            }
            
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } 
            else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}