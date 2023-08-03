import java.io.*;
import java.util.*;

// DP
// 중복을 지원하지 않는 1,2,3 더하기
public class Main {

    static int[][] Dy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동적 프로그래밍
        Dy = new int[10_000+1][4];

        DP();

        int testCase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testCase; t++){
            int num = Integer.parseInt(br.readLine());

            sb.append(Dy[num][1] + Dy[num][2] + Dy[num][3] + "\n");
        }

        System.out.print(sb.toString());
    }

    // 수식은 오름차순으로 정렬
    static void DP(){

        // 초기화
        Dy[1][1] = 1;   //1

        Dy[2][1] = 1;   // 1 + 1
        Dy[2][2] = 1;   // 2

        Dy[3][1] = 1;   // 1 + 1 + 1
        Dy[3][2] = 1;   // 1 + 2
        Dy[3][3] = 1;   // 3

        // 점화식
        for(int i =4; i<=10_000; i++){

            Dy[i][1] = Dy[i-1][1];
            Dy[i][2] = Dy[i-2][1] + Dy[i-2][2];
            Dy[i][3] = Dy[i-3][1] + Dy[i-3][2] + Dy[i-3][3];
        }
    }

}

