import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for(int i=1; i<=testCase; i++){
            String str = br.readLine();

            int[] alphabet = new int [26];

            boolean check = true;
            for(int j = 0; j< str.length(); j++){

                alphabet[str.charAt(j) - 'A']++;

                if( alphabet[str.charAt(j) - 'A'] >=3){

                    alphabet[str.charAt(j) - 'A'] =0;

                    if( j+1 >= str.length() || str.charAt(j+1) != str.charAt(j)){
                        check = false;
                        break;
                    }

                    j++;
                }

            }

            if(check) sb.append("OK\n");
            else sb.append("FAKE\n");
        }

        System.out.print(sb.toString());
    }
}