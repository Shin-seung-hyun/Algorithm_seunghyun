import java.util.*;
import java.io.*;

class Main{
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        long[] Dy = new long[100 + 1];

        //가짜식 Dy[i] : 가장 긴 삼각형의 길이
        //초기화
        Dy[0] = 0;
        Dy[1] = Dy[2] = Dy[3]= 1;
        Dy[4] =2;

        for(int i=5; i<=100; i++){
            Dy[i] = Dy[i-1] + Dy[i-5];
        }

        for(int i=1; i<=testCase; i++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(Dy[N]);
        }

    }
}