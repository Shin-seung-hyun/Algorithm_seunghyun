import java.util.*;

//DP
//매번 구간합을 구하면 O(N^2 x M) 발생. 따라서, 점화식을 이용하여 구간합을 반환해야 함
//구간합(x1, y1, x2, y2) = 구간합(0, 0, x1-1, y2) + 구간합(0, 0, x2, y1-1) - 구간합(0, 0, x1-1, y1-1) + 값 (x2, y2)
class Main{

    static int[][] Dy;
    static int N;
    static int M;
    static int[][]arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        Dy = new int[N+1][N+1];
        arr = new int[N+1][N+1];
        for(int i =1; i<=N; i++){
            for(int j =1; j<=N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //누적합 Dy[][] 배열 만들기
        for(int i =1; i<=N; i++){
            for(int j =1; j<=N; j++){
                Dy[i][j] = Dy[i-1][j] + Dy[i][j-1] - Dy[i-1][j-1] + arr[i][j];
            }
        }

        for(int i=1; i<=M; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            DP(x1, y1, x2, y2);
        }

        System.out.print(sb.toString());
    }

    //누적합 + DP
    // 모든 좌표의 (0,0) ~ (x,y)의 합을 O(N^2)에 구할 수 있고, 그후로 O(1)만에 값 반환
    // 즉, 전체 복잡도 O(N^2)
    public static void DP(int x1, int y1, int x2, int y2){
        int sum = 0;

        sum = Dy[x2][y2] - Dy[x2][y1-1] - Dy[x1-1][y2] + Dy[x1-1][y1-1];

        sb.append(sum + "\n");
    }

    //시간 복잡도 O(N^2 x M) -> 시간 초과
    public static void sum(int x1, int y1, int x2, int y2){

        int sum = 0;

        for(int i =x1; i <= x2; i++){
            for(int j =y1; j<= y2; j++){
                sum = sum + arr[i][j];
            }
        }

        sb.append(sum +"\n");
    }

}