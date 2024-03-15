import java.util.*;
import java.io.*;

// 완전탐색, 백트래킹
    //  N 개 중 M개를, 중복O, 순서 X 고르기 -> nCm
public class Main {
    static int N, M;
    static int[] arr;
    static int[] tmp;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[10];
        tmp = new int[10];
        check = new boolean[10002];

        // intput : 9 7 9 1
        // arr    : 1 7 9
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for(int i=1; i<=N; i++){
            int value = Integer.parseInt(st.nextToken());

            // 입력 시, 중복 숫자 제거
            if( check[value]) continue;
            arr[idx] = value;
            check[arr[idx]] = true;
            idx++;
        }

        N = idx;

        Arrays.sort(arr, 0, N);

        DFS(0,0);

        System.out.print(sb.toString());
    }

    static void DFS(int depth, int at ) {

        //종료 조건
        if (depth == M) {

            for (int i = 0; i < M; i++)
                sb.append( tmp[i] + " " );
            sb.append("\n");

            return;
        }

        for (int i = at; i < N; i++) {
            tmp[depth] = arr[i];
            DFS(depth + 1, i);
        }
    }

}