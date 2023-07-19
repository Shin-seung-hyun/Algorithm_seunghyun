import java.io.*;
import java.util.*;
//
public class Main {
    static int N;   // 식탁의 길이
    static int K;   // 선택할 범위
    static char[] table;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = br.readLine().toCharArray();
        visit = new boolean[N]; // 먹은 햄버거인지 확인

        int eatCnt = 0;
        for(int i=0; i<N; i++ ){

            if(table[i] == 'P') {

                // 먹을 수 있는 햄버거 범위 설정 -> 왼쪽을 최우선으로 먹기
                int startIdx = Math.max(i - K, 0); // i-k, i
                int endIdx = Math.min(i + K, N - 1); // i , i+k

                for (int j = startIdx; j <= endIdx; j++) {
                    if (table[j] == 'H' && !visit[j]) {
                        visit[j] = true;
                        eatCnt++;
                        break;
                    }
                }

            }
        }

        System.out.println(eatCnt);
    }
}