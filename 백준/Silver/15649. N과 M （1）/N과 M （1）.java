import java.io.*;
import java.util.*;

//완전탐색, 백트래킹 : 현재 상태에서 가능한 모든 후보군을 따라 들어가며 탐색하는 알고리즘
	//N개 중 M개를 중복 x, 순서 o 나열하기
	// 순열의 시간 복잡도 : O(nPm)
public class Main {
 
	 static int[] arr;
	 static boolean[] visit;
     static int N,M;
	 static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 방법1
		arr = new int[M];
		visit = new boolean[N];
		DFS1(0);

		// 방법2
		arr = new int [M+1];
		visit = new boolean[N+1];
		DFS2(1);

        System.out.print(sb.toString());
	}
 
	public static void DFS1(int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val+ " ");
			}
			sb.append("\n");
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {

				visit[i] = true;

				arr[depth] = i + 1;
				DFS1(depth + 1);

				visit[i] = false;
			}
		}
	}

	public static void DFS2(int depth){

		//종료 조건
		if( depth == M+1){
			for(int i =1; i<=M; i++){
				sb.append(arr[i]+ " ");
			}
			sb.append("\n");
			return;
		}

		//반복 조건
		for(int i =1; i<=N; i++){
			if(visit[i]) continue;

			visit[i] = true;

			arr[depth] = i;
			DFS2(depth + 1);

			visit[i] = false;
		}

	}
 
}