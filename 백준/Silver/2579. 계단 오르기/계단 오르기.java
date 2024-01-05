import java.util.*;

//동적 프로그래밍 DP
    //level 2. 조건에 맞게 상태를 추가해야 하는 경우
class Main{

    static int N;   //N개의 계단 수
    static int[] arr;   //계단의 점수 배열
    static int[][] Dy;  //DP array

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Dy = new int[N+1][2];
        arr = new int[N+1];
        for(int i =1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        // Dy[i][0] = i-2를 밟고, i 번째 계단에 도달하는 최대 점수
        // Dy[i][1] = i-1을 밟고, i 번째 계단에 도달하는 최대 점수
        Pro();

        System.out.println(Math.max( Dy[N][0], Dy[N][1] ));
    }

    static void Pro(){

        //초기값 저장
        Dy[1][0] = 0;
        Dy[1][1] = arr[1];

        if(N >= 2){
            Dy[2][0] = arr[2];
            Dy[2][1] = arr[1] + arr[2];
        }

        // Dy 배열 채우기
        for(int i = 3; i<=N; i++){
            Dy[i][0] = Math.max(Dy[i-2][0] + arr[i], Dy[i-2][1] + arr[i]);
            Dy[i][1] = Dy[i-1][0] + arr[i];
        }

    }

}