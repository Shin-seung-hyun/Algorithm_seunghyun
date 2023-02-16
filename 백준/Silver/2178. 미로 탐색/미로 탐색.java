import java.util.*;
import java.io.*;

class Main{
    static int N;       //가로
    static int M;       //세로
    static String []arr;        //격좌형 배열
    static boolean visit[][];   //방문했는지 여부
    static int [][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};// 상하좌우 탐색을 위한 임의의 배열
    static int [][]dist;        //최단 칸수 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        //줄바꿈 제거
        sc.nextLine();

        arr= new String[N];
        visit = new boolean[N][M];
        dist = new int[N][M];

        for(int i =0; i<N; i++){
            arr[i] = sc.nextLine();
        }

        //BFS 시작 좌표에서 시작
        BFS(0,0);

        //출력
        System.out.println(dist[N-1][M-1]);
    }

    static void BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        //dist 배열 초기화
        for(int i =0; i<N; i++){
            for(int j = 0; j<M; j++){
                dist[i][j] = -1;
            }
        }

        //(0,0)에서 출발
        queue.add(x);
        queue.add(y);
        dist[x][y] =1;  //칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
        visit[x][y] = true;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            //갈 수 있는 곳 탐색
            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                // 격좌 범위 안에 있는가?
                if(nx <0 || ny < 0 || nx >=N || ny >=M) continue;

                //방문한 적이 있는가
                if(visit[nx][ny]) continue;

                //갈 수 있는가
                if(arr[nx].charAt(ny) == '0') continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] +1;
            }
        }
    }

}