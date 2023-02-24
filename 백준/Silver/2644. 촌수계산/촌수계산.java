import java.util.*;

//그래프와 DFS, BFS
    //인접 리스트
class Main{

    static int num1, num2;  //촌수를 계산해야 하는 두 사람의 번호
    static int dist[];   //거리 계산
    static ArrayList<Integer> arr[];    //인접 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        arr = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        dist = new int[N+1];
        //dist 배열 초기화
        for(int i = 0; i<=N; i++){
            dist[i] = -1;
        }

        int M = sc.nextInt();   //부모 자식들 간의 관계의 개수
        for(int i = 0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x].add(y);
            arr[y].add(x);
        }

        BFS(num1);

        System.out.println(dist[num2]);
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        dist[start] = 0;

        while(!queue.isEmpty()){
            start = queue.poll();

            for(int nx : arr[start]){

                if(dist[nx] != -1 )continue;

                queue.add(nx);
                dist[nx] = dist[start]+1;
            }
        }
    }
}