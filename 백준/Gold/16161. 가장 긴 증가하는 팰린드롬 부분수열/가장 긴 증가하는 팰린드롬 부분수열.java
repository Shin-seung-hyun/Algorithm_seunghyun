import java.util.*;
import java.io.*;

//부분수열 중 길이가 가장 긴 증가하는 팰린드롬
class Main{
	static int N;   // 수열의 길이
	static int[] arr;

	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =1; i<=N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		twoPointer();

	}

	static void twoPointer() {
		int left = 1;
		int right = 1;
		int answer = 1;

		while (right < N) {
			int cnt, l, r;
			if (arr[right] < arr[right + 1]) right += 1;

			else {
				if (arr[right] > arr[right + 1]) {
					cnt = 1;
					l = right - 1;
					r = right + 1;
				}

				else {
					cnt = 0;
					l = right;
				}

				r = right + 1;

				while (l >= left && r <= N) {
					if (arr[l] == arr[r]) {
						cnt += 2;
						l -= 1;
						r += 1;
					}
					else break;
				}
				answer = Math.max(answer, cnt);

				right += 1;
				left = right;
			}
		}

		System.out.println(answer);
	}
}