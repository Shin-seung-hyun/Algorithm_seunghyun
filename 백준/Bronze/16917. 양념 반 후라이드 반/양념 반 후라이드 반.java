import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());   // 양념
        int B = Integer.parseInt(st.nextToken());   // 후라이드
        int C = Integer.parseInt(st.nextToken());   // 반반
        int x = Integer.parseInt(st.nextToken());   // 최소 양념 수
        int y = Integer.parseInt(st.nextToken());   // 최소 후리아드 수

        int sum = 0;
        if( A + B <= 2 * C) {       // 양념1 + 후라1, 반반2 값 비교
            sum = A * x + B * y;
        }
        else{                       //반반으로 많은 개수 확보할 것!

            if( x > y){
                sum = y * (2 * C);
                sum += Math.min( (x-y) * A, (x-y) * (2 * C) );
            }

            //  y < x
            else{
                sum = x * (2 * C);
                sum += Math.min( (y-x) * B, (y-x) * (2 * C) );
            }
        }

        System.out.println(sum);
    }

}