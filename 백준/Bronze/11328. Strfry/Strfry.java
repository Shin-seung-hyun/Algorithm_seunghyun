import java.util.*;
import java.io.*;

//배열
class Main{

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int t=1; t<=testCase; t++) {

            int alpha[] = new int[26];

            st = new StringTokenizer(br.readLine());

            String first = st.nextToken();
            String second = st.nextToken();

            for(int i=0; i< first.length(); i++){
                alpha[first.charAt(i) - 'a']++;
            }

            for(int i=0; i< second.length(); i++){
                alpha[second.charAt(i) - 'a']--;
            }

            boolean answer = true;
            for(int i=0; i<26; i++){
                if( alpha[i] != 0) answer = false;
            }

            if( answer )System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }

}