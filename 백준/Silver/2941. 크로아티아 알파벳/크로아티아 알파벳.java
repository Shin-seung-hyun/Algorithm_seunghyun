import java.util.*;
import java.io.*;

// 문자열
class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        int count = 0;

        for (int i = 0; i < len; i++) {

            char ch = str.charAt(i);

            // c=, c-
            if(ch == 'c' && i < len - 1) {	
                if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') i++;
            }

            //d-, dz=
            else if(ch == 'd' && i < len - 1) {
                
                //d-
                if(str.charAt(i + 1) == '-') i++;
                
                //dz=
                else if(str.charAt(i + 1) == 'z' && i < len - 2) {

                    if(str.charAt(i + 2) == '=') i += 2;
                }
            }

            // lj, nj
            else if((ch == 'l' || ch == 'n') && i < len - 1) {
                if(str.charAt(i + 1) == 'j') i++;
            }

            // s=, z= 
            else if((ch == 's' || ch == 'z') && i < len - 1) {
                if(str.charAt(i + 1) == '=') i++;
            }

            count++;
        }

        System.out.println(count);
    }
}