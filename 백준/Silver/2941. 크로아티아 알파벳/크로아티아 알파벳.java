import java.util.*;
import java.io.*;

// 문자열
class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
    
        int cnt =0;
        int len = str.length();
        
        for(int i= 0; i< str.length(); i++){
            
            char ch = str.charAt(i);
            
            // c= , c-
            if( ch =='c' && i+1 <len){
                if( str.charAt(i+1) == '=' || str.charAt(i+1) == '-') i++;
            }
            
            //dz=, d-
            else if ( ch == 'd' && i+1 <len){
                if ( str.charAt(i+1)== '-') i++;
                else if (i+2 <len && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=' ) i+=2;
            }
            
            //lj, nj
            else if ( (ch == 'l' || ch == 'n') && i+1 < len){
                if( str.charAt(i+1) == 'j') i++;
            }
            
            //s=, z=
            else if ( (ch =='s' || ch =='z') && i +1 < len){
                if( str.charAt(i+1) == '=') i++;
            }
            
            cnt++;
        }

        System.out.println(cnt);
    }
}