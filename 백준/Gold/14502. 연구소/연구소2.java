import java.util.*;
import java.io.*;

/* 빈 영역과 바이러스 영역을 ArrayList 로 받았을 때 */

//그래프와 DFS, BFS
    //1. 벽을 세우기 -> 빈 영역 empty 중에서 3개 뽑기(완전탐색 DFS)
    //2. 바이러스 상하좌우로 퍼뜨리기 -> BFS
    //3. 안전 영역 구하기 -> 반복문 돌면서 최댓값 갱신
class Main{

    static int N;   //지도의 세로
    static int M;   //지도의 가로
    static int empty;   //지도의 빈공간
    static boolean [][]visit;
    static int [][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}}; //상하좌우 탐색을 위한 임의의 배열
    static int answer = 0;  //정답

    static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Pos> blank = new ArrayList<>();
    static ArrayList<Pos> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화
        adj = new int [N][M];
        visit = new boolean[N][M];

        //입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){

                adj[i][j] = Integer.parseInt(st.nextToken());

                // 빈 공간 따로 배열에 모으기
                if( adj[i][j] == 0) blank.add( new Pos(i,j));

                // 바이러스 배열에 따로 모으기
                else if ( adj[i][j] == 2)  virus.add( new Pos( i,j));

            }
        }

        // empty개 중에서 3개의 벽 세우기
        DFS( 0,0);

        System.out.println(answer);
    }

    static void DFS( int idx , int fallCnt){

        // 종료조건
        if( fallCnt == 3){

            // 바이러스 탐색
            BFS();

            return;
        }

        if( idx >= blank.size()) return;

        // 반복 조건
        int x = blank.get(idx).x;
        int y = blank.get(idx).y;

        adj[x][y] = 1;
        DFS(idx+1, fallCnt+1);

        adj[x][y] = 0;
        DFS(idx+1, fallCnt);

    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();

        visit = new boolean[N][M];

        // 바이러스 위치 큐에 넣기
        for(int i=0; i< virus.size(); i++){
            queue.add( virus.get(i).x);
            queue.add( virus.get(i).y);

            visit[virus.get(i).x][virus.get(i).y] = true;
        }

        while(!queue.isEmpty()){

            int x = queue.poll();
            int y = queue.poll();

            for(int i=0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if( nx < 0 || ny <0 || nx >=N || ny >=M) continue;

                if( adj[nx][ny] !=0) continue;

                if( visit[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
            }
        }

        checkSafeZone();
    }

    static void checkSafeZone(){
        int cnt  = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                if( adj[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }
}