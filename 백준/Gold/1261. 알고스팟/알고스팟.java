import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int M, N;
    static int[][] arr;
    static int[][] dir = { {1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;

    // 자기 자신과 비교 vs 다른 객체끼리 비교
        // Comparable vs Comparator
        // compareTo() vs compare()
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt ; // 부순 벽의 수

        public Node(int x,int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 열
        M = Integer.parseInt(st.nextToken());   // 행

        //입력
        arr = new int [M][N];
        visit = new boolean[M][N];

        for(int i = 0; i< M; i++){
            String tmp = br.readLine();
            for(int j = 0; j< N; j++){
                arr[i][j] = tmp.charAt(j)- '0';
            }
        }

        BFS(0,0);
    }

    static void BFS(int sx ,int sy){

        //벽 부순 개수를 오름차순 정렬 -> 제일 작은 벽 부순 수로 탐색
        PriorityQueue<Node> pq = new PriorityQueue<>();

        visit[sx][sy] = true;
        pq.add(new Node( sx,sy,0));

        while(!pq.isEmpty()){

            Node curNode = pq.poll();

            if( curNode.x == M -1 && curNode.y == N -1){
                System.out.println( curNode.cnt );
                return;
            }

            for(int i= 0; i<4; i++){
                int nx = curNode.x + dir[i][0];
                int ny = curNode.y + dir[i][1];

                if( nx <0 || ny<0 || nx >= M || ny >= N) continue;

                if( visit[nx][ny]) continue;

                // 벽이 없다면
                if( arr[nx][ny] == 0){

                    pq.add( new Node(nx,ny, curNode.cnt));
                }
                //벽이 있다면
                else if ( arr[nx][ny] == 1){
                    pq.add( new Node(nx,ny,curNode.cnt+1));
                }

                visit[nx][ny] = true;
            }
        }
    }

}