import java.util.*;
import java.io.*;

//Stack
    // StringBuilder 사용하지 않으면 시간초과 발생
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>(); //{idx, num}
        int answer[] = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){

            int num = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()[1] <num){
                answer[stack.peek()[0]] = num;
                stack.pop();
            }

            stack.push( new int[]{i,num});
        }

        //출력
        for(int i=1; i<=N; i++){
            if(answer[i] == 0) sb.append( "-1 ");
            else sb.append(answer[i] + " ");
        }

        System.out.println(sb.toString());
    }
}