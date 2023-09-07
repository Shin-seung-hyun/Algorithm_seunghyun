import java.util.*;
import java.io.*;

class Solution {
    
    static int[][] dir = { {1,0},{-1,0},{0,1},{0,-1} };
    static int[][] dist;
    static int N,M;
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        // 초기화
        dist = new int [N][M];
        for(int i=0; i<N; i++) Arrays.fill(dist[i],-1);
        
        //BFS 탐색
        BFS(0,0, maps);
        
        return dist[N-1][M-1];
    }
    
    static void BFS(int x, int y, int[][] maps){
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(x);
        queue.add(y);
        dist[x][y] = 1;
        
        while(!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();
            
            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                if( nx < 0 || ny <0 || nx >=N || ny>= M) continue;
                if( dist[nx][ny] != -1) continue;
                if( maps[nx][ny] == 0) continue;
                
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y] +1;
            }
        }
    }
}