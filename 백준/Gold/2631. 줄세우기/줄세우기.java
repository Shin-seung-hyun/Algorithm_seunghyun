import java.io.*;
import java.util.*;

//DP
    // 3 7 5 2 6 1 4
    //1. 가장 긴 증가하는 수열을 만든다. (3 5 6)
    //2. 가장 긴 증가하는 수열 이외의 수를 배열에서 이동시킨다. (7 2 1 4)
    //3. 이동한 최소 수는 N - 가장 긴 증가하는 수열의 수
public class Main{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 아이들 수

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];


        dp[0] = 1;
        int cnt = 0;
        for(int i = 1; i < N; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            cnt = Math.max(cnt,  dp[i]);
        }

        System.out.println(N-cnt);
    }
}