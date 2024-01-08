import java.util.*;
import java.io.*;


//참고 : https://st-lab.tistory.com/131
class Main{

    static int N;
    static int[][]arr;
    static Integer[][]Dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];    // int[][] 배열의 초기값 0
        Dy = new Integer[N+1][N+1]; // Integer[][] 배열의 초기값 null

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초기값
            //Dy의 마지막 행 채우기
        for(int i= 1; i<=N; i++) Dy[N][i] = arr[N][i];


        System.out.println( find(1,1));
    }

    static int find(int depth, int idx){

        //종료 조건
            // 마지막 행일 경우 현재 위치의 Dy값 반환
        if(depth == N) return Dy[depth][idx];

        //반복 조건
            //탐색하지 않았던 값일 경우, 다음 행의 양쪽 값 비교
        if( Dy[depth][idx] == null){

            Dy[depth][idx] = Math.max( find(depth +1, idx),
                                       find( depth+1, idx+1) ) + arr[depth][idx];
        }

        return Dy[depth][idx];
    }


}