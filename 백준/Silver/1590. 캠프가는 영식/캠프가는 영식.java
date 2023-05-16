import java.io.*;
import java.util.*;

//방법1. 전체 BF
    // 1. 버스의 모든 시간을 입력하여 정렬한다. -> 시간 복잡도가 O(NC) 임으로 BF 가 가능하다.

public class Main {

    static int N;   // 버스 종류
    static int T;   // 터미널 도착 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        ArrayList<Integer> busTime = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 버스의 모든 시간 입력
            for (int j = 1; j <= C; j++) {
                busTime.add(S);
                S = S + I;
            }
        }

        // 버스의 모든 시간 정렬
        Collections.sort(busTime);

        for(int time : busTime) {
            if (T <= time) {
                System.out.println(time - T);
                return;
            }
        }
        System.out.println(-1);
    }
}