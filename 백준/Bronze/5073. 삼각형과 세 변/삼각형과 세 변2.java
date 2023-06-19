import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if( a + b + c ==0) break;

            int max = Math.max(a, Math.max(b, c));

            if (max == a) {
                if (a >= b + c){
                    sb.append("Invalid" + "\n");
                    continue;
                }
            }
            else if (max == b) {
                if (b >= a + c){
                    sb.append("Invalid" + "\n");
                    continue;
                }
            }
            else {
                if (c >= a + b){
                    sb.append("Invalid" + "\n");
                    continue;
                }
            }

            if( a == b && b == c) sb.append("Equilateral" + "\n");
            else if ( a == b || b == c || c ==a) sb.append("Isosceles" + "\n");
            else sb.append("Scalene" + "\n");

        }

        System.out.print(sb.toString());
    }
}