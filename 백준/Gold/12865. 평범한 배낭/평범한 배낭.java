import java.util.*;
import java.io.*;

//K 만큼의 무게를 가진 최대가치 구하기
public class Main{
    static int N;   // 물건 개수
    static int K;   // 한계 무게
    static int[] W; //무게 배열
    static int[] V; //가치 배열
    static int[][] Dy;  //Dy[i번 째 아이템][무게]

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int [N+1];

        Dy = new int [N+1][K+1];

        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // N = 4, K= 7
        // (Wi, Vi) = (6, 13), (4, 8), (3, 6), (5, 12)

        DP();

        System.out.println(Dy[N][K]);
    }

    static void DP() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                // 이전 가치를 현재 가치로 저장
                Dy[i][j] = Dy[i - 1][j];

                // 현재 무게에서 남는 무게가 존재한다면,
                // Math.max(이전 가치, 남은 무게 가치 + 자신 가치 )
                if (j - W[i] >= 0) Dy[i][j] = Math.max(Dy[i - 1][j], Dy[i - 1][j - W[i]] + V[i]);
            }
        }


    }
}