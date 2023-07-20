import java.io.*;
import java.util.*;

//DP
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[N][M][3]; //[행][열][앞에서 도착한 방향 0:왼, 1:가운데, 2:오른]
        int [][] arr = new int [N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //DP
        // 초기화
        for(int i=0; i<M; ++i){
            dp[0][i][0] = arr[0][i]; // 왼쪽 대각선
            dp[0][i][1] = arr[0][i];  // 가운데
            dp[0][i][2] = arr[0][i];  // 오른쪽 대각선
        }

        // 점화식
        int min = Integer.MAX_VALUE;
        for(int i=1; i<N; i++) {
            for(int j=0; j<M; j++) {

                if(j==0) { //0번째열, 오른쪽 방향에서 도착 X
                    dp[i][j][0] = min; //큰값으로 초기화
                    dp[i][j][1] = dp[i-1][j][2] + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }
                else if(j==M-1) { //M-1열, 왼쪽(0)방향 도착 X
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + arr[i][j];
                    dp[i][j][2] = min; //초기화
                }
                else {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }
            }
        }

        for(int i=0; i<M; ++i) {
            for(int j=0; j<3; ++j) {
                min = Math.min(min, dp[N-1][i][j]); //마지막행에서 최소값 찾기
            }
        }

        System.out.print(min);
    }
}