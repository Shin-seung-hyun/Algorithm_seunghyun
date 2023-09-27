import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int [] arr = new int [20+1];
        for(int i =1; i<=20; i++) arr[i] = i;

        for(int i=1; i<=10; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int tmp = 0;
            for(int j = 0; j<(e-s+1)/2; j++){
                tmp = arr[s+j];
                arr[s+j] = arr[e-j];
                arr[e-j] = tmp;
            }

        }

        // 출력
        for(int i=1; i<=20; i++) System.out.print(arr[i] + " ");
    }

}