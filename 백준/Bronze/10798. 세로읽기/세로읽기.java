import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();

        String[] arr = new String[5];
        int maxLen = 0;
        for(int i=0 ;i<arr.length; i++){
            arr[i] = br.readLine();
            maxLen = Math.max(maxLen, arr[i].length());
        }

        for(int i=0; i<maxLen; i++){
            for(int j=0; j<5; j++){

                if(arr[j].length()-1 < i) continue;
                sb.append(arr[j].charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
