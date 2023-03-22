import java.util.*;

class Main{
    static int N;
    static long[][] Dy;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        Dy = new long[N+1][21]; // 값의 범위 0~20

        for(int i =1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        DP();

        System.out.println(Dy[N-1][arr[N]]);
    }

    static void DP(){

        //초기값 설정
        Dy[1][arr[1]] = 1;

        //점화식
        for(int i =2; i<=N-1; i++){
            for(int j = 0; j<=20; j++){

                if (j - arr[i] >= 0)    Dy[i][j] += Dy[i-1][j-arr[i]];
                if (j + arr[i] <= 20)   Dy[i][j] += Dy[i-1][j+arr[i]];
            }

        }
    }
}