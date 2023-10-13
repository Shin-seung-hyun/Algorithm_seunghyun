import java.io.*;
import java.util.*;

public class Main {

    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};  //위오아왼
    public static char[][] arr;
    public static int visit[][];
    public static int N, M;
    static char[] loc = new char[] {'U','R','D','L'};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            char ch[] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = ch[j];
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) -1;
        int startY = Integer.parseInt(st.nextToken()) -1;

        int maxTime = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < 4; i++) {
            visit = new int[N][M];

            int time = BFS(startX , startY, i , 1);

            //무한궤도일 때 pass
            if(time == -1) {
                System.out.println(loc[i]);
                System.out.print("Voyager");
                return;
            }
            else if(maxTime < time) {
                maxTime = time;         // 거리
                maxIdx = i;            //URDL
            }
        }

        System.out.println(loc[maxIdx]);
        System.out.println(maxTime);
    }


    public static int BFS(int x, int y, int dirIdx, int cnt) {

        visit[x][y] = dirIdx+1; // 방문체크

        if (arr[x][y] == '\\') {
            dirIdx = ((dirIdx + 1) * 3) % 4;

        }
        else if (arr[x][y] == '/') {
            dirIdx = ((dirIdx * 3) + 1) % 4;
        }

        int nx = x + dir[dirIdx][0];
        int ny = y + dir[dirIdx][1];


        if (nx < 0 || nx >= N || ny < 0 || ny >= M ) return cnt;
        if (arr[nx][ny] == 'C') return cnt; // 선을 넘거나 블랙홀을 만났을 때

        else if (visit[nx][ny] == dirIdx+1) return -1; // 방문한 곳 + 같은 방향(무한루프)

        int distance = BFS(nx, ny, dirIdx, cnt + 1);

        return distance;
    }

}