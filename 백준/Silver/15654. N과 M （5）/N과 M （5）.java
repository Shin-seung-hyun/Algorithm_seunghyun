import java.util.*;
import java.io.*;

class Main {
    static int[] nums;
    static int[] arr;
    static boolean[] visit;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        arr = new int[N];
        visit = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        DFS(0);
        
        System.out.print(sb.toString());
    }

    static void DFS(int count) {
        
        //종료 조건
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        //반복조건
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                
                arr[count] = nums[i];
                DFS(count + 1);
                
                visit[i] = false;
            }
        }
    }
}