import java.util.*;

//동적 프로그래밍(DP)
class Main{
    static int N;   // 곡의 수
    static int S;   // 시작 볼륨
    static int M;   // 최대 볼륨
    static int[][]  Dy;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        Dy = new int[N+1][M+1];
        arr= new int[N+1];

        for(int i =1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        DP();

    }
    static void DP(){

        //초기값
        Dy[0][S] = 1;

        for(int i =1; i<=N; i++){
            for(int pre =0; pre<=M; pre++){

                if(Dy[i-1][pre] !=1) continue;

                int plus = pre + arr[i];
                int minus = pre - arr[i];

                if(plus <=M) Dy[i][plus] = 1;
                if(minus >=0) Dy[i][minus] =1;

            }
        }

        //출력
        for(int i = M; i>=0; i--){
            if(Dy[N][i] ==1) {
                System.out.println(i);
                return;
            }
        }
        
        System.out.println(-1);
    }
    
}
