import java.io.*;
import java.util.*;

//BFS()
    // 불이 한 번 움직이고, 지훈이가 한 번 움직일 때
public class Main {
    static class Pos{
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static char[][] adj;

    static Queue<Pos> jihunQ = new LinkedList<>();
    static Queue<Pos> fireQ = new LinkedList<>();

    static boolean[][] jihun_Visited;
    static boolean[][] fire_Visited;

    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new char[N][M];
        jihun_Visited = new boolean[N][M];
        fire_Visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();

            for(int j=0; j<M; j++) {
                char c = str.charAt(j);

                if( c == 'J') {
                    adj[i][j] = '.';
                    jihunQ.add(new Pos(i, j));
                    jihun_Visited[i][j] = true;
                }

                else if( c == 'F'){
                    fireQ.add(new Pos(i, j));
                    fire_Visited[i][j] = true;
                }
                
                adj[i][j] = c;
            }
        }

        BFS();

        System.out.println("IMPOSSIBLE");
    }

    private static void BFS() {

        int time = 0;

        // 지훈이가 더이상 갈 곳이 없을 때까지
        while(!jihunQ.isEmpty()) {
            int jihunLen = jihunQ.size();
            int fireLen = fireQ.size();

        //1. 불
            for(int i=0; i<fireLen; i++) {
                Pos fire = fireQ.poll();

                for(int j=0; j<4; j++) {
                    int nfx = fire.x + dir[j][0];
                    int nfy = fire.y + dir[j][1];

                    if(nfx <0 || nfx >= N || nfy <0 || nfy >=M) continue;
                    if(adj[nfx][nfy] == '#') continue;
                    if(fire_Visited[nfx][nfy]) continue;
                    
                    fireQ.add(new Pos(nfx, nfy));
                    fire_Visited[nfx][nfy] = true;
                    adj[nfx][nfy] = 'F';
                }
            }

        //2. 지훈
            for(int i=0; i<jihunLen; i++) {
                Pos jihun = jihunQ.poll();

                for(int j=0; j<4; j++) {
                    int njx = jihun.x + dir[j][0];
                    int njy = jihun.y + dir[j][1];
                    
                    // 종료 조건 - 지훈이가 외각에 도착하면 프로그램 종료
                    if(njx <0 || njx >= N || njy <0 || njy >=M){
                        time++;
                        System.out.println(time);

                        // 프로그램 종료
                            // 1. return; -> 일반 함수에서 사용 시, 일반함수만 종료
                            // 2. System.exit(0); -> 일반 함수에서 사용해도 main함수까지 전체 강제 종료
                        System.exit(0);
                    }

                    if(adj[njx][njy] !='.' ) continue;
                    if(jihun_Visited[njx][njy]) continue;

                    jihunQ.add(new Pos(njx, njy));
                    jihun_Visited[njx][njy] = true;
                }
            }
            
        //3.불과 지훈이 각각 한 번씩 움직였다면, 시간 ++ 
            time++;
            
        } // end while
    }
}