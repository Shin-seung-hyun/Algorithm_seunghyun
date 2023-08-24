import java.io.*;
import java.util.*;

//BFS
public class Main {
    static int N;
    static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Pos> arrList;
    static ArrayList<Integer> adj[]; //인접 리스트
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase  = Integer.parseInt(br.readLine());
        for(int t = 1; t<= testCase; t++){

            N = Integer.parseInt(br.readLine());    // 편의점 수

            // 초기화
            arrList = new ArrayList<>();
            visit = new boolean[N + 2];
            adj = new ArrayList[N+2];
            for(int i =0; i< N+2; i++) adj[i] = new ArrayList<>();

            // 집, 편의점, 페스티벌 위치 저장
            for(int i=0; i<N +2; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arrList.add( new Pos(x, y));
            }

            // 거리가 1_000 이하인 집, 편의점, 페스티벌 사이의 거리를 정점으로 연결
            for(int i=0; i< N+2; i++){
                for(int j = i+1; j< N+2; j++){

                    int diff = Math.abs( arrList.get(i).x - arrList.get(j).x) +
                                Math.abs( arrList.get(i).y - arrList.get(j).y);

                    // 맨허튼 거리 기준으로 1000 이하라면 간선 연결
                    if( diff <= 1_000){
                        adj[i].add(j);  // arrList에 저장된 정점 index를 인접리스트 adj 에 저장
                        adj[j].add(i);
                    }
                }
            }

            BFS();

            if( visit[N+1] )sb.append("happy" + "\n");
            else sb.append("sad" + "\n");
        }

        System.out.print(sb.toString());
    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();

        visit = new boolean[N + 2];
        visit[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (visit[next]) continue;

                visit[next] = true;
                queue.add(next);
            }
        }

    }

}