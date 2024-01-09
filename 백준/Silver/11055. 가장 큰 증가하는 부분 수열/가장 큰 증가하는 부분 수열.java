import java.util.*;
import java.io.*;

class Main{
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dy = new int[N + 1];
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 가짜식 dy[i] : i가 가장 큰 값일 때, 증가하는 부분 수열의 최대값

        //초기값
        dy[1] = arr[1];

        //점화식
        for(int i=2; i<=N; i++) {
            for (int j=1; j<i; j++) {

                // 증가하는 수열임으로 자신보다 크거나 같은 값은 빼기
                if (arr[i] <= arr[j]) continue;
                
                // 이전 dy 중 가장 큰 값 고르기
                dy[i] = Math.max(dy[j], dy[i]);
            }
            
            // 이전 dy 중 가장 큰 값 + arr[i]
            dy[i] += arr[i];
        }

        //정답
        int answer = 0;
        for(int val : dy) answer = Math.max(answer ,val);

        System.out.println(answer);
    }
}