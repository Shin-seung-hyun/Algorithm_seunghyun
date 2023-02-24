import java.util.*;

//그래프와 DFS, BFS
    //
public class Main{
    static int N;   //동기 수
    static int M;   //리스트의 길이
    static int dist[];  // 정점에서의 거리를 나타내는 배열
    static ArrayList<Integer> []adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        adj = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i =1; i<=M; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        dist = new int[N+1];

        BFS(1);

        int cnt = 0;
        for(int i =1; i<=N; i++){
            if( dist[i] > 0 && dist[i] <=2) cnt++;
        }

        System.out.println(cnt);
    }

    static void BFS(int start){
        Queue<Integer> queue  = new LinkedList<>();

        //dist 배열 초기화
        for(int i =1; i<=N; i++) dist[i] = -1;

        queue.add(start);
        dist[start] =0;

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int vertex : adj[x]){

                if(dist[vertex] != -1) continue;

                queue.add(vertex);
                dist[vertex] = dist[x] +1;
            }
        }
    }

}