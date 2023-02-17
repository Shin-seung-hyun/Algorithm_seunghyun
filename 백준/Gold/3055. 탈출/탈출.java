import java.util.*;

//그래프와 DFS, BFS
    //BFS의 부가 기능
class Main{
    static int N;
    static int M;
    static String []arr;    //격좌형 배열
    static boolean [][]visit;   //방문했는지 여부 확인
    static int [][]dist_water;  //물의 이동 배열
    static int [][]dist_go;     //고슴도치의 움직임 배열
    static int [][]dir ={{1,0}, {-1,0}, {0,1}, {0,-1}}; //상하좌우 이동을 위한 임의의 배열
    static int Dx, Dy;  //도착지 주소

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new String[N];
        visit = new boolean[N][M];
        dist_water = new int[N][M];
        dist_go = new int[N][M];

        //줄바꿈 제거
        sc.nextLine();

        for(int i =0; i<N; i++){
            arr[i] = sc.nextLine();
        }

        //물의 이동 BFS -각 칸마다 물에 닿는 시간 계산
        BFS_water();

        //고슴도치의 이동 BFS -고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        BFS_go();

        //출력
        if(dist_go[Dx][Dy] ==-1) System.out.println("KAKTUS");
        else System.out.println(dist_go[Dx][Dy]);
    }

    static void BFS_water(){
        Queue<Integer> queue = new LinkedList<>();

        //물의 위치 찾기
            //모든 물의 위치 queue에 넣기
        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){

                //dist_water 초기화
                dist_water[i][j] =-1;

                if(arr[i].charAt(j) == '*'){
                    queue.add(i);
                    queue.add(j);
                    visit[i][j] = true;
                    dist_water[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                //격좌좌표가 범위 내에 있는지
                if(nx <0 || ny <0 || nx >=N || ny >=M) continue;

                //방문한 적이 있는지
                if(visit[nx][ny]) continue;

                //갈 수 있는 곳인지
                    //물은 . 제외하고는 못감
                if(arr[nx].charAt(ny) != '.') continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] +1;
            }
        }

    }

    static void BFS_go(){

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                //초기화
                visit[i][j] = false;
                dist_go[i][j] =-1;

                if (arr[i].charAt(j) == 'D') {
                    Dx = i;
                    Dy = j;
                }
                if (arr[i].charAt(j) == 'S') {
                    queue.add(i);
                    queue.add(j);
                    visit[i][j] = true;
                    dist_go[i][j] = 0;
                }
            }
        }


        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                //격좌좌표가 범위 내에 있는지
                if(nx <0 || ny <0 || nx >=N || ny >=M) continue;

                //방문한 적이 있는지
                if(visit[nx][ny]) continue;

                //갈 수 있는 곳인지
                    // .과 D를 제외하고는 다 못감
                if(arr[nx].charAt(ny) != '.' && arr[nx].charAt(ny) !='D') continue;

                //water의 영향을 받지 않는지***
                    //물의 영향을 받지 않는 dist_water[nx][ny] != -1 곳은 가도 됨
                if( dist_water[nx][ny] != -1 && dist_go[x][y]+1 >= dist_water[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist_go[nx][ny] = dist_go[x][y] +1;
            }
        }
    }
}