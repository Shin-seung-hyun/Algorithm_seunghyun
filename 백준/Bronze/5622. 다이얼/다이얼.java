import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int sum= 0;

        for( char c : arr){
            switch(c){
                case 'A':
                case 'B':
                case 'C' : sum +=3; break;

                case 'D':
                case 'E':
                case 'F' : sum +=4; break;

                case 'G':
                case 'H':
                case 'I' : sum +=5; break;

                case 'J':
                case 'K':
                case 'L' : sum +=6; break;

                case 'M':
                case 'N':
                case'O' : sum +=7; break;

                case 'P':
                case 'Q':
                case 'R':
                case 'S' : sum +=8; break;

                case 'T':
                case 'U':
                case 'V' : sum +=9; break;

                case 'W':
                case 'X':
                case 'Y':
                case 'Z' : sum +=10; break;
            }
        }
        System.out.println(sum);
    }
}