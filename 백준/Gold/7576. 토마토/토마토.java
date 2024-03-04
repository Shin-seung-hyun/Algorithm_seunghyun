import java.io.*;
import java.util.*;

//그래프와 DFS, BFS
    //BFS의 부가기능 - 토마토가 다 익는 최소 일수
public class Main {

    static int N,M;
    static int adj[][];     // 토마토 배열
    static int dist[][];    // 날짜 계산 배열

    // 오른쪽 왼쪽 앞 뒤 이동을 의미하는 임의의 배열
    static int dir[][] = { { 0,-1},{0,1},{1,0},{-1,0}};
    // 익은 토마토 위치
    static ArrayList<int[]> arrList = new ArrayList<>();
    
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 가로
        N = Integer.parseInt(st.nextToken());   // 세로

        //인접 행렬
        adj = new int[N][M];
        dist = new int[N][M];

        // 1은 익은 토마토,
        // 0은 익지 않은 토마토,
        // -1은 토마토 없음

        int fill_tomato = 0;    // 익은 토마토
        int total_tomato = 0;   // 전체 토마토 수
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j =0; j<M; j++){
                int tomato = Integer.parseInt(st.nextToken());

                adj[i][j] = tomato;

                if(tomato != -1 ) total_tomato++;
                if(tomato == 1){
                    fill_tomato++;
                    arrList.add( new int[]{i,j});
                }

                //dist 배열 초기화
                dist[i][j] = -1;
            }
        }
//        System.out.println(total_tomato);
//        System.out.println(fill_tomato);

        //종료 조건
        if( total_tomato == fill_tomato){
            System.out.println(0);
            return;
        }

        // 토마토 탐색
        BFS();

        //출력
        //며칠이 걸리는가? +  day일 후, 모든 토마토가 익었는가
        //int day = 0;
        int after_fill_tomato =0;

        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++) {

                //day = Math.max(day, dist[i][j]);

                if( adj[i][j] == 1) after_fill_tomato++;
            }
        }

        if( total_tomato != after_fill_tomato ) System.out.println(-1);
        else System.out.println(day);
    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        
        //익은 토마토의 위치 모두 넣기
        for( int[] arr : arrList) {

            queue.add(arr[0]);
            queue.add(arr[1]);

            dist[arr[0]][arr[1]] = 0;
        }

        // 며칠이 걸리는가?
            // 큐에 쌓이는 순서는 거리가 클수록 나중에 쌓임으로
        while(!queue.isEmpty()){

            int x = queue.poll();
            int y = queue.poll();
            
            day = Math.max(day, dist[x][y]);

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                // 범위에서 벗어나지 않고
                if( nx >= N || nx < 0|| ny >= M || ny < 0) continue;

                //토마토가 없거나, 토마토가 익은 곳 가지 X
                if( adj[nx][ny] != 0) continue;

                queue.add(nx);
                queue.add(ny);

                adj[nx][ny] = 1;
                dist[nx][ny] = dist[x][y] +1;
            }
        }
        
    }
}