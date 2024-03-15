import java.io.*;
import java.util.*;

//완전탐색
    // N개 중 M 개를, 중복 X, 순서 X 고르기 -> nCm
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

        DFS(1,1);

        System.out.print(sb.toString());
    }

    static void DFS(int depth ,int at ){

        //종료 조건
        if( depth == M+1){
            for(int i=1; i<=M; i++)
                sb.append(tmp[i] + " ");
            sb.append("\n");

            return;
        }

        // 반복 조건
        for(int i= at; i<=N; i++){

            tmp[depth] = arr[i];
            DFS(depth +1, i+1);
        }
    }


}