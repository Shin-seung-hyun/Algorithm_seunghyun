import java.util.*;
import java.io.*;


// 인접 리스트
    // BFS
class Solution {
    
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    
    public int solution(int N, int[][] computers) {

        // 초기화
        visit = new boolean[N];

        // BFS 탐색
        int cnt =0;
        for(int i =0; i<N; i++){
            for( int j =0; j<N; j++){

                if( computers[i][j] !=1) continue;

                if( visit[j]) continue;

                BFS(j, N, computers);

                cnt++;
            }
        }

        return cnt;
    }


    static void BFS(int x, int N, int[][] computers){
        Queue<Integer> queue = new LinkedList<>();

        // 방문
        visit[x] = true;
        queue.add(x);

        //탐색
        while(!queue.isEmpty()){

            x = queue.poll();

            for( int i=0; i<N; i++){

                if( computers[x][i] !=1) continue;
                if( visit[i]) continue;

                visit[i] = true;
                queue.add(i);
            }
        }
    }
    
    
}