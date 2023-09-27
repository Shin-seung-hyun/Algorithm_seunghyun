import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 바구니 수
        int M = Integer.parseInt(st.nextToken());   // 공을 넣는 횟수

        int [] arr = new int [N+1];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            for(int j= I; j<=J; j++){
                arr[j] = K;
            }
        }

        //출력
        for(int i=1; i<=N; i++) System.out.print(arr[i] + " ");

    }

}