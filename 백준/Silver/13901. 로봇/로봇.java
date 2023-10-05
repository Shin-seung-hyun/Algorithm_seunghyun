import java.io.*;
import java.util.*;


public class Main {

    static int[][] arr;
    static boolean[][] visit;

    // 상하좌우
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] move;
    static int moveIdx;
    static int curX, curY;
    static int col, row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());   // 열(세로)
        row = Integer.parseInt(st.nextToken());   // 행(가로)

        arr = new int[col][row];
        visit = new boolean[col][row];

        //장애물
        int block = Integer.parseInt(br.readLine()); // 장애물 수
        for (int i = 1; i <= block; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 2;
        }

        // 시작점
        st = new StringTokenizer(br.readLine());
        curX = Integer.parseInt(st.nextToken());
        curY = Integer.parseInt(st.nextToken());
        arr[curX][curY] =1;

        //이동 방향 순서
        move = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) move[i] = Integer.parseInt(st.nextToken())-1;

        BFS();

        System.out.println(curX + " "  + curY);
    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(curX);
        queue.add(curY);
        visit[curX][curY] = true;

        while(!queue.isEmpty()){

            int x = queue.poll();
            int y = queue.poll();

            for(int i=0; i<4; i++){

                int index = move[ (moveIdx + i) % 4 ];
                int nx = x + dir[index][0];
                int ny = y + dir[index][1];

                if( nx <0 || ny <0 || nx >= col || ny >=row ) continue;
                if( visit[nx][ny] ) continue;   // 방문 했던 곳 못 감
                if( arr[nx][ny] == 2) continue; // 장애물이면 못 감

                visit[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);

                moveIdx = (moveIdx + i) %4;

                curX = nx;
                curY = ny;

                break;
            }
        }
    }
}



