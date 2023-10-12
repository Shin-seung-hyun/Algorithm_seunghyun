import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());  // 원탁 위 N 명의 사람들
        int K = Integer.parseInt(st.nextToken());   // 임의의 정수

        int []arr = new int [N];
        for(int i=0; i<N; i++){
            arr[i] =  Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int cnt = 1;
        while(cnt <= N){

            int next = arr[idx];

            if( next == K) break;

            idx = next;

            cnt++;
        }

        if( cnt > N ) System.out.println(-1);
        else System.out.println(cnt);


    }
}