import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();
        int cnt =0;
        while( str.length() > 1){

            int num = str.charAt(0) -'0';

            for(int i =1; i<str.length(); i++){
                num *= str.charAt(i) -'0';
            }

            str = String.valueOf(num);

            //System.out.println(num);
            cnt++;
        }

        //출력
        System.out.println(cnt);
    }

}