import java.util.*;

//그래프와 DFS, BFS
    //BFS의 부가기능 distance - 최소이동 횟수, 최단거리
    //visit의 기능을 dist가 대신할 수 있다.
class Main{

    static int chess;           //체스판의 크기
    //static boolean visit[][];   //방문 여부 확인
    static int [][]arr;     //체스판 배열
    static int startX, startY, destX, destY;    //출발지, 도착지 x,y좌표

    //나이트가 이동 계산을 위한 임의의 배열
    static int dir[][] ={
            {-2,-1},{-1,-2},{1,-2},{2,-1},
            {2,1},{1,2},{-1,2},{-2,1}
    };
    static int dist[][];  //최단거리를 계산할 distance 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i =0; i<testCase; i++){

            chess = sc.nextInt();

            arr = new int[chess][chess];
            //visit = new boolean[chess][chess];
            dist = new int[chess][chess];

            //dist 초기화
            for(int j =0; j<chess; j++){
                for(int k = 0; k<chess; k++){
                    dist[j][k] = -1;
                }
            }

            startX = sc.nextInt();
            startY = sc.nextInt();

            BFS(startX,startY);

            destX = sc.nextInt();
            destY = sc.nextInt();

            System.out.println(dist[destX][destY]);
        }
    }

    static void BFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();

        //x,y 좌표 방문
        queue.add(x);
        queue.add(y);
        //visit[x][y] = true;
        dist[x][y] = 0;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for(int i =0; i<8; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx<0 || ny <0 || nx >=chess || ny >= chess) continue;
                //if(visit[nx][ny]) continue;
                if(dist[nx][ny] != -1) continue;

                //visit[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y]+1;
            }
        }
    }

}
