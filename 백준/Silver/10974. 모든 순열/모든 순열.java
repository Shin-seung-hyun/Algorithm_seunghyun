import java.util.*;
import java.io.*;

// 완전탐색
class Main{
    static int N;   // N!
    static boolean[] visit; // 숫자의 방문을 확인
    static int[] arr;   // 수열을 담을 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visit = new boolean[N+1];
        arr = new int[N+1];

        DFS(0);

        System.out.println(sb.toString());
    }

    static void DFS(int depth){

        // 종료 조건
        if(depth == N){
            for(int val : arr){
                
                // arr 가 0 부터 시작하여 0을 제외하고 출력
                if( val == 0) continue;
                sb.append(val + " ");
            }
            sb.append("\n");
        }

        // 반복조건
        for(int i =1; i<=N; i++){
            if(visit[i]) continue;

            visit[i] = true;
            arr[depth +1] = i;
            DFS(depth+1);

            visit[i] = false;
        }

    }


}