import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=1; i<=3; i++) {
            st = new StringTokenizer(br.readLine());

            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");

            // 시간을 초로 바꾸기
            int s = Integer.parseInt(start[0]) * 3600 + // 시 ->초
                    Integer.parseInt(start[1]) * 60 +   // 분 ->초
                    Integer.parseInt(start[2]);         // 초

            int e = Integer.parseInt(end[0]) * 3600 +
                    Integer.parseInt(end[1]) * 60 +
                    Integer.parseInt(end[2]);

            //하루가 지났을 때
            if( s > e){
                e  = e + 24 * 3600;
            }

            //3으로 나눠지는지 갯수 세기
            int cnt = 0;
            for(int j = s; j<= e; j++){

                if( ( (j/3600) * 1000 + (j%3600)/60 * 100 + (j%3600)%60 ) % 3 ==0 ) cnt++;
            }

            sb.append(cnt +"\n");
        }

        System.out.print(sb.toString());
    }

}