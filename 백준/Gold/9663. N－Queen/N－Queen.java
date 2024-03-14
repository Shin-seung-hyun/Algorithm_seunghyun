import java.io.*;
import java.util.*;

public class Main {
    static boolean[] bottom; // column을 차지하고 있는지
    static boolean[] left; // 왼쪽 /방향 대각선을 차지하고 있는지
    static boolean[] right; // 오른쪽 \방향 대각선을 차지하고 있는지
    static int cnt = 0;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        bottom = new boolean[40];
        left = new boolean[40];
        right = new boolean[40];

        DFS(0);

        System.out.println(cnt);
    }

    static void DFS(int depth) { // cur번째 row에 말을 배치할 예정임

        if (depth == N) { // N개를 놓는데 성공했다면
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) { // (depth, i)에 퀸을 놓을 예정

            /*
            좌표를 (x,y)라고 표현할 때
                왼쪽 대각선의 경우,  x + y 값이 모두 같다.
                오른쪽 대각선의 경우, x - y 값이 모두 같다.
                    단, 음수값을 피하기 위해  (x-y) + N을 해준다.
             */

            if (bottom[i] || left[i + depth] || right[depth - i + N] )
                continue;

            bottom[i] = true;
            left[i + depth] = true;
            right[depth - i + N] = true;

            DFS(depth + 1);

            bottom[i] = false;
            left[i + depth] = false;
            right[depth - i + N]= false;
        }
    }
}