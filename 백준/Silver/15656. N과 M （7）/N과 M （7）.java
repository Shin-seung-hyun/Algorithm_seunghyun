import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr, outputArr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			outputArr = new int[M];
			
            st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
        
			DFS(0, 0);
			
			System.out.println(sb);
	}
	
	static void DFS(int start, int depth) {
        
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(outputArr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			outputArr[depth] = arr[i];
			DFS(i + 1, depth + 1); 
		}
	}
}