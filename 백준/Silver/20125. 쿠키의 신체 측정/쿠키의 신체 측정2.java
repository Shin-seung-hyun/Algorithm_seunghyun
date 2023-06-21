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
        // 머리의 한칸 아래에 존재
        Loop1 :
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N ;j++){

                if( arr[i][j].equals("*")){
                    heartX = i+1;   //행
                    heartY = j;     //열
                    break Loop1;
                }
            }
        }
        sb.append(heartX + " " + heartY + "\n");

        //왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이
        int leftArm =0, rightArm = 0;
        int waist = 0, leftLeg = 0, rightLeg = 0;

        for(int i =1; i<=N; i++){

            if(arr[heartX][i].equals("*")){
                if( i< heartY) leftArm++;
                else if ( i > heartY) rightArm++;
            }

            if( arr[i][heartY].equals("*") && i > heartX ) waist++;
            if( arr[i][heartY-1].equals("*") && i > heartX) leftLeg++;
            if( arr[i][heartY+1].equals("*") && i > heartX) rightLeg++;
        }

        sb.append(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);

        System.out.print(sb.toString());
    }


}