import java.util.*;
import java.io.*;

class Solution {
    
    static int[][] adj;
    static int N;
    
    
    public int solution(int n, int[][] wires) {
        
        N = n;
        
        adj = new int[N+1][N+1];
        
        // 인접 행렬
        for(int i=0; i<N-1; i++){
            
            adj[wires[i][0]][wires[i][1]] = 1;
            adj[wires[i][1]][wires[i][0]] = 1;
        }
        
        
        // 전선 중 하나 끊기
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<N-1; i++){
            int x = wires[i][0];
            int y = wires[i][1];
         
            adj[x][y] = 0;
            adj[y][x] = 0;
            
            answer = Math.min(answer, BFS(1) );
            
            adj[x][y] = 1;
            adj[y][x] = 1;
            
        }
        
        return answer;
    }
    
    
    static int BFS(int x){

        Queue<Integer> queue = new LinkedList<>();

        boolean []check = new boolean[N+1];
        int cnt = 0;

        queue.add(x);
        check[x] = true;

        while(!queue.isEmpty()){
            x = queue.poll();
            cnt++;

            for(int i =1; i<=N; i++ ){

                if( check[i]) continue;
                if( adj[x][i] != 1) continue;

                check[i] = true;
                queue.add(i);
                
            }
        }

       // System.out.println(cnt);
        return Math.abs( (N - cnt) - cnt );

    }       
    
}