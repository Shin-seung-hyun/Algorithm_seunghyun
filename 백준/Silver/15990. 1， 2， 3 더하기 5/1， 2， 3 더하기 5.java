import java.util.*;

//동적 프로그래밍(DP)
class Main{
    static int N;
    static int [][] Dy;
    static long [][] dy;
    static int mod = 1_000_000_009;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        Dy = new int[100_000 +1][3+1];
        dy = new long[100_000 +1][3+1];

        DP();

        for(int i =1; i<=testCase; i++){

            N = sc.nextInt();

            //출력1
            sb.append((dy[N][1] + dy[N][2] + dy[N][3]) % mod + "\n");

            //출력2
//            int answer = 0;
//            for(int j=1; j<=3; j++){
//                answer = (answer + Dy[N][j]) % mod;
//            }
//            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void DP(){

        //초기값
        dy[1][1] = 1;
        dy[2][2] = 1;
        dy[3][1] = dy[3][2] = dy[3][3] = 1;

        //점화식1
        for(int i =4; i<=100_000; i++){
            dy[i][1] = (dy[i-1][2] + dy[i-1][3]) % mod;
            dy[i][2] = (dy[i-2][1] + dy[i-2][3]) % mod;
            dy[i][3] = (dy[i-3][1] + dy[i-3][2]) % mod;
        }

        //점화식1
//        for(int i =4; i<=100_000; i++){
//            for(int j = 1; j<=3; j++){
//                for(int k =1; k<=3; k++){
//
//                    if(k == j) continue;
//                    Dy[i][j] = (Dy[i][j] +  Dy[i-j][k]) % mod;
//                }
//            }
//        }

    }
}