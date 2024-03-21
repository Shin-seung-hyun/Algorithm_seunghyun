import java.util.*;
import java.io.*;

// 시뮬레이션
public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        while(true){

            String str = br.readLine();

            if( str.equals("0")) break;

            int len = str.length();
            boolean isPalin = true;
            for(int i=0; i<len/2; i++){

                if(str.charAt(i) != str.charAt(len-i-1)){
                    isPalin = false;
                    break;
                }
            }
            
            if( isPalin) System.out.println("yes");
            else System.out.println("no");
        }

    }

}