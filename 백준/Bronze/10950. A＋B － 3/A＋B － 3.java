import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine());
        
        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            sb.append(A+B).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}