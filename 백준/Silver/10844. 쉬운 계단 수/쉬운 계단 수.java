import java.util.*;
import java.io.*;

class Main{

    static int mod = 1_000_000_000;

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [][] dy = new int[100+1][10];

        //가짜식 dy[i][j] : i번째 자릿수의 값이 j(0~9)일 때, 계단수
        //초기화
        for(int i=1; i<=9; i++) dy[1][i]=1;

        //점화식
        for(int i=2; i<=N; i++){

            for(int j=0; j<=9; j++){

                // 자릿값이 0은 이전 자릿값이 1만 가능 (-1)
                if( j==0) dy[i][0] = dy[i-1][1] % mod;

                // 자릿값이 9는 이전 자릿값이 8만 가능 (+1)
                else if( j ==9) dy[i][9] = dy[i-1][8] % mod;

                //그 외의 자릿값은 +1 -1 모두 가능
                else{

                    dy[i][j] = (dy[i-1][j+1]  + dy[i-1][j-1]) % mod;
                }
            }
        }


        long answer =0;
        for(int val : dy[N]) answer += val;

        System.out.println(answer % mod);
    }
}