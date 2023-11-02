import java.util.*;
import java.io.*;

class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static int[] time = new int[100_000 + 1];
    static int[] parent = new int[100_000 + 1]; // 경로 추적을 위한 역추적 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

    // 탐색
        BFS();


    //출력
        // 순서대로 출력하기 위해 Stack에 담았다가 출력
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        sb.append(time[K] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }

    static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) return;
            
            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (time[next] == 0)
                    queue.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;

            }
        } // end while

    }// end BFS
}

