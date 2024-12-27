import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toUpperCase().toCharArray();

         int alpha[] = new int[26];
         int maxCnt = 0;
         char answer = '?';
         for(char c : charArr){
             alpha[c -'A']++;

             if(maxCnt == alpha[c-'A']){
                answer = '?';
             }
             else if( maxCnt < alpha[c-'A']){
                 maxCnt = alpha[c-'A'];
                 answer = c;
             }
         }

         System.out.println(answer);
    }
}