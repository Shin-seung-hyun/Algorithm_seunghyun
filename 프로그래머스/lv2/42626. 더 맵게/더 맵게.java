import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        
        for(int food : scoville) pq.add(food);
        
        while(pq.peek() < k){
            if(pq.size() <= 1) return -1;
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.add(first + second*2);
            cnt++;
        }
        
        return cnt;
    }
}