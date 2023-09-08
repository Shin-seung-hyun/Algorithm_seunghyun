import java.util.*;
import java.io.*;

class Solution {
    
    static int N;
    static boolean[] visit;
    static ArrayList<String> arrList = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
    
        N = tickets.length;
        
        visit = new boolean[N];
        
        DFS( 0, "ICN", "ICN",tickets );
        
        Collections.sort(arrList);
        
        String [] answer = arrList.get(0).split(" ");
        return answer;
        
    }
    
    static void DFS(int depth, String s, String str, String[][] tickets){
        
        // 종료 조건
        if( depth == N){
            
            arrList.add(str);
            return;
        }
        
        // 반복 조건
        for(int i=0; i<N; i++){
            
            if( visit[i]) continue;
            if( !s.equals(tickets[i][0])) continue;
            
            visit[i] = true;
            DFS( depth+1, tickets[i][1], str + " " + tickets[i][1], tickets );
            visit[i] = false;
        }
    }
}