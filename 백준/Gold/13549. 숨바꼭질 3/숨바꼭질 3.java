import java.util.*;
import java.io.*;

// BFS
public class Main{

    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken());   // 동생의 위치

        dist = new int [100_000 + 1];
        Arrays.fill(dist, -1);

        BFS(N);

        System.out.println(dist[K]);
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        dist[start] = 0;

        while(!queue.isEmpty()){
            int x  = queue.poll();

        /* 이득이 되는 순서를 먼저 if문에 작성할 것 */
        /*
            input : 4 6
            output: 1

            if문의 우선순위가 있을 때 : 4 -> 3 -> 6
            if문의 우선순위가 없을 때 : 4 -> 5 -> 6

        */
            // *2 경우
            if( 2 * x <= 100_000 && (dist[2 *x ] == -1)){
                queue.add(2*x);
                dist[2*x] = dist[x];
            }

            // -1 경우
            if( x -1 >=0 && (dist[x-1] == -1)){
                queue.add(x-1);
                dist[x-1] = dist[x] + 1;
            }

            // +1 경우
            if(x + 1 <= 100_000 && (dist[x+1] == -1)){
                queue.add(x+1);
                dist[x+1] = dist[x] + 1;
            }

        }// end while

    }

}
