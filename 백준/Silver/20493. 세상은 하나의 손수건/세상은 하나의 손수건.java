import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int cR, cC, idx, curTime, totalTime;
    
    //오른쪽으로 90도 씩 이동
    static int[][] dir = { {1,0}, { 0,-1}, {-1,0},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());  // 방향을 바꾼 횟수
        int T = Integer.parseInt(st.nextToken());   // 걸어간 시간

        //입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            totalTime = Integer.parseInt(st.nextToken());

            curTime = totalTime - curTime;

            cR += dir[idx][0] * curTime;
            cC += dir[idx][1] * curTime;

            String s = st.nextToken();

            if( s.equals("right")) idx = (idx +1 ) % 4;
            else idx = ( idx + 3 ) % 4;

            curTime = totalTime;
        }

        
        curTime = T- totalTime;
        cR += dir[idx][0] * curTime;
        cC += dir[idx][1] * curTime;

        System.out.println(cR + " " + cC);

    }
}