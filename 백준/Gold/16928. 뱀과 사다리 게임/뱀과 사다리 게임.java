import java.io.*;
import java.util.*;


//100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값
public class Main {
    static int[] board;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        board = new int[100 + 1];
        visit = new int[100 + 1];
        for (int i = 1; i < board.length; i++) board[i] = i;

    //입력
        // 사다리 위치 입력 -> x에 도착하면 y로 이동
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        // 뱀 위치 입력 -> u에 도착하며 v로 이동
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u] = v;
        }

    //탐색
        int result = BFS(1);

    //출력
        System.out.println(result);
    }

    private static int BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visit[x] = 0;

        while (true) {
            int nx = queue.poll();

            for (int i = 1; i <= 6; i++) {

                if ( nx  + i > 100) continue;

                if (visit[ board[nx + i]] == 0) {
                    
                    visit[ board[nx + i]] = visit[nx] + 1;
                    queue.add(board[nx  + i]);
                }

                if (board[nx + i] == 100) return visit[100];

            }
        }

    }
}