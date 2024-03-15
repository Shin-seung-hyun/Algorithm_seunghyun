import java.util.*;
import java.io.*;

// 완전탐색, 백트래킹
    //  K개 중 6개를, 중복 X, 순서 X 고르기 -> kC6
public class Main{
    static int K, M;
    static int[] arr;
    static int[] tmp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            //종료 조건
            if(K == 0) break;

            //입력 받기
            arr = new int[K +1];
            int idx =1;
            while(st.hasMoreTokens()) {
                arr[idx] = Integer.parseInt(st.nextToken());
                idx++;
            }

            tmp = new int [7];

            // 중복 X, 순서 X 고르기 -> kC6
            DFS(1, 1);

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void DFS(int depth, int at ) {

        // 종료 조건
        if( depth == 7){

            for(int i=1; i<=6; i++){
                sb.append(tmp[i] + " ");
            }
            sb.append("\n");

            return;
        }

        //반복조건
        for(int i = at; i<=K; i++){

            tmp[depth] = arr[i];
            DFS(depth+1, i +1);
        }

    }

}