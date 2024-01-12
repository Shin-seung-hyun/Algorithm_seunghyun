import java.util.*;
import java.io.*;

/*
    DP
*/
class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [][] dy = new int[10_000+1][3];
        int [] arr = new int[10_000+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        /*
            경우의 수
            N-3     N-2     N-1     N
                             X      X
                             O      X
                    O        O      X
                             X      O
                     X       O      O
        */

        //가짜식 dy[i][0] :  i번째 안 마신 경우
        //      dy[i][1] :  i번째 마시고, 연속으로 1번 먹은 경우
        //      dy[i][2] :  i번째 마시고, 연속으로 2번 먹은 경우
        //초기화
        dy[1][1] = arr[1];

        //점화식
        for(int i =2; i<=N; i++){

            dy[i][0] = Math.max(dy[i-1][0], Math.max( dy[i-1][1], dy[i-1][2]) );
            dy[i][1] = dy[i-1][0] + arr[i];
            dy[i][2] = dy[i-1][1] + arr[i];
        }

        System.out.println( Math.max(dy[N][0], Math.max( dy[N][1],dy[N][2]) ) );
    }
}