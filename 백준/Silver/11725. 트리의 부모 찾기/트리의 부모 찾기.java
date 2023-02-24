import java.util.*;
import java.io.*;

//그래프와 DFS, BFS
    // 인접 리스트
class Main{

    static int N;   //노도의 수
    static ArrayList<Integer> adj[];
    static boolean visit[];
    static int []parent;    //부모를 저장하는 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];
        parent = new int[N+1];

        for(int i = 1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }


        for(int i =1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        BFS(1);

        //출력
        for(int i=2; i<=N; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int x  = queue.poll();

            for(int vertex : adj[x]){

                if(visit[vertex]) continue;

                queue.add(vertex);
                parent[vertex] = x;
                visit[vertex] = true;
            }
        }
    }

}