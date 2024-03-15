import java.io.*;
import java.util.*;

//완전탐색
    // N개 중 M 개를, 중복 X, 순서 O 나열하기 -> nPm
public class Main {

    static int[] arr, tmp;
    static boolean[] visit;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, 1, N+1);

        tmp = new int[M+1];
        visit = new boolean[N+1];

        DFS(1);

        System.out.print(sb.toString());
    }

    static void DFS(int depth){

        //종료 조건
        if( depth == M+1){
            for(int i=1; i<=M; i++)
                sb.append(tmp[i] + " ");
            sb.append("\n");

            return;
        }

        // 반복 조건
        int beforeNum = 0;  // 중복 수열인지 확인
        for(int i= 1; i<=N; i++){


            // 이전 수열의 마지막 항과 새로운 수열의 마지막이 같으면 중복된 것!
            if( beforeNum == arr[i]) continue;
            if( visit[i]) continue;

            visit[i] = true;

            tmp[depth] = arr[i];
            beforeNum = tmp[depth];
            DFS(depth +1);

            visit[i] = false;
        }
    }


}