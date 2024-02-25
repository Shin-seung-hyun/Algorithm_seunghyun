import java.util.*;
import java.io.*;

// Stack
    // StringBuilder 사용하지 않으면 시간초과 발생
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr[i]) stack.pop();

            if (stack.empty())
                answer[i] = -1;
            else
                answer[i] = stack.peek();

            stack.push(arr[i]);
        }

        for (int i = 0; i < N; i++)
            sb.append(answer[i] + " ");

        System.out.println(sb.toString());
    }
}