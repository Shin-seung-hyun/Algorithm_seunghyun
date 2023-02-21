import java.util.*;

//그래프와 DFS, BFS
    //DFS
class Main{
    static int w;           //지도의 너비
    static int h;           //지도의 높이
    static boolean visit[][]; //방문여부
    static int [][] arr;    //지도 배열
    static int answer =0;   //섬의 개수
    static int dir[][] = {{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1},{0,-1},{0,1}}; //가로, 세로, 대각선 이동을 위한 임의의 배열

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        while(true){
            w = sc.nextInt();
            h = sc.nextInt();

            if(w ==0 && h ==0) break;

            visit = new boolean[h+1][w+1];
            arr = new int[h+1][w+1];

            for(int i=1; i<=h; i++){
                for(int j =1; j<=w; j++){

                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i=1; i<=h; i++){
                for(int j =1; j<=w; j++){
                    if(visit[i][j]) continue;
                    if(arr[i][j] == 0) continue;

                    DFS(i,j);
                    answer = answer+1;
                }
            }

            //출력
            System.out.println(answer);

            //초기화
            answer =0;
        }
    }

    static void DFS(int x, int y){

        //(x,y) 방문
        visit[x][y] = true;

        //(x,y)가 갈 수 있는 곳 모두 가기
        for(int i =0; i<8; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx <=0 || ny <=0 || nx >h || ny >w) continue;
            if(visit[nx][ny]) continue;
            if(arr[nx][ny] == 0) continue;

            DFS(nx,ny);
        }

    }
}