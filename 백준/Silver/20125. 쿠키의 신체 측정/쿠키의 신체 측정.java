import java.io.*;
import java.util.*;

// 쿠키의 신체가 주어졌을 때 심장의 위치와 팔, 다리, 허리의 길이를 구하여라.
class Main{

    static int N;   // 한 변의 길이
    static int heartX = 0, heartY = 0;  // 심장의 위치
    static String [][]arr;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new String [N+1][N+1];
        for(int i =1; i<=N; i++){
            String str = br.readLine();

            for(int j =1; j<=N; j++){
                arr[i][j] = String.valueOf(str.charAt(j-1));
            }
        }

        // 심장 찾기
        Loop1 :
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N ;j++){

                if( arr[i][j].equals("_")) continue;
                if( findHeart(i,j) ) break Loop1;
            }
        }
        sb.append(heartX + " " + heartY + "\n");

        //왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이
        int leftArm = findLength(heartX, heartY, 0,-1);
        int rightArm = findLength(heartX, heartY, 0, 1);
        int waist = findLength(heartX, heartY, 1,0);
        int leftLeg = findLength(heartX + waist + 1,heartY -1, 1,0);
        int rightLeg = findLength(heartX + waist + 1, heartY +1, 1,0);

        sb.append(leftArm + " " + rightArm + " " + waist + " " + (leftLeg+1) + " " + (rightLeg+1));

        System.out.print(sb.toString());
    }

    static int findLength(int startX, int startY, int addX, int addY ){

        int cnt = 0;
        int nx = startX, ny=startY;
        while(true){
            nx += addX;
            ny += addY;

            if( nx <=0 || ny <=0 || nx >N || ny>N) break;
            if( arr[nx][ny].equals("_")) break;
            cnt++;
        }

        return cnt;
    }

    static boolean findHeart(int x, int y){

        for(int i = 0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if( nx <=0 || ny <=0 || nx > N || ny>N ) return false;
            if( arr[nx][ny].equals("_")) return false;
        }

        heartX = x;
        heartY = y;

        return true;
    }

}