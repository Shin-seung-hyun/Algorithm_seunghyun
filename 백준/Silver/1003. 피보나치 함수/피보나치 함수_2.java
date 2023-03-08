import java.util.*;

//동적 프로그래밍(DP)
public class Main{

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i =1; i<=testCase; i++){
            N = sc.nextInt();

            //Dy[N][0] : N을 호출했을 때, 0이 몇 번 나오는지
            //Dy[N][1] : N을 호출했을 때, 1이 몇 번 나오는지
            Dy = new int[N+1][2];

            DP(N);

            sb.append(Dy[N][0]).append(" ").append(Dy[N][1]).append("\n");

        }

        System.out.print(sb.toString());
    }

    static void DP(int x){

        //초기화
        Dy[0][0] = 1;
        Dy[0][1] = 0;

        if(x>=1){
            Dy[1][0] = 0;
            Dy[1][1] = 1;

            if(x>=2){

                for(int i =2; i<=N; i++){

                    Dy[i][0] = Dy[i-1][0] + Dy[i-2][0];
                    Dy[i][1] = Dy[i-1][1] + Dy[i-2][1];
                }
            }
        }

    }
}