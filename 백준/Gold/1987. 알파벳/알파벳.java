import java.util.*;
import java.io.*;

// 지날 수 있는 최대의 칸 수 구하기
class Main{
    static int R;   // 세로
    static int C;   // 가로
    static int answer;
    static char[][] arr;
    static boolean[] visit;
    static int [][]dist = { {0,-1},{0,1}, {1,0},{-1,0}};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[26];
        arr = new char[R+1][C+1];
        for(int i =1; i<=R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j+1] = str.charAt(j);
            }
        }

        //DFS(1,1,0);
        DFS2(1,1,0);

        System.out.println(answer);
    }

    //DFS 방법1
    static void DFS(int x, int y, int cnt) {

        //종료 조건
        if(visit[arr[x][y] -'A']){
            answer = Math.max(answer, cnt);
            return;
        }

        //반복 조건
        visit[arr[x][y] -'A'] = true;
        cnt = cnt +1;

        for(int i =0; i<4; i++) {
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];

            if (nx <= 0 || ny <= 0 || nx > R || ny > C) continue;

            DFS(nx, ny, cnt);
        }

        visit[arr[x][y] -'A'] = false;
    }

    //DFS 방법2
    static void DFS2(int x, int y ,int cnt ){

        visit[arr[x][y] -'A'] = true;
        cnt = cnt + 1;
        answer = Math.max(answer, cnt);

        for(int i =0; i<4; i++) {
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];

            if(nx <= 0 || ny <= 0 || nx > R || ny > C) continue;

            if(visit[arr[nx][ny] - 'A']) continue;

            DFS2(nx, ny, cnt);

            visit[arr[nx][ny] -'A'] = false;
        }

    }

}