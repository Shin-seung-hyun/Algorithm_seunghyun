import java.util.*;
import java.io.*;

//문자열
public class Main {

    static int N;
    static String[] strArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        strArr = new String[N+1];
        for(int i =1; i<=N; i++){
            strArr[i] = br.readLine();
        }

        for(int i =1; i<=N; i++){
            int len = strArr[i].length();

            sb.append(strArr[i].charAt(0)).append(strArr[i].charAt(len-1)).append("\n");
        }

        System.out.print(sb.toString());
    }
}