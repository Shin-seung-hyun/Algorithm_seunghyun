import java.io.*;
import java.util.*;

// 우선순위 큐( = Heap 힙 자료구조로 구현)
    // 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 출력됨
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        //우선순위 큐 선언(낮은 숫자 순)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 우선순위 큐 선언(높은 숫자 순)
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());

            if( num == 0 ){
                if( pq.isEmpty() ) System.out.println("0");

                // PriorityQueue.poll() 첫번째 값을 반환하고 제거
                else System.out.println(pq.poll());
            }
            
            else pq.add(num);
        }

    }
}