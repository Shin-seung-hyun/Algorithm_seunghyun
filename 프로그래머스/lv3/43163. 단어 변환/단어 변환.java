import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dist;  // 몇 단계를 거치는지 
    static int answer =0;
    static boolean visit[];
    
    static class Node{
        String str;
        int idx;

        public Node(String str, int idx){
            this.str = str;
            this.idx = idx;
        }
    }
    
    public int solution(String begin, String target, String[] words) {

        //초기화
        visit = new boolean[words.length];
        dist = new int[words.length + 1];

        // words 안에 target이 있는지 없는지 확인
        if (Arrays.asList(words).contains(target)) {

            // BFS 탐색
            BFS(begin, target, words);
            
            return answer;
        }
        else return 0;
    }

    static void BFS(String begin, String target, String[] words){
        Queue<Node> queue = new LinkedList<>();
        
        // 방문
        queue.add(new Node( begin,0));

        while(!queue.isEmpty() ){
            Node node = queue.poll();

            if(node.str.equals(target)) return;

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
                    queue.add( new Node( words[i], i+1));
                    dist[i+1] = dist[node.idx] +1;
                    answer = dist[i+1];
                }
            }
        }
    }
}