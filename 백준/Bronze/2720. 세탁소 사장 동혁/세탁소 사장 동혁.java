import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            int charge = Integer.parseInt(br.readLine());

            sb.append(charge/25 + " ");
            charge = charge%25;

            sb.append(charge/10 + " ");
            charge = charge%10;

            sb.append(charge/5 + " ");
            sb.append(charge%5 + "\n");
        }

        System.out.println(sb.toString());
    }
}
