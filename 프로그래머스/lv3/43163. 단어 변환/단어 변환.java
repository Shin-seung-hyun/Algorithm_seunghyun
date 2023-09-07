import java.util.*;
import java.io.*;

class Solution {
    static boolean visit[];
    
    static class Node{
        String str;
        int count;

        public Node(String str, int count){
            this.str = str;
            this.count = count; // 몇 단계를 거치는지 
        }
    }
    
    public int solution(String begin, String target, String[] words) {

        //초기화
        visit = new boolean[words.length];

            // BFS 탐색
        int answer = BFS(begin, target, words);
            
        return answer;
    }

    static int BFS(String begin, String target, String[] words){
        Queue<Node> queue = new LinkedList<>();
        
        // 방문
        queue.add(new Node( begin,0));

        while(!queue.isEmpty() ){
            Node node = queue.poll();

            if(node.str.equals(target)){
                
                return node.count;
            } 

            for(int i =0; i< words.length; i++){
                int cnt =0;

                if( visit[i]) continue;

                for(int j=0; j< words[i].length(); j++){

                    if( words[i].charAt(j) != node.str.charAt(j)){
                        cnt++;
                    }
                }

                if(cnt == 1){
                    visit[i] = true;
                    queue.add( new Node( words[i], node.count+1));
                }
            }
        } // end while
        
        return 0;
    }
}