import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int time = 0;
        int sum = 0; 
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int truck_weight : truck_weights){
            while(true){
                
                //큐가 비어 있을 때
                if(queue.isEmpty()){
                    queue.add(truck_weight);
                    sum += truck_weight;
                    time++;
                    break;

                }
                // 큐의 크기와 다리 길이가 같을 때
                else if (queue.size() == bridge_length){
                        sum -= queue.poll();
                }
                //큐가 차있을 때
                else{
                    //최대 무게를 초과했을 때
                    if(sum + truck_weight > weight){
                        queue.add(0);
                        time++;

                    }
                    //최대 무게 이내일 때
                    else{
                        queue.add(truck_weight);
                        sum += truck_weight;
                        time++;
                        break;

                    }
                }
                
            }  
        }

        return time + bridge_length ;
    }
}