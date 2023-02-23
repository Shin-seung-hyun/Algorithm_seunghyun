import java.util.*;

class Main{
    static int R;   //행
    static int C;   //열
    static String []arr;    //입력 배열
    static boolean [][]visit;   //방문여부 확인
    static int [][]dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};//상하좌우 이동을 위한 임의의 배열
    static int sheep =0;
    static int total_sheep = 0;
    static int wolf = 0;
    static int total_wolf =0;

    //글자 '.' 빈 필드, 글자 '#'는 울타리, 'o'는 양, 'v'는 늑대
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        //줄바꿈 제거
        sc.nextLine();

        arr = new String[R];
        for(int i =0; i<R; i++){
            arr[i] = sc.nextLine();
        }
        visit = new boolean[R][C];

        for(int i =0; i<R; i++){
            for(int j =0; j<C; j++){
                if(arr[i].charAt(j) !='#'&& !visit[i][j]){

                    //새롭게 갈 수 있는 단지의 경우 sheep, wolf 초기화
                    sheep =0;
                    wolf =0;

                    BFS(i,j);
                    if(sheep > wolf) total_sheep += sheep;
                    else total_wolf += wolf;
                }
            }
        }

        System.out.println(total_sheep + " " + total_wolf);
    }

    static void BFS(int x, int y){
        Queue<Integer>queue = new LinkedList<>();

        if(arr[x].charAt(y) == 'o') sheep++;
        if(arr[x].charAt(y) == 'v') wolf++;

        //(x,y) 방문
        queue.add(x);
        queue.add(y);
        visit[x][y] = true;

        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx <0 || ny <0 || nx >= R || ny >=C) continue;
                if(visit[nx][ny])continue;
                if(arr[nx].charAt(ny) =='#') continue;
                if(arr[nx].charAt(ny) == 'o') sheep++;
                if(arr[nx].charAt(ny) == 'v') wolf++;

                visit[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);

            }
        }
    }

}