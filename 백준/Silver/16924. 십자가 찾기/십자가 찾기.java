import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static char[][] arr;
    static boolean[][] visit;
    static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    static class Pos{
        int x;  // 행
        int y;  // 열
        int s;  // 십자기 크기

        public Pos(int x,int y, int s){
            this.x =x;
            this.y = y;
            this.s = s;
        }
    }

    static ArrayList<Pos> arrList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //입력
        arr = new char[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().toCharArray();
        }


        //십자가 수 카운트
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){

                if( arr[i][j] == '.')continue;

                move(i,j);
            }
        }


        //출력
        if(check()) {
            sb.append(arrList.size() + "\n");
            for (Pos p : arrList) {
                sb.append(p.x + " " + p.y + " " + p.s + "\n");
            }
        }
        else sb.append("-1");

        System.out.print(sb.toString());
    }

    //십자가로 격자판 만들 수 있는지 확인
    static boolean check(){

        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                if( arr[i][j] == '*' && !visit[i][j]) return false;


        return true;
    }

    static void move(int x, int y){

        int size = 1;

        loop :
        while(true){

            int check =0;
            for(int i=0; i<4; i++) {
                int nx = x + (dir[i][0] * size);
                int ny = y + (dir[i][1] * size);

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) break loop;

                if (arr[nx][ny] == '.') break loop;

                check++;
            }

            if( check == 4) {

                visit[x][y] = true;
                for(int i=0; i<4; i++){
                    visit[ x + (dir[i][0] * size)][y + (dir[i][1] * size)] = true;
                }

                size++;
            }
        }

        if(size > 1) arrList.add(new Pos(x + 1, y + 1, size-1));
    }


}