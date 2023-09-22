import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t<=tc; t++) {

            int N = Integer.parseInt(br.readLine());

            int max = N;
            while( N != 1){

                if( N % 2 ==0) N /=2;
                else N = N*3 +1;

                max = Math.max(max,N);
            }

            sb.append(max).append("\n");

        }

        System.out.println(sb.toString());
    }

}