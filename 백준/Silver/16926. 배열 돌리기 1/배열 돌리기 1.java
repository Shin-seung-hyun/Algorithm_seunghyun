import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //행
        int M = Integer.parseInt(st.nextToken());   //열
        int R = Integer.parseInt(st.nextToken());   // 회전 수

        //입력
        arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //R 번 회전
        for(int r=1; r<=R; r++){

            int cnt = Math.min(N,M)/2;
            int [][] tmpArr = new int [N+1][M+1];

            for(int c = 1; c <= cnt; c++){

                // 왼쪽
                for(int i = c; i< N-c + 1; i++) tmpArr[i+1][c] = arr[i][c];

                // 아래
                for(int i = c; i<M-c +1; i++) tmpArr[N-c+1][i+1] = arr[N-c+1][i];

                // 오른쪽
                for(int i = N-c+1; i> c ; i--) tmpArr[i-1][M-c+1] = arr[i][M-c+1];

                // 위
                for(int i=M-c+1; i>c; i--) tmpArr[c][i-1] = arr[c][i];

            }

            arr = tmpArr;

        }

        //출력
        for(int i = 1; i<=N; i++){
            for(int j=1; j<=M; j++){
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }
}