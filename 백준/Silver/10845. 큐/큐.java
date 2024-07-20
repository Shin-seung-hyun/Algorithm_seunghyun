import java.io.*;
import java.util.*;

//1. 큐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int lastValue = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());
            switch( st.nextToken()){

                case "push" :
                    lastValue = Integer.parseInt(st.nextToken());
                    queue.add(lastValue);
                    break;
                case  "pop" :
                     if(queue.isEmpty()) sb.append("-1\n");
                     else sb.append(queue.poll()).append("\n");
                     break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case  "empty" :
                    if(queue.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case  "front" :
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case  "back" :
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(lastValue).append("\n");
                    break;


            }
        }
        System.out.print(sb.toString());

    }
}