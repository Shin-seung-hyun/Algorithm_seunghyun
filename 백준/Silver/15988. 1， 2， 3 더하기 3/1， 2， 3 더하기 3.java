import java.util.*;
import java.io.*;

/*
    DP
*/
class Main{
    static int mod = 1_000_000_009;

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        long [] dy = new long[1_000_000+1];

        //가짜식 dy[i] : i 번째일 때, 1,2,3의 합의로 나타내는 방법의 수
        //초기화
        dy[1] = 1; // 1
        dy[2] = 2; // 1+1, 2
        dy[3] = 4;   // 1+1+1, 2+1, 1+2, 3

        //점화식
        for(int i=4; i<= 1_000_000; i++){
            dy[i] = (dy[i-1] + dy[i-2] + dy[i-3] ) % mod;
        }

        for(int i=1; i<=testCase; i++){
            int n = Integer.parseInt(br.readLine());

            System.out.println(dy[n]);
        }

    }
}