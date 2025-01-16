import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while(N > 0){
            int tmp = N % B;
            if(tmp >= 10){
                char c = (char) ((tmp -10) + 'A');
                sb.append(c);
            }
            else sb.append(tmp);
            
            N = N/B;
        }

        System.out.println(sb.reverse().toString());
    }
}
