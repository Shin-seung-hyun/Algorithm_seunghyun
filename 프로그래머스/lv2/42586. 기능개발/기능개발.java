import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int [] endDay = new int[speeds.length];
        
        for(int i =0; i< speeds.length; i++ ){
            
            int day = (100 - progresses[i]) / speeds[i];
            if( (100 - progresses[i]) % speeds[i] > 0 ){
                day ++;
            }
            endDay[i] = day;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i =0; i< endDay.length; i++){
            
            if( !queue.isEmpty() && queue.peek() < endDay[i]){
                list.add(queue.size());
                queue.clear();
            }
            queue.add(endDay[i]);
        }
        list.add(queue.size());
        
        //ArrayList -> Array
        int [] answer = new int [list.size()];
        for(int i=0; i< list.size(); i++){
            answer[i] = list.get(i).intValue();
        }
        
        return answer;
    }
}