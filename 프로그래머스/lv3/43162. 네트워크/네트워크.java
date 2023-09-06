import java.util.*;
import java.io.*;


// 인접행렬
    // BFS
class Solution {
    
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    
    public int solution(int N, int[][] computers) {
    
        
        // 초기화
        visit = new boolean[N];
        adj = new ArrayList[N];
        for(int i=0; i<N; i++) adj[i] = new ArrayList<>();
        
        // 인접 리스트 입력
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                
                if( computers[i][j] != 1) continue;
                
                adj[i].add(j);
                adj[j].add(i);
            }
        }
        
        
        // BFS9 탐색
        int cnt =0;
        for(int i =0; i<N; i++){
            for( int j : adj[i]){
                
                if( visit[j]) continue;
                
                BFS(j);
                
                cnt++;
            }
        }
        
        return cnt;
    }
    
    
    static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();
        
        // 방문
        visit[x] = true;
        queue.add(x);
        
        //탐색
        while(!queue.isEmpty()){
            
            x = queue.poll();
            
            for( int val : adj[x]){
                
                if( visit[val]) continue;
                
                visit[val] = true;
                queue.add(val);
            }
        }
    }
}