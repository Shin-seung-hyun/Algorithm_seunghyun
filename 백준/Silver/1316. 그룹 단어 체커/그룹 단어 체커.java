import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt =0;
        for(int i=0; i<N; i++){

            boolean alpha[] = new boolean [26];
            char prev = ' ';
            for( char c  : br.readLine().toCharArray()){

                // 그룹 단어가 아님
                if( alpha[ c -'a']  && (prev != c) ) {
                    cnt ++;
                    break;
                }
                prev = c;
                alpha[c -'a'] = true;
            }
        }

        System.out.println(N-cnt);

    }
}