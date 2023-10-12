import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N  = Integer.parseInt(br.readLine());  // 방의 개수
        int M = Integer.parseInt(br.readLine());   // 부수는 횟수

        int arr[] = new int [N+1];

        for(int i =1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j =x; j<y; j++){
                arr[j] = 1;
            }

        }

        //출력
        int cnt =0;
        for(int i=1; i<=N; i++){
            if( arr[i] == 0) cnt++;
        }

        System.out.println(cnt);
    }
}