import java.util.*;
import java.io.*;

class Main{
    static int N;   // 세로 길이
    static int M;   // 가로 길이
    static int K;   // 음실물 쓰레기 수
    static int[][] arr;
    static boolean [][]visit;
    static int dist[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        for(int i =1; i<=K; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
        }

        visit = new boolean[N+1][M+1];
        int answer = 0;
        for(int i =1; i<=N; i++){
            for(int j =1; j<=M; j++){

                if(visit[i][j]) continue;
                if(arr[i][j] == 1) {
                    answer = Math.max(answer, BFS(i,j));
                }
            }
        }

        System.out.println(answer);
    }

    static int BFS(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 1;
        //방문
        queue.add(x);
        queue.add(y);
        visit[x][y] = true;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dist[i][0];
                int ny = y + dist[i][1];

                if(nx <=0 || ny <=0 || nx > N || ny > M) continue;
                if(arr[nx][ny] == 0 ) continue;
                if(visit[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                cnt++;
            }
        }

        return cnt;
    }

}