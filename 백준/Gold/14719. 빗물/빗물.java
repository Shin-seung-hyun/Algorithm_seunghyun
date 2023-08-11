import java.util.*;
import java.io.*;

// 구현
public class Main{

    static int H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();

        H = Integer.parseInt(st.nextToken());   // 세로 길이
        W = Integer.parseInt(st.nextToken());   // 가로 길이

        int arr[] = new int [W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i< W; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 첫번째, 마지막은 빼기
        int sum = 0;
        for(int i=1; i< W-1; i++){

            int leftMax = arr[i];
            int rightMax = arr[i];

            // 왼쪽 max 찾기 0 ~ i-1
            for(int l = 0; l < i; l++){
                leftMax = Math.max(leftMax, arr[l]);
            }

            // 오른쪽 max 찾기 i+1 ~ W-1
            for(int r= i+1; r < W; r++){
                rightMax = Math.max(rightMax, arr[r]);
            }

            int min = Math.min(leftMax, rightMax);
            if( arr[i] < min) sum += min - arr[i];
        }

        System.out.println(sum);
    }
}
