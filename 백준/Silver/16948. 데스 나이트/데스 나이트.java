import java.io.*;
import java.util.*;


public class Main {
    static boolean[][] visit;
    static int cnt = 0;
    static int N;
    static int r2, c2;
    static int[][] dir = { { -2,-1}, {-2,1}, {0,-2}, {0,2}, {2,-1}, {2,1} };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visit = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());

        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        System.out.print(BFS(r1,c1));
    }

    static int BFS(int r1, int c1) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(r1);
        q2.add(c1);
        
        visit[r1][c1] = true;

        while (!q1.isEmpty()) {

            int size = q1.size();

            for (int i = 0; i < size; i++) {
                int x = q1.remove();
                int y = q2.remove();

                if (x == r2 && y == c2) return cnt;

                for (int j = 0; j < 6; j++) {

                    int nx = x + dir[j][0];
                    int ny = y + dir[j][1];

                    if (nx < 0 || nx > N -1) continue;
                    if (ny < 0 || ny > N -1) continue;
                    if( visit[nx][ny]) continue;

                    
                    visit[nx][ny] = true;
                    q1.add(nx);
                    q2.add(ny);
                    
                }
            }

            cnt++;
        }

        return -1;
    }
}