import java.io.*;
import java.util.*;

// 문자열
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true){
            
            String str = br.readLine();
            if( str == null) break;
            
            st  = new StringTokenizer(str);

            String s = st.nextToken();
            String t = st.nextToken();

            boolean check = false;
            int index = 0;

            for (int i = 0; i < t.length(); i++) {

                if (s.charAt(index) == t.charAt(i)) {
                    index++;

                    if( index == s.length()){
                        check = true;
                        break;
                    }
                }
            }

            if( check) System.out.println("Yes");
            else System.out.println("No");
        }

    }
}