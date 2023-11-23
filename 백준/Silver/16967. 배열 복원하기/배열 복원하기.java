import java.util.*;
import java.io.*;


class Main{

    static int H,W,X,Y;
    static int[][] arrA, arrB;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        arrA = new int [H][W];
        arrB = new int[H + X][W + Y];

        //입력
        for(int i =0; i< H + X; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j< W + Y; j++){
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //복원
        for(int i=0; i<H; i++){
            for(int j =0; j<W; j++) {

                //겹치는 부분
                if (i >= X && j >= Y)
                    arrA[i][j] = arrB[i][j] - arrA[i - X][j - Y];

                // 겹치는 않는 부분
                else
                    arrA[i][j] = arrB[i][j];
            }
        }

        //출력
        for(int i=0; i<H; i++){
            for(int val : arrA[i]) sb.append(val + " ");
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}