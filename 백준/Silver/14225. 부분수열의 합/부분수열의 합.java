import java.util.*;
import java.io.*;

// 수열의 부분합으로 나올 수 없는 가장 작은 수
public class Main {

    static int N;
    static int[] S;
    static int[] arr = new int [20+1];
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visit = new boolean[2_000_000 + 1];
        S = new int [N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            S[i] = Integer.parseInt(st.nextToken());
            visit[S[i]] = true;
        }

        Arrays.sort(S,1,N+1);

        for(int i=2; i<=N; i++){
            DFS(1,1, i);
            Arrays.fill(arr,0);
        }

        for(int i=1; i<=2_000_000; i++){
            if(visit[i]) continue;
            else{
                System.out.println(i);
                return;
            }
        }
    }

    static void DFS(int at, int depth, int M){

        //종료 조건
        if( depth == M+1){
            int sum =0;
            for(int i = 1; i<=20; i++){
                sum += arr[i];
            }

            visit[sum] = true;
            return;
        }

        // 반복 조건
        for(int i = at; i<=N; i++){
            arr[depth] = S[i];
            DFS(i+1,depth+1, M);
        }

    }


}