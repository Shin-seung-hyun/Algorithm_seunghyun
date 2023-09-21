import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 사람수
        int M = Integer.parseInt(st.nextToken());   // 한 사람이 공을 M번 받으면 게임 종료
        int L = Integer.parseInt(st.nextToken());   // 자기 위치에서 L번째 사람에게 공을 준다

        int arr[] = new int [N];
        arr[0] = 1;

        int cnt = 0;
        int idx = 0;
        while(arr[idx] < M){
            cnt++;

            //짝수라면 반시계방향으로 L번째
            if(arr[idx] % 2 == 0) idx = (idx + (N - (L % N))) % N;

            // 홀수라면 시계방향으로 L번째
            else idx = (idx + L) % N;

            arr[idx]++;
        }

        System.out.println(cnt);
    }

}