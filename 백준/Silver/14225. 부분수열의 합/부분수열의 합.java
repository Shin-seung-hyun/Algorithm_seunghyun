import java.util.*;
import java.io.*;

// 수열의 부분합으로 나올 수 없는 가장 작은 수
/// 시간복잡도 O(2^20)
public class Main{

    static int N;   // 수열의 크기
    static int[] S; // 수열
    static boolean[] visit; // 부분합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visit = new boolean[2_000_000 + 1];
        S = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        // 부분 수열의 합으로 만들 수 있는 것 완전탐색
        DFS(1,0);

        // 부분 수열의 합으로 만들 수 없는 가장 작은 자연수 출력
        for(int i=1; i<=2_000_000; i++){
            if(visit[i]) continue;
            else{
                System.out.println(i);
                return;
            }
        }

    }

    static void DFS(int depth, int sum){

    // 종료 조건
        if(depth == N+1){
            visit[sum] = true;
            return;
        }

    // 반복 조건
        //S[]를 안 사용하는 경우
        DFS(depth+1, sum);

        // S[]를 사용하는 경우
        DFS(depth+1, sum + S[depth]);

    }

}