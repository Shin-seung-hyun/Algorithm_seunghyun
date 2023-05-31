import java.util.*;
import java.io.*;

// 이분 탐색 + BFS  O(NlogC)
// 한 번의 이동에서 옮길 수 있는 중량의 최댓값은?
    //1. 서로 같은 두 섬 사이에 여러 개의 다리가 있을 수 있다.
    //2. 공장이 있는 두 섬을 연결하는 경로는 항상 존재한다.
// BFS 만으로 중량의 최댓값을 구하는 것은 가능하지만, 시간 초과가 발생한다. O(N * M)
public class Main {
    static int N;   // 섬의 수 Vertex
    static int M;   // 연결된 수  Edge
    static ArrayList<Node>[] adj;
    static boolean []visit;
    static int start, end;
    static int min = Integer.MAX_VALUE; // 주어진 간선 중 최솟값
    static int max = Integer.MIN_VALUE; // 주어진 간선 중 최댓값

    static class Node{
        int vertex;
        int cost;

        public Node(int v, int cost){
            this.vertex = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for(int i =1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i =1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj[A].add(new Node(B, C));
            adj[B].add(new Node(A, C));

            //간선의 최댓값, 최솟값 구하기
            min = Math.min(min, C);
            max = Math.max(max, C);
        }

        //출발, 도착 노드 입력
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        //이분 탐색
        weightSearch();
    }

    static void weightSearch(){
        int left = min;
        int right = max;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            //도착 지점까지 mid의 중량으로 건널 수 있는지
            if(BFS(mid)) {
                left = mid + 1;
                result = mid;

            }
            else right = mid - 1;

        }

        System.out.println(result);
    }

    static boolean BFS(int mid){
        Queue<Integer> queue = new LinkedList<>();

        //초기화
        visit = new boolean[N+1];

        // 출발지 방문
        queue.add(start);
        visit[start] = true;

        // 큐가 빌 때까지
        while(!queue.isEmpty()){
            int x= queue.poll();

            if(x == end) return true;

            for(Node node : adj[x]){
                int nextNode = node.vertex;
                int cost = node.cost;

                if(visit[nextNode]) continue;
                if( cost < mid ) continue;

                visit[nextNode] = true;
                queue.add(nextNode);
            }

        }

        return false;
    }

}