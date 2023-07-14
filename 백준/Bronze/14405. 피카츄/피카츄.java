import java.util.*;
import java.io.*;

// 문자열
class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String possible = br.readLine();

        /* replace(대상 문자열, 대체할 문자열)*/
        //String replace(CharSequnce target, CharSequence replacement)
//        possible = possible.replace("pi", "");
//        possible = possible.replace("ka","");
//        possible = possible.replace("chu","");

        /* replaceAll(정규식 or 대상 문자열, 대체할 문자열) */
        //String replaceAll(String regex, String replacement)
        possible = possible.replaceAll("pi|ka|chu","");


        if(possible.equals("")) System.out.println("YES");
        else System.out.println("NO");
    }
}