import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int alpha[] = new int[26];

        for(int i=0; i< S.length(); i++){
            int idx = S.charAt(i) - 'a';

            alpha[idx]++;
        }

        //출력
        for( int cnt : alpha) System.out.print(cnt + " ");

    }
}