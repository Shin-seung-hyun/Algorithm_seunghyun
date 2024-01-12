import java.util.*;

//동적 프로그래밍(DP)
class Main{

    static int N;
    static int[] Dy;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        Dy = new int[N+1];

        for(int i =1; i<=N;i++){
            arr[i] = sc.nextInt();
        }

        DP();

        System.out.println(Dy[N]);
    }

    static void DP(){
        // 초기값 구하기
        Dy[1] = arr[1];

        if (N > 1){
            Dy[2] = arr[1] + arr[2];
        }

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 3; i <= N; i++){

            /*
                경우의 수
                N-3     N-2     N-1     N
                                 O      X
                         O       X      O
                O        X       O      O
            */
            Dy[i] = Math.max( Dy[i-1],
                    Math.max( Dy[i-2] + arr[i], Dy[i-3] + arr[i-1] + arr[i]));
        }

    }
}