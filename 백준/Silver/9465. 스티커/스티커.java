import java.util.*;

//동적 프로그래밍(DP)
class Main{

    static int N;
    static int[][]  Dy;
    static int[][]  arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i =1; i<=testCase; i++){
            N = sc.nextInt();
            Dy = new int[2][N+1];
            arr = new int[2][N+1];

            for(int j=0; j<2; j++){
                for(int k = 1; k<= N; k++){
                    arr[j][k] = sc.nextInt();
                }
            }

            DP();

            System.out.println(Math.max(Dy[0][N],Dy[1][N]));
        }
    }

    static void DP(){
        //초기화
        Dy[0][1] = arr[0][1];
        Dy[1][1] = arr[1][1];

        //점화식
        for(int i =2; i<=N; i++){
            Dy[0][i] = Math.max(Dy[1][i-1], Dy[1][i-2]) + arr[0][i];
            Dy[1][i] = Math.max(Dy[0][i-1], Dy[0][i-2]) + arr[1][i];
        }
    }

}