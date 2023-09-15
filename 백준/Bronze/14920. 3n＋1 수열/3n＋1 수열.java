import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int start = Integer.parseInt(br.readLine());

        int cnt = 1;
        while(true){

            if( start ==1) break;
            
            if( start %2 ==0) start /=2;
            else start = 3 * start +1;

            cnt ++;

        }
        System.out.println(cnt);

    }

}