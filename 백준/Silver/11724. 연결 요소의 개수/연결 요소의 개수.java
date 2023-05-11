import java.util.*;

class Main{
    static int N;   // 정점의 수
    static int M;   // 간선의 수
    static ArrayList<Integer> [] adj;
    static boolean []visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        adj = new ArrayList[N+1];
        visit = new boolean[N+1];

        for(int i =1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i =1; i<=M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }

        int cnt = 0;
        for(int i =1; i<=N; i++){

            if(visit[i]) continue;
            BFS(i);
            cnt++;
        }

        System.out.println(cnt);
    }

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int val : adj[x]){

                if(visit[val]) continue;

                visit[val] = true;
                queue.add(val);
            }
        }
    }
}