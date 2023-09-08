import java.util.*;
import java.io.*;

class Solution {
    
    static int answer = 0;
    static boolean []visit;
    
    public int solution(int k, int[][] dungeons) {
        
        visit = new boolean [dungeons.length];
        
        //탐험할 던전의 순서 DFS()
            //중복 X , 순서O 나열
            //12 13 14, 21 23 24
        DFS(0, k, dungeons);
        
        return answer;
    }

    
    static void DFS(int depth ,int k, int[][] dungeons){

        // 반복조건
        for(int i=0; i< dungeons.length; i++){

            if( visit[i]) continue;
            if( k <dungeons[i][0]) continue;

            visit[i] = true;

            DFS(depth+1, k - dungeons[i][1], dungeons);

            visit[i] = false;
        }

        answer = Math.max(answer ,depth);

    }
    
}