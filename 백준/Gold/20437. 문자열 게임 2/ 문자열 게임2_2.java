import java.io.*;
import java.util.*;


//1. 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
//2. 어떤 문자를 정확히 K개를 포함하고, 첫 번째 문자 =  마지막 문자인 가장 긴 연속 문자열의 길이
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1; t <= testCase; t++) {

            char[] w = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            int[] alpha = new int[26];
            for(int i = 0; i < w.length; i++) {
                alpha[w[i]-'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int left = 0; left < w.length; left++) {
                if( alpha[ w[left]-'a' ] < k) continue;
                int cnt = 0;

                for(int right = left; right < w.length; right++) {
                    if(w[left] == w[right]) cnt++;

                    if(cnt == k) {
                        min = Integer.min(min, right-left+1);
                        max = Integer.max(max, right-left+1);
                        break;
                    }
                }
            }

            // 출력
            if( min == Integer.MAX_VALUE ) System.out.println( -1);
            else System.out.println(min + " " + max);

        } // end testCase

    }
}
