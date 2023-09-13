import java.io.*;
import java.util.*;

public class Main {
    static int A,B,C,D,E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(br.readLine());    // 초기 온도
        B = Integer.parseInt(br.readLine());    // 목표 온도
        C = Integer.parseInt(br.readLine());    // 언 고기 1도 올리는 데 걸리는 시간
        D = Integer.parseInt(br.readLine());    // 언 고기 해동하는데 걸리는 시간
        E = Integer.parseInt(br.readLine());    // 얼지 x고기 1도 데우는 데 걸리는 시간

        int sum = 0;

        if( A > 0){
            sum += (B-A) * E;
        }
        else{ 
            // 0도로 올리는 시간 + 해동 시간 + 목표 온도까지 걸리는 시간
            sum += Math.abs(A) * C  + D + B * E;
        }
        System.out.println(sum);
    }
}