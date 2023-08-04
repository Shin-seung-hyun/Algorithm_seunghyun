import java.io.*;
import java.util.*;

// 문자열
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();

        String temp = str.replaceAll("[a-z]", "");
        String tmp = temp.replaceAll(" ", "");

        char[] ucpc ={ 'U','C','P','C'};
        int index = 0;
        for(int i= 0; i< tmp.length(); i++){
            if( index == 4) break;
            if(tmp.charAt(i) == ucpc[index]) index++;
        }

        if( index == 4) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");

    }

}

