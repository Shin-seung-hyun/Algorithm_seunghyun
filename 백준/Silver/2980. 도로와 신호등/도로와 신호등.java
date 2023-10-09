import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());  // 신호등 수
        int L = Integer.parseInt(st.nextToken());   // 도로 길이

        int waitTime = 0;
        int curD =0;

        for(int num = 0; num <N; num++){

            st = new StringTokenizer(br.readLine());

            int D = Integer.parseInt(st.nextToken());   // 위치
            int red = Integer.parseInt(st.nextToken());     // 빨간불 지속 시간
            int green = Integer.parseInt(st.nextToken());   // 초록불 지속 시간

            waitTime += D - curD;

            curD  = D;

            int tmp = waitTime % ( red + green);

            if ( tmp < red) waitTime += red - tmp;

        }

        waitTime += L - curD;

        System.out.println(waitTime);
    }
}