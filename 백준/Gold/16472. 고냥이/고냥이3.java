import java.util.*;
import java.io.*;

class Main{
    static int N;       // 종류의 최대 수
    static String str;  // 문자열
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        visit = new int [26];

        twoPointer();
    }

    static void twoPointer(){
        int left = 0;
        int right =0;
        visit[str.charAt(0) - 'a']++;
        int cnt  =1;
        int answer = 0;

        while(true){
            right++;

            if(right == str.length()) break;

            visit[str.charAt(right) - 'a']++;

            // 처음 등장하는 수라면
            if( visit[str.charAt(right) - 'a'] ==1 ) cnt ++;


            // 알파벳 종류가 N 보다 클 경우
            while(cnt >N){
                visit[str.charAt(left) - 'a'] --;
                if(visit[str.charAt(left) - 'a'] == 0 ) cnt--;
                left++;
            }

            answer = Math.max(answer , right - left +1);
        }

        System.out.println(answer);
    }


}