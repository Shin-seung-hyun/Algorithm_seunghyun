import java.util.*;
import java.io.*;

class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long []dy = new long [90+1];

        //가짜식 Dy[i] : i 번째 피보나치 수
        //초기화
        dy[0]= 0;
        dy[1] = 1;

        for(int i=2; i<=N; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }

        System.out.println(dy[N]);

    }
}