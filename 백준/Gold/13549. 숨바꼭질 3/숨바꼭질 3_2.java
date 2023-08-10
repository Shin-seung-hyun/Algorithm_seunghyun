import java.util.*;
import java.io.*;

// BFS
// 특정 정점을 방문 시
    // 1. 방문한 적이 없는 경우, 방문 처리
    // 2. 이미 방문한 적이 있지만 이전방문(time) 보다 지금(time+1)이 더 작으면, 다시 방문 처리
public class Main{

    static int[] dist;
    static class Vertex{
        int v;
        int time;

        public Vertex(int v, int time){
            this.v = v;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken());   // 동생의 위치

        dist = new int [100_000 + 1];
        Arrays.fill(dist, -1);

        BFS(N);

        System.out.println(dist[K]);
    }

    static void BFS(int start){
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(new Vertex(start,0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Vertex now  = queue.poll();
            int v = now.v;
            int t = now.time;

            // +1 경우
            if(v + 1 <= 100_000 ){
                if( dist[v+1] == -1 || dist[v+1] > t+1 ) {
                    queue.add(new Vertex(v + 1, t + 1));
                    dist[v + 1] = t + 1;
                }
            }

            // -1 경우
            if( v -1 >=0){
                if(dist[v-1] == -1 || dist[v-1] > t +1) {
                    queue.add(new Vertex(v - 1, t + 1));
                    dist[v - 1] = t + 1;
                }
            }

            // *2 경우
            if( 2 * v <= 100_000){
                if(dist[2 *v ] == -1 || dist[2*v] > t){
                    queue.add(new Vertex(2 * v, t));
                    dist[2 * v] = t;
                }
            }

        }// end while
    }// end BFS

}
