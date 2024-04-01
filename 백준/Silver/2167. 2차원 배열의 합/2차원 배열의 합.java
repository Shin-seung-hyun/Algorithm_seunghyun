import java.util.*;
import java.io.*;

//구현
//누적합
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] prefixSum = new int[N+1][M+1];  //누적합 배열

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //누적합 매열 만들기
        // prefixSum[i][j] = 배열값 + 왼쪽 누적합 + 위쪽 누적합 - 교집합 누적합
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {

                prefixSum[i][j] = arr[i-1][j-1] + prefixSum[i-1][j]
                                                + prefixSum[i][j-1]
                                                - prefixSum[i-1][j-1];
            }
        }


        int K  = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int t=1; t<=K; t++){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //합연산 = 전체 누적합 - 왼쪽 누적합 - 위쪽 누적합 + 교집합 누적합
            System.out.println(prefixSum[x][y]  - prefixSum[i-1][y]
                                                - prefixSum[x][j-1]
                                                + prefixSum[i-1][j-1]);

        }


    }
}
