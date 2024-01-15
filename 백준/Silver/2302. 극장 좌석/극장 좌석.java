import java.util.*;
import java.io.*;

/*
    DP
*/
class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    //좌석 수
        int M = Integer.parseInt(br.readLine());    //고정석
        
        int [] dy = new int[40 +1];

        //가짜식 dy[i] : 극장 자리가 i개 일때의 좌석 이용 방법 수
        //초기화
        dy[0] = 1;
        dy[1] = 1;
        dy[2] = 2;

        //점화식
        for(int i=3; i<= N; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }

    //정답 구하기
        //[방법1]
//        int answer = dy[N];
//
//        if( M >= 1 ) {
//            int pre = Integer.parseInt(br.readLine());
//            answer = dy[pre - 1];
//
//            if (M >= 2) {
//                for (int i = 2; i <= M; i++) {
//                    int num = Integer.parseInt(br.readLine());
//
//                    answer *= dy[num - pre - 1];
//
//                    pre = num;
//                }
//            }
//
//            if ( pre < N)
//                answer *= dy[N - pre];
//        }
        
        //[방법2]
        int answer = 1;
        int pre = 0;
        for(int i=0; i<M; i++){
            int n = Integer.parseInt(br.readLine());
            
            answer *= dy[n - pre -1];
            pre = n;
        }
        answer *= dy[N-pre];

        System.out.println(answer);
    }
}