import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        
        for(int i=0; i<str.length(); i++){
            
            if( i != 0 && i % 10 == 0) sb.append("\n");
            
            sb.append(str.charAt(i));
        }
        
        System.out.print(sb.toString());
    }
}