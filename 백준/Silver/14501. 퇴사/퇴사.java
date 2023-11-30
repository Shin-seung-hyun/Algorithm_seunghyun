import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        int n = Integer.parseInt(reader.readLine());
		
		int[] t = new int[n];
		int[] p = new int[n];

		for (int i=0; i<n; i++) {
			st = new StringTokenizer(reader.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1]; //N일에 얻을 수 있는 최대 수익
		
		//점화식
		    //현재 날짜에서 소요 시간과 비용을 더해 dp에 저장
		    //이후, 중복될 때 최대값을 넣는다.
		for (int i=0; i<n; i++) {
			if (i + t[i] <= n) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}

			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
        
		System.out.println(dp[n]);
		
	}
}