import java.io.*;
import java.util.*;

public class Main {
    static int[] board;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 사다리
        int M = Integer.parseInt(st.nextToken()); // 뱀
        
        board = new int[100 + 1];
        visit = new int[100 + 1];
        for (int i = 1; i < board.length; i++) {
            board[i] = i;
        }

        //입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }


        int result = BFS(1);
        
        System.out.println(result);
    }

    private static int BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(x);
        visit[x] = 0;

        while (true) {
            int visitedNum = queue.poll();
            
            for (int i = 1; i < 7; i++) {
                int newNode = visitedNum + i;

                if (newNode > 100) continue;
                
                if (visit[board[newNode]] == 0) {
                    queue.add(board[newNode]);
                    visit[board[newNode]] = visit[visitedNum] + 1;
                }
                
                if (board[newNode] == 100) return visit[100];
                
            }
        }

    }
}