import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- >0){

            st = new StringTokenizer(br.readLine());

            int repeat = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int i=0; i<str.length(); i++){
               for(int j=0; j<repeat; j++){
                    sb.append(str.charAt(i));
               }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}