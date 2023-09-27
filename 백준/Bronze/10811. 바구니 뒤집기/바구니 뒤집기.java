import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 바구니 수
        int M = Integer.parseInt(st.nextToken());   // 역순하는 횟수

        //입력
        int []arr = new int[N+1];
        for(int i=1; i<=N; i++) arr[i] = i;

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if( e-s <=0) continue;

            int tmp =0;
            for(int j = 0; j<( e - s +1 )/2; j++){
                tmp = arr[s+j];
                arr[s+j] = arr[e-j];
                arr[e-j] = tmp;
            }
        }

        //출력
        for(int i=1; i<=N; i++) System.out.print(arr[i] + " ");

    }

}