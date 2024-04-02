import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++) queue.add(i);

        while(!queue.isEmpty()){

            System.out.print(queue.poll() + " ");
            if( queue.peek() != null)
                queue.add( queue.poll());
        }

    }
}
