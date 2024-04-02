import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ".",true);

        while(st.hasMoreTokens()){

            String str = st.nextToken();
            int len = str.length();

            if(str.equals(".")) sb.append(".");

            else {
                if (len % 2 != 0) {

                    System.out.println("-1");
                    return;
                }

                for(int i=1; i<= len/4; i++)
                    sb.append("AAAA");

                for(int i =1; i<= len%4; i++)
                    sb.append("B");
            }

        }//end while

        System.out.println(sb.toString());
    }
}
