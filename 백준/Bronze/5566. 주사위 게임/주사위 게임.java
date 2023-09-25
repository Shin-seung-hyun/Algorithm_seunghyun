import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // N 도착지점
        int M = Integer.parseInt(st.nextToken());   // 주사위 던진 횟수

        int []arr = new int [N+1];
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());

        int [] dice = new int [M+1];
        for(int i=1; i<=M; i++) dice[i] = Integer.parseInt(br.readLine());

        int cnt = 1;    // 총 이동 횟수
        int idx = 1;    // 현재 위치
        while( idx < N){

            idx = idx + dice[cnt];
            cnt++;

            if( idx >= N) break;

            idx += arr[idx];

        }

        System.out.println(cnt-1);
    }

}