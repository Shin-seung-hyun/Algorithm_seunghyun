import java.io.*;
import java.util.*;

//BFS
    // 불 모두 이동 -> 지훈 이동
    //지금은 지훈이의 이동은 불의 전파에 영향을 받지만, 불은 지훈이의 이동에 영향을 받지 않아서, 불만 먼저 전파 시키는게 가능했다.
    // 그러나, 불과 소방수(물) 같이, 둘 간의 상호작용이 발생한다면,
    // 즉, 두 종류의 BFS에서 BFS를 돌 때 어느 하나가 독립적이지 않고 서로에게 영향을 준다면, 현재 방법으로는 문제를 해결할 수 없다
    // 그런 상황에서는 시간 순으로 A와 B를 동시에 진행시켜야 한다.
public class Main {
    static int[][] Fdist; // 불의 전파 시간
    static int[][] Jdist; // 지훈이의 이동 시간
    static char[][] adj;
    static int N, M;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static Queue<Integer> FQ = new LinkedList<>();
    static Queue<Integer> JQ = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new char[N][M];
        Jdist = new int[N][M];
        Fdist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);

                if (c == 'J') {
                    JQ.add(i);
                    JQ.add(j);
                    Jdist[i][j] = 0;
                    Fdist[i][j] = -1;
                }

                else if (c == 'F') {
                    FQ.add(i);
                    FQ.add(j);
                    Fdist[i][j] = 0;
                    Jdist[i][j] = -1;
                }

                else {
                    adj[i][j] = c;
                    Jdist[i][j] = Fdist[i][j] = -1;
                }

            }
        }

        int result = BFS();
        if( result == -1 ) System.out.println("IMPOSSIBLE");
        else System.out.println(result);
    }

    static int BFS(){

        // 불에 대한 BFS
        //미리 각 칸에 불이 전파되는 시간을 다 구하기
        while (!FQ.isEmpty()) {

            int x = FQ.poll();
            int y = FQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (Fdist[nx][ny] >= 0) continue;   // 방문 여부 확인
                if( adj[nx][ny] == '#') continue;

                FQ.add(nx);
                FQ.add(ny);
                Fdist[nx][ny] = Fdist[x][y] + 1;
            }
        }

        //System.out.println(Fdist);

        // 지훈이에 대한 BFS
        //만약 지훈이가 특정 칸을 x시간에 최초 방문할 때, 그 칸에는 x시간이나 그 이전에 불이 붙었다면 그 칸은 못간다.
        while (!JQ.isEmpty()) {

            int x = JQ.poll();
            int y = JQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                //종료 조건
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) { // 범위를 벗어났다는 것은 탈출에 성공했다는 의미.
                    return Jdist[x][y] + 1;
                }

                if (Jdist[nx][ny] >= 0 ) continue;  // 방문 여부 확인
                if (adj[nx][ny] == '#') continue;
                // 불의 전파 시간을 조건에 추가
                // 불이 안 간 곳이면서 + 불의 도착할 시간보다 지훈이 도착 시간이 빠르면
                if (Fdist[nx][ny] != -1 && Fdist[nx][ny] <= Jdist[x][y] + 1) continue;

                JQ.add(nx);
                JQ.add(ny);
                Jdist[nx][ny] = Jdist[x][y] + 1;
            }
        }

        return -1; // 여기에 도달했다는 것은 탈출에 실패했음을 의미.
    }
}