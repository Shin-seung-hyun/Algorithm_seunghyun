import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=N; i++){
            
            for(int j=1; j<= N-i; j++) sb.append(" ");
            for(int j=1; j<=i; j++)sb.append("* ");
             
            sb.append("\n");
        }
       
       System.out.print(sb.toString());
    }
}