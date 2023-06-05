import java.util.Scanner;

//N개 중 M개를 중복 x, 순서 o 나열하기
public class Main {
 
	public static int[] arr;
	public static boolean[] visit;
    public static int N,M;
    public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();

		// 방법1
		arr = new int[M];
		visit = new boolean[N];
		dfs(0);

		// 방법2
		arr = new int [M+1];
		visit = new boolean[N+1];
		DFS(1);

        System.out.print(sb.toString());
	}
 
	public static void dfs(int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}

	public static void DFS(int depth){

		//종료 조건
		if( depth == M+1){
			for(int i =1; i<=M; i++){
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		//반복 조건
		for(int i =1; i<=N; i++){
			if(visit[i]) continue;

			visit[i] = true;
			arr[depth] = i;
			DFS(depth + 1);
			visit[i] = false;
		}

	}
 
}