import java.io.*;
import java.util.*;

//다익스트라 알고리즘 (856ms)
    // 학생 한명당 다익스트라 2번씩 실행
public class Main {
    static int N,M,X;
    static ArrayList<Node> [] arrList;
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
        for(int i=1; i<=N; i++) arrList[i] = new ArrayList<>();


        //입력
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrList[x].add(new Node(y,c));
        }

        //다익스트라 탐색
        int maxDist = 0;
        for(int i=1; i<=N; i++) {

            if(i == X) continue;

            int goResult = dijkstra(i, X);      // 시작점 -> X 까지 최단거리
            int backResult = dijkstra(X, i);    // X -> 시작점 까지 최단거리

            maxDist = Math.max(maxDist, goResult + backResult);
        }

        System.out.println(maxDist);
    }

    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.c - o2.c );

        // 초기화
        boolean[] visit = new boolean[N+1];
        int [] dist = new int[N+1];
        Arrays.fill( dist, Integer.MAX_VALUE);

        // X 방문
        dist[start] =0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int num = cur.y;

            if( visit[num]) continue;

            visit[num] = true;
            for(Node n : arrList[num] ){

                if( !visit[n.y] && ( dist[n.y] > dist[num] + n.c) ){

                    dist[n.y] = dist[num] + n.c;
                    pq.add( new Node( n.y,dist[n.y]));
                }
            }
        }

        return dist[end];
    }

}