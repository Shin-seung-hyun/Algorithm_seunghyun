import java.util.Scanner;

//N개 중 M개를 중복 x, 순서 x 고르기
public class Main {
 
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();

	static boolean[] visit;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();
 
		arr = new int[M+1];
		//visit = new boolean[N+1];

		// 방법1
		dfs(1, 1);

		// 방법2
		//DFS(1, 1);

		System.out.println(sb.toString());
	}

	// 방법1
	public static void dfs(int at, int depth) {

		//재귀 종료 조건
		if(depth == M+1){
			for(int i =1; i<=M; i++){
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return ;
		}
        
		for (int i = at; i <= N; i++) {
 
			arr[depth] = i;
			dfs(i + 1, depth + 1);
 
		}
	}

	// 방법2
	static void DFS(int at , int depth){

		// 종료 조건
		if( depth == M + 1){
			for(int i =1; i<=M; i++){
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		//반복조건
		for(int i = at; i<=N; i++){
			if(visit[i]) continue;

			visit[i] = true;
			arr[depth] = i;
			DFS(i, depth+1);
			visit[i] = false;
		}

	}
}