import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1; t<=testCase; t++){

            int num = Integer.parseInt(br.readLine());
            int cnt =0;
            while(num != 6174){
                int [] arr = new int[4];

                for(int i=0; i<4; i++){
                    arr[i] = num % 10;
                    num /= 10;
                }

                Arrays.sort(arr);
                int minNum = arr[0] *1_000 + arr[1] * 100 + arr[2] *10 + arr[3];
                int maxNum = arr[3] *1_000 + arr[2] * 100 + arr[1] *10 + arr[0];

                num = maxNum - minNum;
                cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb.toString());
    }

}