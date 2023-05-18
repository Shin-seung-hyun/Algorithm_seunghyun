import java.util.*;
import java.io.*;


class Main{
    static int N;
    static int[]arr;
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i =1; i<=T ;i++){
            int cycle_Cnt =0;
            N = Integer.parseInt(br.readLine());

            arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[N+1];

            for(int k = 1; k<=N; k++){
                if(visit[k]) continue;
                BFS(k);
                cycle_Cnt++;
            }

            System.out.println(cycle_Cnt);
        }
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        //start 방문
        queue.add(start);
        visit[start] = true;

        //방문할 게 없을 때까지 방문
        while(!queue.isEmpty()){

            start = queue.poll();

            if( visit[arr[start]] ) continue;

            queue.add(arr[start]);
            visit[arr[start]] = true;
        }

    }


}