import java.util.*;
import java.io.*;

class Main{
    static int N;   // 삼각형의  크기
    static int[][] arr;
    static int[][] Dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Dy = new int [N+1][N+1];
        arr = new int [N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =1; j<=i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //( i , j )가 선택되기 전의 왼쪽 위 ( i-1, j-1), 오른쪽 위 ( i-1, j )
        // 점화식
        // Dy[i][j] = Max(Dy[i-1][j] , Dy[i-1][j-1] ) + arr[i][j]

        for(int i =1; i<=N; i++){
            for(int j =1; j<=N; j++){

                Dy[i][j] = Math.max(Dy[i-1][j-1], Dy[i-1][j]) + arr[i][j];
            }
        }


        // 가장 마지막 줄에서 가장 큰 값 찾기
        int answer = 0;
        for(int i =1; i<=N; i++){
            if(answer < Dy[N][i]) answer = Dy[N][i];
        }

        System.out.println(answer);
    }

}