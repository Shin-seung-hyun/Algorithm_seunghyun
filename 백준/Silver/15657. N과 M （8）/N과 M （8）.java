import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr, printArr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		printArr = new int[M];
		
        st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		DFS(0, 0);
	}
	
	static void DFS(int startIdx, int depth) {
        
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(printArr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=startIdx; i<N; i++) {
			printArr[depth] = arr[i];
			DFS(i, depth + 1); 
		}
	}
}