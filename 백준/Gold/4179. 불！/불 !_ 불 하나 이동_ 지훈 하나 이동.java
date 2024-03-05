import java.util.*;
import java.io.*;

//BFS()
    // 불이 한 번 움직이고, 지훈이가 한 번 움직일 때
class Main{

    static int N,M;
    static char[][] adj;

    static int[][]dir = { { 0,1},{0,-1},{1,0},{-1,0}};

    static Queue<Integer> JQ = new LinkedList<>();
    static Queue<Integer> FQ = new LinkedList<>();

    static boolean[][] Fvisit;
    static boolean[][] Jvisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new char[N][M];
        Fvisit = new boolean[N][M];
        Jvisit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {

                char c = str.charAt(j);

                if (c == 'J') {
                    JQ.add(i);
                    JQ.add(j);
                    Jvisit[i][j] = true;

                    adj[i][j] = '.';
                }

                else if (c == 'F') {
                    FQ.add(i);
                    FQ.add(j);
                    Fvisit[i][j] = true;
                }

                else adj[i][j] = c;
            }
        }

        int result = BFS();

        if (result == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(result);

    }

    static int BFS(){

        int time = 0;

        // 지훈이가 더이상 갈 곳이 없을 때까지 반복
        while(!JQ.isEmpty()) {

            // JLen, FLen : 지훈, 불이 1초에 이동할 수 있는 모든 위치의 수
                // 지훈과 불이 더이상 갈 곳이 없을 때까지 움직여야 한다면 while(!JQ FQ.isEmpty())를 써야하지만,
                // 불 한 번, 지훈이 한 번 움직여아 함으로 while문을 쓸 수 없다.
                // 따라서 for문을 통해, 불과 지훈이가 1초동안 움직일 수 있는 위치 경우의 수만큼 반복해야 한다.
            int JLen = JQ.size()/2;
            int FLen = FQ.size()/2;

            //1. 불 먼저 이동
            for(int l =0; l<FLen; l++) {
                int fx = FQ.poll();
                int fy = FQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nfx = fx + dir[i][0];
                    int nfy = fy + dir[i][1];

                    if (nfx < 0 || nfx >= N || nfy < 0 || nfy >= M) continue;
                    if (adj[nfx][nfy] == '#') continue;     // !! 주의 !! 불은 벽 빼고 다 갈 수 있음
                    if (Fvisit[nfx][nfy]) continue;

                    FQ.add(nfx);
                    FQ.add(nfy);
                    Fvisit[nfx][nfy] = true;
                    adj[nfx][nfy] = 'F';
                }
            }

            //2. 지훈 이동
            for(int l = 0; l < JLen; l++) {
                int jx = JQ.poll();
                int jy = JQ.poll();

                for (int i = 0; i < 4; i++) {
                    int njx = jx + dir[i][0];
                    int njy = jy + dir[i][1];

                    // 종료 조건 -> 지훈이 외각에 도착하면 프로그램 종료
                    if (njx < 0 || njx >= N || njy < 0 || njy >= M) {
                        return time +1;

                        // 프로그램 종료
                        // 1. return; -> 일반 함수에서 사용 시, 일반함수만 종료
                        // 2. System.exit(0); -> 일반 함수에서 사용해도 main함수까지 전체 강제 종료
                        //System.exit(0);
                    }
                    if (adj[njx][njy] != '.') continue;
                    if (Jvisit[njx][njy]) continue;

                    JQ.add(njx);
                    JQ.add(njy);
                    // 가장 빠른 탈출 시간을 구하기 위해, 이전 방문 공간을 다시 방문하지 않도록 함.
                    Jvisit[njx][njy] = true;
                }
            }

            //3. 불과 지훈이 각각 한 번씩 움직였으니, 시간 ++
            time++;
        }

        return -1;
    }
}