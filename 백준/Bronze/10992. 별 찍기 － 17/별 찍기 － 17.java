import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){

            // 오른쪽 빈 공간
            for(int j=1; j<= N-i; j++) sb.append(" ");

            if( i ==N ){
                for(int j=1; j<=2*N-1; j++) sb.append("*");
            }
            else {
                for (int j = 1; j <= 2 * i - 1; j++){

                    if( j==1 || j == 2*i-1) sb.append("*");
                    else sb.append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}