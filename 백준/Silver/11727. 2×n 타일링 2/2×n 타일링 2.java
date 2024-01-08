import java.util.*;
import java.io.*;

class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] Dy = new int[1_000+1];

        // 초기화
        Dy[1] =1;
        Dy[2] =3;

        //점화식
        for(int i=3; i<=N; i++){

            Dy[i] =(Dy[i-1] + (Dy[i-2] *2)) % 10_007;
        }

        System.out.println(Dy[N]);

    }
}