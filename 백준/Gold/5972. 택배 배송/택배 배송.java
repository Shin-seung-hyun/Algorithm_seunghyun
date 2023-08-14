import java.io.*;
import java.util.*;

// 다익스트라 : 연결리스트 배열 +  우선순위 큐
public class Main {

    static int N,M;
    static ArrayList<Node>[] adj;

    static int[] dist;

    static class Node implements Comparable<Node>{
        int vertex;
        int cost;

        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o1){
            return this.cost - o1.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점의 수
        M = Integer.parseInt(st.nextToken());   // 간선의 수


        // 초기화
        adj = new ArrayList[N+1];
        for(int i =1; i<=N; i++) adj[i] = new ArrayList<Node>();

        dist = new int [N+1];
        Arrays.fill(dist, 50_000 * 1_000 + 1);

        for(int i= 1; i<= M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[x].add( new Node(y,c));
            adj[y].add( new Node(x,c));
        }

        dijkstra();

        System.out.println(dist[N]);
    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.cost - o2.cost);

        dist[1] = 0; // 시작점
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){

            Node cur = pq.poll();

            for(Node next : adj[cur.vertex]){

                if( dist[next.vertex] > dist[cur.vertex] + next.cost){

                    dist[next.vertex] = dist[cur.vertex] + next.cost;
                    pq.add( new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }

}
