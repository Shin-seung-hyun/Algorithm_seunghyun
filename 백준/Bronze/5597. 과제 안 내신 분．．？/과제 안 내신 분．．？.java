import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean [] arr = new boolean[30+1];

        for(int i=0; i<28; i++){
            arr[ Integer.parseInt(br.readLine())] = true;
        }

        for(int i=1; i<arr.length; i++){
            if(arr[i]) continue;
            System.out.println(i);
        }
    }
}