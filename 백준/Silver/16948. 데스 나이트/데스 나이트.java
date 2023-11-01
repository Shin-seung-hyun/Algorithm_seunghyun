import java.io.*;
import java.util.*;


public class Main {
    static boolean[][] visit;
    static int N;
    static int r1,c1,r2, c2;
    static int[][] dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};

    static class Node{
        int x;
        int y;
        int cnt ;

        public Node(int x ,int y, int cnt ){
            this.x =x;
            this.y =y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visit = new boolean[N][N];

        st = new StringTokenizer(br.readLine());

        //출발지 위치
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        //도착지 위치
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        BFS(r1, c1);
    }

    static void BFS( int x, int y){
        Queue<Node> queue = new LinkedList<>();

        visit[x][y] = true;
        queue.add(new Node( x, y, 0));

        while(!queue.isEmpty()){

            Node node = queue.poll();

            if( node.x == r2 && node.y == c2){
                System.out.println(node.cnt);
                return;
            }

            for(int i=0; i<6; i++){
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if( nx < 0 || ny <0 || nx >=N || ny >=N) continue;
                if( visit[nx][ny]) continue;

                queue.add(new Node(nx,ny, node.cnt+1));
                visit[nx][ny] = true;
            }
        }

        System.out.println(-1);
    }

}