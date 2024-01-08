import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(br.readLine());

        int[][] Dy = new int[40+1][2];

        ///초기화
        Dy[0][0] = 1;
        Dy[1][1] = 1;

        // 점화식
        for(int i=2; i<=40; i++){
            Dy[i][0] = Dy[i-2][0] + Dy[i-1][0];
            Dy[i][1] = Dy[i-2][1] + Dy[i-1][1];
        }


        for(int i=1; i<=testCase; i++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(Dy[N][0] + " " + Dy[N][1]);
        }

    }
}