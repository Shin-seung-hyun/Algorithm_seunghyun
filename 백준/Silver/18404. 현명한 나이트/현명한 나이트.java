import java.util.*;

//그래프와 DFS, BFS
    //BFS의 부가효과 - 최소 이동 수 구하기
class Main{

    static int N;   //N * N
    static int M;   //나이트의 수
    static int arr[][];     //체스판 배열
    static int dist[][];    //최소 이동거리를 저장하는 배열
    static StringBuilder sb = new StringBuilder();

    //나이트의 이동을 위한 임의의 배열
    static int [][]dir ={
            {-2,-1},{-2,1},{-1,-2},{-1,2},
            {2,1},{2,-1},{1,2},{1,-2}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int [N+1][N+1];
        dist = new int [N+1][N+1];
        //dist 초기화
        for(int i =1; i<=N; i++){
            for(int j =1; j<=N ;j++){
                dist[i][j] =-1;
            }
        }

        int knightX = sc.nextInt();
        int knightY = sc.nextInt();

        for(int i =0; i<M; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            BFS(knightX, knightY);

            sb.append(dist[A][B]).append(" ");
        }

        System.out.println(sb.toString());
    }

    static void BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);
        dist[x][y] = 0; //출발점

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for(int i = 0; i<8; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx <0 || ny <0 || nx > N || ny >N) continue;
                if(dist[nx][ny] != -1) continue;

                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y] +1;
            }
        }

    }
}