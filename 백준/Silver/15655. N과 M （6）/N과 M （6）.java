import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visit;
    static int[] arr;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        visit = new boolean[n];
        arr = new int[m];
        DFS(0,0);
        System.out.println(sb);
    }

    static void DFS(int depth, int start) {
        
        //조욜 조건
        if (depth == m) {
            
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                
                arr[depth] = input[i];
                DFS(depth + 1,i);
                
                visit[i] = false;
            }
        }
        
    }
}