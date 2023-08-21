import java.io.*;
import java.util.*;

// Stack
    //BOJ #1863번 스카이라인 쉬운거
public class Main {
    static int N;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    // 건물 수


        // 초기화
        int [] cnt = new int [N];   // 보이는 건물의 수
        int [] near = new int [N];
        Arrays.fill(near, - 100_000);

        //입력
        arr = new int [N];  // 건물 높이 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        //front
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {

            // stack에 있는 건물 중, 자신보다 작거나 같으면 보이지 않음 -> pop()
            // 자신보다 크거나 stack이 비어있을 때까지 해당 과정 반복
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }

            cnt[i] = stack.size();  // 보이는 건물의 수
            if(cnt[i] >0 ) near[i] = stack.peek();
            stack.push(i);
        }

        //back
        stack = new Stack<>();
        for(int i =N-1; i>=0; i--){

            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            int s = stack.size();
            cnt[i] += s;
            if( s > 0 && stack.peek() -i < i- near[i]) near[i] = stack.peek();
            stack.push(i);
        }


        //출력
        for(int i=0; i<N; i++){
            sb.append(cnt[i]);
            if( cnt[i] > 0 ) sb.append(" ").append(near[i]+1);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

}