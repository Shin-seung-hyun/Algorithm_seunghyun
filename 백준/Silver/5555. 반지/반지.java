import java.util.*;
import java.io.*;

class Main {
    static String findStr;  // 찾는 문자열
    static int num; // 반지의 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        findStr = br.readLine();
        num = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i=1; i<=num; i++){
            String str = br.readLine();

            // substring( int beginIndex 포함, int endIndex 미포함)
            str = str + str.substring(0, findStr.length()-1);

            if( str.contains(findStr)) cnt++;
        }

        System.out.println(cnt);
    }
}