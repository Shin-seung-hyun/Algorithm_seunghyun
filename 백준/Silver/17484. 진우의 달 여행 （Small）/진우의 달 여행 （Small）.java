import java.util.*;
import java.io.*;

//DFS
// 시작위치를 첫째행의 모든 열로 하여 DFS 탐색
class Main{
    static int N;
    static int M;
    static int[][] adj;
    static int[] dir = { -1, 0, 1}; // 왼쪽 아래, 아래, 오른쪽 아래

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int [N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=M ;j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS
        for(int i=1; i<=M; i++){
            DFS(0, i, 0, 0);
        }

        System.out.println(min);
    }

    static void DFS(int depth, int x , int prePosition, int sum){

        // 종료 조건
        if( depth == N){

            if(min > sum) min = sum;

            return;
        }

        // 반복 조건
        for(int i=1; i<=3; i++){
            int nx = x + dir[i-1];

            if( prePosition == i || nx <= 0 || nx > M ) continue;

            DFS(depth + 1, nx, i, sum + adj[depth+1][nx]);
        }
    }
}