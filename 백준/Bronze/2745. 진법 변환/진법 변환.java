import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        char[] N = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());

        int num = 0;
        int idx = N.length-1;
        for( char c : N){
            if(c >= 'A') num += (int) (Math.pow(B,idx) * (c-'A'+10));
            else num += (int) Math.pow(B,idx) * (c -'0');
            idx--;
        }

        System.out.println(num);
    }
}
