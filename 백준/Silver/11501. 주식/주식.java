import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(st.nextToken());

        for(int t = 1; t<= testCase; t++){
            int day = Integer.parseInt(br.readLine());

            int [] arr = new int [day];

            st = new StringTokenizer(br.readLine());
            for(int i= 0; i< day; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long sum = 0;
            for(int i = day-1; i >=0; i--){
                
                if( arr[i] > max) max = arr[i];

                // arr[i] <= max 라면 팔기
                else  sum += max - arr[i];
            }

            sb.append(sum + "\n");
        } // end testCase

        System.out.print(sb.toString());
    }
}

