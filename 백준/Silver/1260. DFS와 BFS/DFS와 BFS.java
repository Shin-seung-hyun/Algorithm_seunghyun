import java.util.*;
import java.io.*;

//그래프 DFS, BFS
    //양방향 그래프, 가중치 X
    //인접 행렬
public class Main{

    static int N;   //Vertex 정점의 개수
    static int M;   //Edge 간선의 수
    static int V;    //탐색할 정점의 시작 번호
    static ArrayList<Integer> adj[]; //인접 행렬
    static boolean [] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];

        adj = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        //ArrayList 정렬
        for(int i =1; i<=N; i++){
            Collections.sort(adj[i]);
        }

        //DFS 탐색 알고리즘
        DFS(V);
        sb.append("\n");

        //visit 초기화
        for(int i =1; i<=N ;i++) visit[i] = false;

        //BFS 탐색 알고리즘
        BFS(V);

        //출력
        System.out.println(sb.toString());

        br.close();
    }

    //깊이 우선 탐색
    static void DFS(int x){

        //x 방문
        visit[x] = true;
        sb.append(x).append(" ");

        //x에서 갈 수 있는 것들 중 작은 번호부터 방문
        for(int y : adj[x]){

            //만약 갔던 곳이라면, 다시 가지 않기
            if(visit[y]) continue;

            //y에서 갈 수 있는 곳 확인
            DFS(y);
        }
    }

    //너비 우선 탐색
    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        //start는 방문 가능함으로 queue에 넣어줌
        queue.add(start);
        //방문했다고 표시!
        visit[start] = true;

        //확인할 게 없을 때까지
        while(!queue.isEmpty()){
            int x = queue.poll();

            sb.append(x).append(" ");
            for(int y : adj[x]){
                if(visit[y]) continue;

                //y는 갈 수 있으니 queue에 추가
                queue.add(y);
                visit[y] = true;
            }
        }

    }

}