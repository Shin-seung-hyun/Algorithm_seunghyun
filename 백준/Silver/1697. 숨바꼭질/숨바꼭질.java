import java.util.*;

//그래프와 DFS, BFS
    //BFS의 부가기능
class Main{

    static int N;   //수빈의 위치
    static int K;   //동생의 위치
    static boolean []visit;   //방문했는지
    static int[] dist;        //최단 거리

    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

         N = sc.nextInt();
         K = sc.nextInt();

         visit = new boolean[100_000+1];
         dist = new int[100_000+1];

         //BFS 시작점 N
         BFS(N);

        System.out.println(dist[K]);
    }

    static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();

        //x 방문
        queue.add(x);
        visit[x] = true;
        dist[x] = 0;

        //갈 수 있는 곳 탐색
        while(!queue.isEmpty()){

            x = queue.poll();

            //수빈이가 -1 하는 경우
            if(x-1 >=0 && !visit[x-1]){
                queue.add(x-1);
                visit[x-1] = true;
                dist[x-1] = dist[x]+1;
            }
            
            //수빈이가 +1 하는 경우
            if(x+1 <=100_000 && !visit[x+1]){
                queue.add(x+1);
                visit[x+1] = true;
                dist[x+1] = dist[x]+1;
            }
            
            //수빈이가 *2 하는 경우
            if(x*2 <=100_000 && !visit[x*2]){
                queue.add(x*2);
                visit[x*2] = true;
                dist[x*2] = dist[x]+1;
            }
        }
    }
}