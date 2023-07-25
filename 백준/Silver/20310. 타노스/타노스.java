import java.io.*;
import java.util.*;

//
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;
        for(int i= 0; i<str.length(); i++){
            if(str.charAt(i) =='0') zeroCnt++;
            else oneCnt++;
        }

        int [] arr = new int [str.length()/2];

        for(int i=0; i< zeroCnt/2; i++) arr[i] = 0;
        for(int i = zeroCnt/2; i< arr.length; i++) arr[i] = 1;

        for(int val : arr) System.out.print(val);
    }
}