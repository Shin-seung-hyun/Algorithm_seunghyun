import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static double arr[][];
    static double start = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double len = Integer.parseInt(br.readLine());
        arr = new double[3][2];

        //입력
        // [0] : 빨, [1] : 파, [2] : 노
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<3; i++){
            if( arr[i][0] == arr[i][1]) continue;
            len = fold(i,len);
        }

        System.out.printf("%.1f", len);
    }

    static double fold(int idx, double n){
        double total = arr[idx][0] + arr[idx][1];
        double left = Math.abs( (total /2) - start);
        double right = Math.abs( n - left);

        start = total/2;

        for(int i = idx +1; i<3; i++){
            arr[i][0] = start + Math.abs(start - arr[i][0]);
            arr[i][1] = start + Math.abs(start - arr[i][1]);
        }

        return Math.max(left, right);
    }

}