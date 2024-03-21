import java.util.*;
import java.io.*;

// 시뮬레이션
public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        while(true){

            sb = new StringBuilder(br.readLine());

            if( sb.toString().equals("0")) break;


            if( sb.toString().equals(sb.reverse().toString())) System.out.println("yes");
            else System.out.println("no");
        }

    }

}