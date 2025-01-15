import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();

        String str ="";

        for(int i=0; i<5; i++){
            String tmp = br.readLine();

            while(tmp.length() < 15)
                tmp += "*";

            str += tmp;
        }

        for(int i=0; i<15; i++) {
            for (int j = 0; j < 5; j++) {
                char c = str.charAt(15 * j + i);
                if (c != '*')
                    sb.append(str.charAt(15 * j + i));
            }
        }

        System.out.println(sb.toString());
    }
}