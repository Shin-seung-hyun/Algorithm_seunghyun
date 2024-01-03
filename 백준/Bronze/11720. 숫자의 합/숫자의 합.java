import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        int sum =0;
        for(int i=0; i<num; i++){
           sum += str.charAt(i) -'0';
        }
        
        System.out.println(sum);
    }
}