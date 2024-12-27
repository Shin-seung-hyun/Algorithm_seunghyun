import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

         char[] charArr = br.readLine().toUpperCase().toCharArray();

         int alpha[] = new int[26];
         boolean isMore = false;
         int maxCnt = 0;
         char maxAlpha = ' ';
         for(char c : charArr){
             alpha[c -'A']++;

             if(maxCnt == alpha[c-'A']){
                 isMore = true;
             }
             else if( maxCnt < alpha[c-'A']){
                 maxCnt = alpha[c-'A'];
                 isMore = false;
                 maxAlpha = c;
             }
         }

         if(isMore) System.out.println("?");
         else System.out.println(maxAlpha);


    }
}