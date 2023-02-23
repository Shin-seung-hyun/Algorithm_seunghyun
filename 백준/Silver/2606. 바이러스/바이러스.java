import java.util.*;

//그래프와 DFS, BFS
    //인접 행렬
public class Main {

    static int N;   //컴퓨터 정점의 개수
    static int M;   //간선의 개수
    static ArrayList<Integer> adj[];
    static boolean visit[];
    static int cnt = 0; // 감염된 컴퓨터의 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        //인접 행렬 입력
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        visit = new boolean[N+1];

        //탐색
            //1에서 갈 수 있는 모든 곳 탐색
        BFS(1);

        System.out.println(cnt);
    }


    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        //방문
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            start = queue.poll();

            for(int vertex : adj[start]){

                if(visit[vertex]) continue;

                visit[vertex] = true;
                queue.add(vertex);
                cnt++;
            }
        }
    }

}