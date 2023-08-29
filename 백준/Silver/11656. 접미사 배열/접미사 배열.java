import java.io.*;
import java.util.*;

// 문자열
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String s = br.readLine();

        String [] arr = new String[ s.length()];

        for(int i= 0; i<s.length(); i++){
            arr[i] = s.substring(i);
        }

        Arrays.sort(arr);
        for(String str : arr) System.out.println(str);
    }


}