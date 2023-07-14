import java.util.*;
import java.io.*;

// 문자열
class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String possible = br.readLine();

        int i = 0;
        while(i < possible.length()) {
            if (i + 1 < possible.length() && possible.charAt(i) == 'p' && possible.charAt(i + 1) == 'i') {
                i += 2;
            }
            else if (i + 1 < possible.length() && possible.charAt(i) == 'k' && possible.charAt(i + 1) == 'a') {
                i += 2;
            }
            else if (i + 2 < possible.length() && possible.charAt(i) == 'c' && possible.charAt(i + 1) == 'h' && possible.charAt(i + 2) == 'u') {
                i += 3;
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}