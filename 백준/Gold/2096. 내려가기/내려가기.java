import java.util.*;

//동적 프로그래밍(DP)
class Main{

    static int N;
    static int [][]arr;
    static int [][]maxDy;
    static int [][]minDy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1][3+1];
        maxDy = new int[N+1][3+1];
        minDy = new int[N+1][3+1];

        for(int i= 1; i<=N; i++){
            for(int j =1; j<=3; j++){
                arr[i][j] =sc.nextInt();
            }
        }

        DP();

        sb.append(Math.max(Math.max(maxDy[N][1],maxDy[N][2]),maxDy[N][3]));
        sb.append(" ");
        sb.append(Math.min(Math.min(minDy[N][1],minDy[N][2]),minDy[N][3]));
        System.out.println(sb.toString());
    }

    static void DP(){
        //초기값
        maxDy[1][1] = minDy[1][1] = arr[1][1];
        maxDy[1][2] = minDy[1][2] = arr[1][2];
        maxDy[1][3] = minDy[1][3] = arr[1][3];

        for(int i =2; i<=N; i++){
            maxDy[i][1] = Math.max(maxDy[i-1][1], maxDy[i-1][2]) + arr[i][1];
            maxDy[i][2] = Math.max(Math.max(maxDy[i-1][1], maxDy[i-1][2]), maxDy[i-1][3]) + arr[i][2];
            maxDy[i][3] = Math.max(maxDy[i-1][2], maxDy[i-1][3]) + arr[i][3];

            minDy[i][1] = Math.min(minDy[i-1][1], minDy[i-1][2]) + arr[i][1];
            minDy[i][2] = Math.min(Math.min(minDy[i-1][1], minDy[i-1][2]), minDy[i-1][3]) + arr[i][2];
            minDy[i][3] = Math.min(minDy[i-1][2], minDy[i-1][3]) + arr[i][3];
        }

    }
}