import java.util.*;
import java.io.*;

// 시뮬레이션
public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String result = "";
        String[] arrStr = new String[5];

        int maxLen = 0;
        for(int i=0; i<5; i++){

            String str = br.readLine();
            arrStr[i] = str;
            maxLen = Math.max(maxLen, str.length());
        }

        for(int i=0; i< maxLen; i++){

            for(int j = 0; j<5; j++){

                if( arrStr[j].length()-1 < i) continue;

                result += arrStr[j].charAt(i);
            }
            //result += " ";
        }

        System.out.println(result);
    }

}