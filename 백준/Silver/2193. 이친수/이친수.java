import java.util.*;

//동적 프로그래밍(DP)
public class Main{
    static int N;
    static long[][] Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Dy = new long[N+1][2];

        DP();

        System.out.print(Dy[N][0] + Dy[N][1]);
    }

    static void DP(){

        //초기화
        Dy[1][0] = 0;
        Dy[1][1] = 1;

//        if(N > 1) {
//            Dy[2][0] = 1;
//            Dy[2][1] = 0;
//        }

        for(int i =2; i<=N; i++){
            Dy[i][0] = Dy[i-1][0] + Dy[i-1][1];
            Dy[i][1] = Dy[i-1][0];
        }

    }
}