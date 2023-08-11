import java.util.*;
import java.io.*;

//
public class Main{

    static int N,L,R;
    static int[][] land;
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static boolean[][] visit;
    static ArrayList<Pos> arrList = new ArrayList<Pos>();

    static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());   // N*N 땅
        L = Integer.parseInt(st.nextToken());   // L명 이상
        R = Integer.parseInt(st.nextToken());   // R명 이하면 국경선을 연다

        land = new int [N][N];
        visit = new boolean [N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 더 이상 인구 이동이 일어나지 않을 때까지 반복
        int result =0;
        while(true){
            visit = new boolean [N][N];
            boolean isMove = false;

            for(int i =0; i<N; i++){
                for(int j =0; j<N; j++){
                    if( visit[i][j]) continue;

                    int sum = BFS(i,j);

                    if(arrList.size() > 1){
                        Change(sum);    // 국경선 내 노드들의 인구수 변경
                        isMove = true;
                    }

                }
            }

            if(!isMove){
                System.out.println(result);
                return;
            }
            result++;

        }// end while

    }

    static void Change(int sum){
        int avg = sum/ arrList.size();

        for(Pos p : arrList){
            land[p.x][p.y] = avg;
        }
    }

    static int BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        arrList = new ArrayList<>();

        queue.add(x); queue.add(y);
        visit[x][y] = true;

        int sum =0;
        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            sum += land[x][y];
            arrList.add(new Pos(x,y));

            for(int i=0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if( nx < 0 || ny <0 || nx >=N || ny>=N ) continue;
                if( ( Math.abs(land[nx][ny] - land[x][y] ) < L ) ||
                    ( Math.abs(land[nx][ny] - land[x][y] ) > R ) ) continue;
                if( visit[nx][ny]) continue;

                queue.add(nx); queue.add(ny);
                visit[nx][ny] = true;
            }
        }


        return sum;
    }

}
