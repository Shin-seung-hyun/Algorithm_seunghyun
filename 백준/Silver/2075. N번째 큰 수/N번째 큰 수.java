import java.io.*;
import java.util.*;

//우선순위 큐
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //큰수 출력을 위해 내림차순 정렬
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
            pq.poll();
        }

    }
}

