import java.util.*;

public class test{

    static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo( Edge o){
            return weight - o.weight;
        }
    }
    static int N;
    static int M;
    static int dist[];
    static ArrayList<Edge> []edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        edges = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i =1; i<=N; i++){
            edges[i] = new ArrayList<Edge>();
        }
        for(int i =1; i<=M; i++){
            int start = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            edges[start].add(new Edge(to, weight));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start){

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //dist 초기화
        for(int i=1; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //시작점 넣기
        pq.add(new Edge(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            //가치가 있는지 확인
            if(dist[edge.to] < edge.weight) continue;

            for(Edge e : edges[edge.to]){

                if( dist[e.to] <= e.weight +dist[edge.to] ) continue;

                dist[e.to] = dist[edge.to] + e.weight;
                pq.add(new Edge(e.to,dist[e.to]));
            }
        }
    }
}