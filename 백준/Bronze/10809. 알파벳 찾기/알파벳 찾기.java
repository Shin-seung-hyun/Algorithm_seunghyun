import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] charArray= br.readLine().toCharArray();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for( int i=0; i<charArray.length; i++){
            if(alphabet[ charArray[i] -'a'] == -1) alphabet[charArray[i] -'a' ] = i;
        }

        for(int i : alphabet) sb.append(i + " ");
        System.out.println(sb.toString());
    }
}