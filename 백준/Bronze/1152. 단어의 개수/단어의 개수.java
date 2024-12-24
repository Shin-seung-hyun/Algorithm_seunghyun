import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] strArr =br.readLine().split(" ");
        //System.out.println(strArr.length);

        int cnt =0;
        for( String str : strArr){
            if( str.equals("")) continue;
            cnt++;
        }

        System.out.println(cnt );
    }
}