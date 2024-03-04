import java.io.*;
import java.util.*;

//BFS
public class Main {

    static int N,M;
    static int arr[][];
    static boolean visit[][];

    static int dir[][] = { { 0,-1},{0,1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 세로
        M = Integer.parseInt(st.nextToken());   // 가로

        //인접행렬
        arr = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxArea = 0;
        int cnt = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){

                if(visit[i][j] || arr[i][j] == 0) continue;

                maxArea = Math.max(maxArea, BFS( i, j));
                cnt ++;
            }
        }

        System.out.println(cnt);
        System.out.println(maxArea);
    }

    static int BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        //int area = 1;
        int area = 0;

        queue.add(x);
        queue.add(y);
        visit[x][y] = true;

        while(!queue.isEmpty()){

            area++; // 큐에서 원소를 하나 뺄 때마다 넓이 1 증가시킴

            x = queue.poll();
            y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if( nx > N || nx <= 0|| ny > M || ny <=0) continue;
                if( visit[nx][ny]) continue;
                if( arr[nx][ny] == 0) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                //area++;
            }
        }

        return area;
    }
}