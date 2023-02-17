import java.util.*;

class Main{
    static int M;   // 가로 길이
    static int N;   // 세로 길이
    static int K;   // 배추의 개수
    static int [][]arr; // 배추의 좌표
    static boolean [][]visit;
    static int [][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int answer = 0;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i =0; i<T; i++){

            //answer 초기화
            answer = 0;

            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            arr = new int[M][N];
            visit = new boolean[M][N];

            for(int j = 0; j<K; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] =1;
            }

            for(int a =0 ; a<M; a++){
                for(int b =0; b<N; b++){
                   if(arr[a][b] == 1) BFS(a,b);
                }
            }

            System.out.println(K-answer);
        }
    }

    static void BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        //x,y 좌표 방문했어요
        queue.add(x);
        queue.add(y);
        visit[x][y] = true;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                //격좌형 범위 안에 있는지
                if(nx <0 || ny <0 || nx >=M || ny >= N) continue;

                //방문했었는지
                if(visit[nx][ny]) continue;

                //갈 수 있는지
                if(arr[nx][ny] == 0) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                answer +=1;

            }

        }

    }
}
