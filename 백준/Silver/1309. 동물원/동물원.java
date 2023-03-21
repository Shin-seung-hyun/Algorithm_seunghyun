import java.util.*;

class Main{

    static int N;
    static int[][] Dy;
    static int mod = 9901;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Dy = new int[N+1][3];

        DP();

        System.out.print((Dy[N][0] + Dy[N][1] + Dy[N][2]) % mod);
    }

    static void DP(){

        //초기화
        Dy[1][0] = 1;
        Dy[1][1] = 1;
        Dy[1][2] = 1;

        /*
        점화식
            Dy[i][0] : i번째 줄에 아무 것도 없을 때
            Dy[i][1] : i번째 줄에 1번째 칸에 넣을 때
            Dy[i][2] : i번째 줄에 2번째 칸에 넣을 때
         */
        for(int i =2; i<=N; i++){
            Dy[i][0] = (Dy[i-1][0] + Dy[i-1][1] + Dy[i-1][2]) % mod;
            Dy[i][1] = (Dy[i-1][0] + Dy[i-1][2]) % mod;
            Dy[i][2] = (Dy[i-1][0] + Dy[i-1][1]) % mod;
        }

    }
}