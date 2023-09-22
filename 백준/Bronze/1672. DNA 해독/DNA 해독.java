import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());   // 염기서열 길이
        StringBuilder sb = new StringBuilder(br.readLine());

        char [][]role = {
                {'A','C','A','G'},
                {'C','G','T','A'},
                {'A','T','C','G'},
                {'G','A','G','T'}
        };

        while(sb.length() > 1){

            int r = check(sb.charAt(sb.length()-2));
            int c = check(sb.charAt(sb.length()-1));

            sb.delete(sb.length()-2, sb.length());

            sb.append(role[r][c]);

            //System.out.println(sb);
        }

        System.out.println(sb);
    }

    static int check(char c ){

        switch(c){
            case 'A' : return 0;
            case 'G' : return 1;
            case 'C' : return 2;
            case 'T' : return 3;
        }
        return 0;
    }

}