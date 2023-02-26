import java.util.*;

//그래프와 DFS, BFS
    //BFS의 부가기능 - 토마토가 다 익는 최소 일수
public class Main{

    static int M;   //가로
    static int N;   //세로
    static int H;   //높이
    static int [][][]dist;  //거리를 계산하는 배열
    static int [][][]arr;   //토마토 3차원 배열

    //상하좌우앞뒤를 이동을 의미하는 임의의 배열
    static int [][]dir ={
            //상하좌우
            {0,0,-1},{0,1,0},{0,0,1},{0,-1,0},

            //앞뒤
            {1,0,0},{-1,0,0}
    };

    //1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 없는 칸
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        arr = new int [H+1][N+1][M+1];  //높이 세로 가로
        for(int i =1; i<=H; i++){
            for(int j =1; j<=N; j++){
                for(int k =1; k<=M; k++){
                    arr[i][j][k] = sc.nextInt();
                }
            }
        }

        dist = new int[H+1][N+1][M+1];

        //BFS 탐색
        BFS();

        //정답  출력
        int answer = 0;
        for(int i =1; i<=H; i++){
            for(int j =1; j<=N; j++){
                for(int k =1; k<=M; k++){

                    //토마토가 비어있으면 패스
                    if(arr[i][j][k] ==-1) continue;

                    if(dist[i][j][k] ==-1) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, dist[i][j][k]);
                }
            }
        }

        System.out.println(answer);
    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();

        //dist 배열 초기화 + 익은 토마토의 위치 모두 넣기
        for(int i =1; i<=H; i++){
            for(int j =1; j<=N; j++){
                for(int k =1; k<=M; k++){
                    dist[i][j][k] = -1;

                    if(arr[i][j][k] ==1) {

                        queue.add(i);
                        queue.add(j);
                        queue.add(k);

                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while(!queue.isEmpty()){

            int z = queue.poll();
            int x = queue.poll();
            int y = queue.poll();

            for(int l=0; l<6; l++){
                int nz = z + dir[l][0];
                int nx = x + dir[l][1];
                int ny = y + dir[l][2];

                //범위에서 벗어나지 않고
                if(nx <0 || ny <0 || nz <0 || nx >N || ny >M || nz >H) continue;

                //방문 하지 않은 곳이고
                if(dist[nz][nx][ny] != -1) continue;

                // 토마토가 들어있을 때
                if(arr[nz][nx][ny] == -1) continue;

                queue.add(nz);
                queue.add(nx);
                queue.add(ny);

                dist[nz][nx][ny] = dist[z][x][y] +1;
            }

        }

    }
}