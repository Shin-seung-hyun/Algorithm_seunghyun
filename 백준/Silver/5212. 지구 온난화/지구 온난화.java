import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[][] arr;
    static boolean[][] visit;
    static int R,C;
    static int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
    static int maxR=0, maxC=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());  // 행
        C = Integer.parseInt(st.nextToken());   // 열

    //입력
        visit = new boolean[R][C];
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

    //계산
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if(arr[i][j] == 'X') check(i, j);


    //출력
        for(int i = minR; i<= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void check(int x, int y){

        int cnt = 0;

        for(int i =0; i<4; i++){

            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if( nx < 0 || ny <0 || nx >=R || ny >=C){
                cnt++;
                continue;
            }
            if( !visit[nx][ny] && arr[nx][ny] == '.'){
                cnt++;
            }

        }

        if(cnt >=3) {
            arr[x][y] = '.';
            visit[x][y] = true;
        }
        else{

            //X표시가 된 위치 중 가장 작은, 가장 큰 위치값 저장
            minR = Math.min(minR,x);
            minC = Math.min(minC,y);
            maxR = Math.max(maxR,x);
            maxC = Math.max(maxC,y);
        }
    }
}