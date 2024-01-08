import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int [][]arr;
    static int [][]Dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        Dy = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =1; j<=i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP();

        // 가장 마지막 줄에서 가장 큰 값 찾기
        int answer =0;
        for(int i =1; i<=N; i++){
            answer = Math.max(answer, Dy[N][i]);
        }

        System.out.println(answer);
    }

    static void DP(){

        // 점화식
        //( i , j )가 선택되기 전의 왼쪽 위 ( i-1, j-1), 오른쪽 위 ( i-1, j )
        // Dy[i][j] = Max(Dy[i-1][j] , Dy[i-1][j-1] ) + arr[i][j]

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){

                Dy[i][j] = Math.max(Dy[i-1][j-1] , Dy[i-1][j]) + arr[i][j];
            }
        }
    }
}