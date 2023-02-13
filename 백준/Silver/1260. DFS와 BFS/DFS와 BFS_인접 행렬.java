import java.util.*;

//그래프 DFS, BFS
    //양방향 그래프, 가중치 X
    //인접 행렬
public class Main{
    static int N;   //Vertex 정점의 개수
    static int M;   //Edge 간선의 수
    static int V;    //탐색할 정점의 시작 번호
    static int adj[][]; //인접 행렬
    static boolean [] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        //정점의 수만큼의 배열 크기
        adj = new int [N+1][N+1];

        visit = new boolean[N + 1];

        for(int i =0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            adj[x][y] = adj[y][x] = 1;
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
    }

    //깊이 우선 탐색
    static void DFS(int x){

        //x 방문
        visit[x] = true;
        sb.append(x).append(" ");

        //x에서 y로 갈 수 있는 것들 찾기 1
        for(int y =1; y<=N; y++){
            //x에서 y를 갈 수 없다면, 다른 거 찾기
            //adj[x][y] == 1이라면 x에서 y로 갈 수 있음
            if(adj[x][y] == 0) continue;

            //x에서 y로 갈 수 있지만 만약 갔던 곳이라면, 다시 가지 않기
            if(visit[y]) continue;

            //y에서 갈 수 있는 곳 확인
            DFS(y);
        }
/*
        //x에서 y로 갈 수 있는 것들 찾기 2
        for(int y =1; y<=N; y++){
            if(adj[x][y] ==1){
                if(visit[y]) continue;
                DFS(y);
            }
        }
*/
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

            //x에서 y로 갈 수 있는 것들 찾기1
            for(int y =1; y<=N; y++){
                if(adj[x][y] ==0) continue;
                if(visit[y]) continue; //x에서 y로 갈 수 있지만 만약 갔던 곳이라면, 다시 가지 않기

                //y는 갈 수 있으니 queue에 추가
                queue.add(y);
                visit[y] = true;
            }

/*
            //x에서 y로 갈 수 있는 것들 찾기2
            for(int y =1; y<=N; y++){
                if(adj[x][y] ==1) {
                    if (visit[y]) continue;

                    queue.add(y);
                    visit[y] = true;
                }
            }
*/
        }

    }

}