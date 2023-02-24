import java.util.*;

//그래프와 DFS, BFS
    //인접 리스트
    //케빈 베이컨의 수가 가장 작은 사람을 구하기
class Main{
    static int N; //유저의 수
    static int M; //친구 관계의 수
    static int dist[];  //다른 지점에 도달하는 수
    static boolean visit[];   //방문 여부 확인
    static int answer[];
    static ArrayList<Integer> []adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        adj = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            adj[A].add(B);
            adj[B].add(A);
        }

        visit = new boolean[N+1];
        dist = new int[N+1];

        int min = Integer.MAX_VALUE;

        int arr[] = new int[N+1];
        for(int i =1; i<=N; i++){
            int sum = 0;

            BFS(i);

            for(int j =1; j<=N; j++){
                sum += dist[j];
            }
            arr[i] = sum;
            min = Math.min(min,sum);
        }

        for(int i =1; i<=N; i++) {
            if (arr[i] == min){
                System.out.println(i);
                break;
            }
        }
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        //dist 초기화
        for(int i =1; i<=N; i++){
            dist[i] = -1;
            visit[i] = false;
        }

        queue.add(start);
        dist[start] = 0;
        visit[start] = true;

        while(!queue.isEmpty()){
            start = queue.poll();

            for (int x : adj[start]){

                if(visit[x]) continue;

                visit[x] = true;
                dist[x] = dist[start] +1;
                queue.add(x);
            }

        }
    }

}