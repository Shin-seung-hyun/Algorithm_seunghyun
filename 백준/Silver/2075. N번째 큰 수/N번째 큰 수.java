import java.io.*;
import java.util.*;

// #1927 최소 힙과 유사
// 우선순위 큐( = Heap 힙 자료구조로 구현)
    // 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 출력됨

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //우선순위 큐 선언(낮은 숫자 순)
        //PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 우선순위 큐 선언(높은 숫자 순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                pq.add(tmp);
            }
        }

        // 출력
        for(int i=1; i<=N; i++){
            if( i ==N) System.out.println(pq.poll());

            // PriorityQueue.poll() 첫번째 값을 반환하고 제거
            pq.poll();
        }

    }
}

