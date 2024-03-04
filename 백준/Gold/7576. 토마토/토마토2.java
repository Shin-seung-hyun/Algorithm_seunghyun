import java.util.*;
import java.io.*;

//그래프와 DFS, BFS
//BFS의 부가기능 - 토마토가 다 익는 최소 일수
class Main{
    static int N;   // 세로
    static int M;   // 가로
    static int[][] arr;     // 토마토 배열
    static int [][]dist;    // 날짜 계산 배열

    // 오른쪽 왼쪽 앞 뒤 이동을 의미하는 임의의 배열
    static int [][]dir = { {0,-1},{0,1},{-1,0},{1,0} };
    static int total_Tomato = 0;
    static int fill_Tomato = 0;

    //1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 없는 칸
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        arr = new int [N+1][M+1];

        for(int i =1; i<=N; i++){
            for(int k =1; k<=M; k++){

                arr[i][k] = sc.nextInt();

                if(arr[i][k] != -1 ) total_Tomato++;
                if(arr[i][k] == 1) fill_Tomato++;
            }
        }

        if(total_Tomato == fill_Tomato){
            System.out.println(0);
            return;
        }

        dist = new int[N+1][M+1];

        // 토마토 탐색
        BFS();

    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();

        //dist 배열 초기화 + 익은 토마토의 위치 모두 넣기
        for(int i =1; i<=N; i++){
            for(int j =1; j<=M; j++){
                dist[i][j] = -1;

                if(arr[i][j] == 1){
                    queue.add(i);
                    queue.add(j);

                    dist[i][j] = 0;
                }
            }
        }


        // queue 가 빌 때까지 탐색
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                // 범위에서 벗어나지 않고
                if(nx <=0 || ny <=0 || nx >N || ny >M) continue;

                if(arr[nx][ny] == -1) continue;

                // 방문하지 않았던 곳
                if(dist[nx][ny] != -1) continue;

                queue.add(nx);
                queue.add(ny);

                dist[nx][ny] = dist[x][y] + 1;
            }

        }

        int answer =0;
        for(int i =1; i<=N; i++){
            for(int j =1; j<=M; j++){

                // 토마토가 비어 있으면 패스
                if(arr[i][j] == -1) continue;

                if(dist[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, dist[i][j]);
            }
        }

        System.out.println(answer);
    }

}