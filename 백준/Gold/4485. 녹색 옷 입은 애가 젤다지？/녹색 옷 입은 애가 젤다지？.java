import java.io.*;
import java.util.*;

// 다익스트라 알고리즘
public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;
    static int[][] dist;
    static int[][] dir = { { 0,1}, { 0, -1} , { 1,0}, { -1,0}};
    static class Node{
        int x;
        int y;
        int cost;

        public Node( int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if( N == 0) break;

            // 초기화
            arr = new int [N][N];
            dist = new int [N][N];
            for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE) ;

            // 동굴 입력
            for (int i = 0; i < N; i++) {
                st  = new StringTokenizer(br.readLine());

                for(int j =0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 다익스트라 탐색
            dijkstra(0,0);

            sb.append("Problem " + cnt + ": " + dist[N-1][N-1]).append("\n");
            cnt++;
        }

        System.out.print(sb.toString());
    }

    static void dijkstra(int x, int y){
        PriorityQueue<Node> pq = new PriorityQueue<>( ( o1, o2) -> o1.cost - o2.cost) ;

        pq.add(new Node( x,y,0));
        dist[x][y] = arr[0][0];

        while(!pq.isEmpty()){

            Node now = pq.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];

                if( nx <0 || ny <0 || nx >=N || ny >=N) continue;

                if( dist[nx][ny] > dist[now.x][now.y] + arr[nx][ny]) {
                    dist[nx][ny] = dist[now.x][now.y] + arr[nx][ny];

                    pq.add(new Node( nx, ny, dist[nx][ny]));
                }

            }
        }
    }



}
