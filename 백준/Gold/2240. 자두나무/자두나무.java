import java.util.*;
import java.io.*;

class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());   // 자두 T초간 떨어짐
        int W = Integer.parseInt(st.nextToken());   // 움직이는 횟수

        int [][][]dy = new int [1_000 + 1][3][30+1]; // 초 (1-1000),나무번호(1-2),이동횟수(0-30)

        int [] arr= new int[T+1];
        for(int i=1; i<=T; i++) arr[i] = Integer.parseInt(br.readLine());


        //가짜식 Dy[i][j][k] : i:현재시간, j:현재 나무 번호, k:이동 횟수
        //초기화
        //점화식
        for(int i=1; i<=T; i++){

            //0번 이동하는 경우 : 1나무에서 시작함으로 2 나무로 가지 않음.
            int addValue;
            if( arr[i] == 1) addValue = 1;
            else addValue = 0;

            dy[i][1][0] = dy[i-1][1][0] + addValue;

            // 1 ~ W번 이동하는 경우
            for(int k =1; k<=W; k++) {

                //현재보다 더 많이 이동할 수 없다. ex) 현재시간 T=4, 이동횟수 W = 10
                if( i< k) break;

                if(arr[i] == 1){

                    // 1번 나무 = max(1->1번 나무 이동, 2->1번 나무 이동) + 1 (arr[i]==1)
                    dy[i][1][k] = Math.max( dy[i-1][1][k] +1, dy[i-1][2][k-1]+1);

                    // 2번 나무 = 2->2번 나무의 현재 값
                    //dy[i][2][k] = Math.max( dy[i-1][2][k], dy[i-1][1][k-1]);
                    dy[i][2][k] = dy[i-1][2][k];
                }

                else{ // arr[i] == 2일 때

                    // 2번 나무 = max( 1->2번 나무, 2->2번 나무 이동) + 1 (arr[i]==2)
                    dy[i][2][k] = Math.max( dy[i-1][1][k-1] +1, dy[i-1][2][k] +1);

                    //1번 나무 = 1->1번 나무의 현재 값
                    //dy[i][1][k] = Math.max( dy[i-1][1][k], dy[i-1][2][k-1]);
                    dy[i][1][k] = dy[i-1][1][k];
                }

            }
        }

        int answer =0;
        // 0번 움직일 때 ~ 최대 W번 움직일 때
        for(int k=0; k<=W; k++){

            answer = Math.max(dy[T][1][k],dy[T][2][k]);
        }
        System.out.println(answer);

    }
}