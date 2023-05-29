import java.util.*;

//동적 프로그래밍 -DP
    //3. 구간 L ~ R에 대한 문제를 해결할 때
class Main{

    static int[] num;
    static int[][] Dy;      // Dy[i][j]: i ~ j번 파일을 하나로 합치는 최소 비용
    static int[][] sum;     // sum[i][j]: i ~j번 파일의 총 크기
    static int N;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i =1; i<=testCase; i++){

            N = sc.nextInt();

            Dy = new int[N+1][N+1];
            sum = new int[N+1][N+1];

            num = new int[N+1];
            for(int j =1; j<=N; j++){
                num[j] = sc.nextInt();
            }

            //sum 배열 미리 계산
            PreProcess();

            //Dy 배열 계산
            DP();

            //출력
            System.out.println(Dy[1][N]);
        }
    }

    static void PreProcess(){

        for(int i =1; i<=N; i++){
            for(int j =i; j<=N; j++){
                sum[i][j] = sum[i][j-1] + num[j];
            }
        }
    }

    static void DP(){

        for(int len = 2; len<=N; len++){
            for(int i =1; i <= N - len + 1; i++){

                int j = i + len -1;
                Dy[i][j] = Integer.MAX_VALUE;

                for(int k = i; k< j; k++){
                    Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k+1][j] + sum[i][j]);
                }

            }
        }

    }
}