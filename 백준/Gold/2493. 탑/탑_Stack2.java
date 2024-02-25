import java.util.*;
import java.io.*;

//Stack
public class Main {
    static class Top{
        int idx, height;

        public Top(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());   // 탑의 수

        Stack<Top> stack = new Stack<>();

        //초기값 저장
        stack.push(new Top(0,100_000_001));

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int h = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().height < h) stack.pop();

            if( stack.isEmpty()) sb.append("0 ");
            else sb.append(stack.peek().idx + " ");

            stack.push(new Top(i,h));
        }

        System.out.print(sb.toString());
    }
}