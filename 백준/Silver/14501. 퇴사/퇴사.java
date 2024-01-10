import java.util.*;
import java.io.*;

//DP -> O(N)
class Main{
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		// Dy[i] : i-1 날까지 상담했을 때, 최대 이익임으로 +2
		int [] Dy = new int[15+2];
		int[] time = new int[15+1];
		int[] price = new int[15+1];

		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}

		// 가짜식 Dy[i] : i-1 날까지 상담했을 때, 최대 이익
		// 초기화

		// 점화식
		for(int i = 1; i <= N; i++) {

			//Dy[i] 값 확정
			Dy[i] = Math.max(Dy[i], Dy[i-1]);

			//Dy[i + time[i]] 값 갱신
			// i번째 날 상담을 할 경우, i+time[i]-1은 상담이 종료되는 날
			if(i+time[i]-1 <= N) {

				// max(원래 있던 값, 갱신될 값 )
				Dy[i + time[i]] = Math.max( Dy[i + time[i]], Dy[i] + price[i]);
			}
		}

		System.out.println(Math.max(Dy[N], Dy[N+1]));
	}
}