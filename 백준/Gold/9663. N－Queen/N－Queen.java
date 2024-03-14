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

            if (bottom[i] || left[i + depth] || right[depth - i + N - 1])
                continue;

            bottom[i] = true;
            left[i + depth] = true;
            right[depth - i + N - 1] = true;

            DFS(depth + 1);

            bottom[i] = false;
            left[i + depth] = false;
            right[depth - i + N - 1] = false;
        }
    }
}