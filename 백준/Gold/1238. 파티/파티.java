import java.io.*;
import java.util.*;

//다익스트라 알고리즘 (216ms)
    // 모든 정점 -> 모든 정점에 대한 최단거리가 필요한 것이 아니라, 모든 정점-> X까지의 거리만 알면 된다.
    // 따라서 X를 시작점으로 다익스트라 수행 후, 입력을 반대로 받은 배열에서 X를 시작점으로 다익스트라 수행
    // -> 총 다익스트라 2회 수행
public class Main {
    static int N,M,X;
    static ArrayList<Node> [] arrList;
    static ArrayList<Node> [] reverse_arrList;
    static class Node{
        int y;
        int c;

        public Node(int y, int c){
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    // N 명의 학생
        M = Integer.parseInt(st.nextToken());    // M 개의 간선
        X = Integer.parseInt(st.nextToken());    // 도착지

        // 초기화
        arrList = new ArrayList[N+1];
        reverse_arrList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) arrList[i] = new ArrayList<>();
        for(int i=1; i<=N; i++) reverse_arrList[i] = new ArrayList<>();


        //입력
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrList[x].add(new Node(y,c));
            reverse_arrList[y].add(new Node(x,c));
        }

        //다익스트라 탐색
        int [] dist = dijkstra( arrList);   // X -> 시작점 까지 최단거리
        int [] reverse_dist = dijkstra( reverse_arrList); // 시작점 -> X 까지 최단거리

        //출력
        int maxDist = 0;
        for(int i =1; i<=N; i++){
            maxDist = Math.max(maxDist, dist[i] + reverse_dist[i]);
        }
        System.out.println(maxDist);

    }

    static int[] dijkstra(ArrayList<Node>[] list){
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.c - o2.c );

        // 초기화
        boolean[] visit = new boolean[N+1];
        int [] dist = new int[N+1];
        Arrays.fill( dist, Integer.MAX_VALUE);

        // X 방문
        dist[X] =0;
        pq.add(new Node(X,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int num = cur.y;

            if( visit[num]) continue;

            visit[num] = true;
            for(Node n : list[num] ){

                if( !visit[n.y] && ( dist[n.y] > dist[num] + n.c) ){

                    dist[n.y] = dist[num] + n.c;
                    pq.add( new Node( n.y,dist[n.y]));
                }
            }
        }

        return dist;
    }

}