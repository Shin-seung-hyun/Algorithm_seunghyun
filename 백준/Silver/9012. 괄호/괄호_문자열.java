
import java.util.*;
import java.io.*;

//문자열
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){

            String str = br.readLine();

            while(str.contains("()")){
                str = str.replace("()","");
            }

            if(str.length() == 0 )sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb.toString());

    }//end main
}
