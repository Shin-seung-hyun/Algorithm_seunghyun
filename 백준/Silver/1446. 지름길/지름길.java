import java.io.*;
import java.util.*;

// DFS
public class Main {

    static class Path{
        int start;
        int end;
        int dist;

        public Path(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    static ArrayList<Path> paths = new ArrayList<>();
    static boolean [] visit;
    static int result = Integer.MAX_VALUE;

    //static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 지름길의 개수
        int D = Integer.parseInt(st.nextToken());   // 고속도로의 길이

        for(int i=1; i<=N ;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if( start >D || end >D) continue;

            paths.add(new Path(start, end ,dist));
        }

        visit = new boolean[paths.size()];

        // DFS
        DFS(0, D, 0);

        System.out.println(result);
    }

    static void DFS(int current, int D, int sum){

        // 1. 도착지를 넘어섰을 때
        if( current > D) return;

        // 2. 도착지일 때
        else if( current == D ){
            result = Math.min(result, sum);
            return;
        }

        // 3. 도착지에 도달하지 못했을 때( 아직 DFS 더 돌아야 함)
        else result = Math.min(result, sum + ( D - current));

        // 지름길을 선택했다면
        for(int i=0; i< paths.size(); i++){

            if(visit[i]) continue;

            Path p = paths.get(i);
            if( p.start == current){
                visit[i] = true;

                DFS(p.end, D, sum + p.dist  );

                visit[i] = false;
            }
        }//end for

        // 지름길을 선택하지 않았다면
        DFS(current+1, D, sum+1);
    }

}

