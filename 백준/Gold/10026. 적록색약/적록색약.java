import java.util.*;
import java.io.*;

//
class Main{
    static int N;   // N * N
    static char[][] arr;
    static boolean[][] visit;
    static int [] rgb;
    static int rb = 0;
    static int [][]dist = { {0,-1},{0,1}, {1,0},{-1,0}};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        rgb = new int[3];
        visit = new boolean[N+1][N+1];
        arr = new char[N+1][N+1];
        for(int i =1; i<=N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j+1] = str.charAt(j);
            }
        }

        // 정상일 때
        int normal_cnt = 0;
        for(int i =1; i<=N; i++){
            for(int j=1; j<=N; j++){

                if(visit[i][j]) continue;

                BFS(i, j, arr[i][j]);
                normal_cnt++;
//                if(arr[i][j] == 'R') rgb[0]++;
//                else if (arr[i][j] == 'G') rgb[1]++;
//                else rgb[2]++;
            }
        }

        //초기화
        for(boolean[] val : visit){
            Arrays.fill(val, false);
        }

        //ConvertR2G
        for(int i =1; i<=N; i++){
            for(int j =1; j<=N; j++){
                if(arr[i][j] == 'R') arr[i][j] = 'G';
            }
        }

        //비정상일 때
        int abnormal_cnt = 0;
        for(int i =1; i<=N; i++){
            for(int j =1; j<=N; j++){
                if(visit[i][j]) continue;

                BFS(i, j, arr[i][j]);
                abnormal_cnt++;

            }
        }

        System.out.println( normal_cnt+ " " + abnormal_cnt++);
        //System.out.println( (rgb[0]+ rgb[1]+ rgb[2]) + " " + abnormal_cnt++);

    }
    static void BFS(int x, int y, int rgb){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);
        visit[x][y]= true;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dist[i][0];
                int ny = y + dist[i][1];

                if(nx <=0 || ny<=0 || nx >N || ny >N) continue;
                if(visit[nx][ny]) continue;
                if(arr[nx][ny] != rgb) continue;
                //if( arr[nx][ny] != arr[x][y]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
            }
        }
    }

}