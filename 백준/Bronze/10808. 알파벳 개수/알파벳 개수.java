import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int[] alpha = new int[26];
        for( char c  : br.readLine().toCharArray()){
            alpha[ c -'a'] ++;
        }

        //System.out.println(Arrays.toString(alpha));
        for(int i : alpha) System.out.print( i + " ");
    }
}