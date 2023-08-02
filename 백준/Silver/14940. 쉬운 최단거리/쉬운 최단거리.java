import java.io.*;
import java.util.*;

// 그래프 BFS의 부가기능
public class Main {

    static int N;   // 세로
    static int M;   // 가로

    // 인접 행렬
    static int[][] adj;     // 지도
    static int[][] dist;    // 목표 지점까지의 거리
    static int [][] dir ={ {1,0},{0,1},{-1,0},{0,-1} };   // 가로 세로 이동

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int [N+1][M+1];
        dist= new int [N+1][M+1];

        for(int i =1; i<=N; i++) {
            Arrays.fill(dist[i], -1);
        }

        //지도 입력
        int startX =0, startY =0;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j =1; j<=M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 2){
                    startX = i;
                    startY = j;
                }
                if(tmp == 0) dist[i][j] = 0;

                adj[i][j]= tmp;
            }
        }


        // BFS 탐색 시작
        BFS(startX ,startY);

        // 정답 출력
        for(int i=1; i<=N; i++){
            for(int j =1; j<=M; j++){
                sb.append(dist[i][j] +" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        // 시작지점 방문
        dist[x][y] = 0;
        queue.add(x);
        queue.add(y);

        //방문할 수 있는 곳 모두 탐색
        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                // 범위를 벗어나는지
                if( nx <=0 || ny <=0 || nx >N || ny >M) continue;

                // 갈 수 없는 땅인지
                if( dist[nx][ny] == 0) continue;

                // 갔던 곳인지
                if( dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                queue.add(nx);
                queue.add(ny);
            }
        }//end while

    }//end BFS

}

