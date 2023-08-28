import java.io.*;
import java.util.*;

//문자열
public class Main{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String find = br.readLine();

        String word ="";
        for(int i=0; i< str.length(); i++){

            if( str.charAt(i) >= '0' && str.charAt(i) <= '9') continue;

            word += str.charAt(i);

        }

        if( word.contains(find)) System.out.println(1);
        else System.out.println(0);
    }
}