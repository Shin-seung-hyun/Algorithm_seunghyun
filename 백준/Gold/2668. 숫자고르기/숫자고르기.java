import java.io.*;
import java.util.*;

// DFS 깊이 우선탐색
public class Main {

    static int N;
    static int[] adj;
    static boolean[] visit;
    static ArrayList<Integer> arrList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());   // 가로
        adj = new int[N+1];
        visit = new boolean[N+1];

        for(int i =1; i<=N; i++){
            adj[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++) {
            visit[i] = true;
            DFS(i, i);
            visit[i] = false;
        }

        // 작은 것 부터 출력
        Collections.sort(arrList);

        System.out.println(arrList.size());
        for(int val : arrList) System.out.println(val);
    }

    static void DFS(int start, int target){

        // 반복
        if( !visit[adj[ start]] ){

            visit[ adj[start]] = true;
            DFS( adj[start],target );
            visit[ adj[start]] = false;

        }

        // 사이클 생성 시, 해당 숫자 저장 후 종료
        if( adj[start] == target ){
            arrList.add(target);
        }

    }

}
