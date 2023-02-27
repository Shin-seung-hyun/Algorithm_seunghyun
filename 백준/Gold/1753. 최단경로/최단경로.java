import java.util.*;

//최단거리 -Dijkstra 알고리즘
public class Main{
    static class Edge{
        int to;
        int weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static int V;   //정점의 수
    static int E;   //간선의 수
    static int dist[];  //최소 이동거리를 저장하는 배열
    static ArrayList<Edge> []edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        int start = sc.nextInt();

        dist = new int[V+1];
        edges = new ArrayList[V+1];
        for(int i =1; i<=V; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i =1; i<=E; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            edges[from].add(new Edge(to, weight));
        }

        Dijkstra(start);

        for(int i =1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void Dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)-> o1.weight - o2.weight);

        //dist 배열 초기화
        for(int i =1; i<=V; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //시작점 넣기
        pq.add(new Edge(start, 0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            //가치가 있는 것인지 확인
            if(dist[e.to] < e.weight) continue;

            //정점 업데이트
            for(Edge updateEdge : edges[e.to]){

                if(dist[e.to] + updateEdge.weight >= dist[updateEdge.to]) continue;

                dist[updateEdge.to] = updateEdge.weight + dist[e.to] ;
                pq.add(new Edge(updateEdge.to, dist[updateEdge.to]));
            }
        }

    }
}