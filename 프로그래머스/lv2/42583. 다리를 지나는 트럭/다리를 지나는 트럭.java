import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum =0;

        Queue<Integer> queue = new LinkedList<>();

        for(int t :truck_weights ){
            while(true){
                //큐가 비었을 때
                if(queue.isEmpty()){
                    queue.add(t);
                    time++;
                    sum+=t;
                    break;
                }
                //큐가 차있을 때
                else{
                    // 큐의 사이즈와 다리의 길이가 같을 때 (큐에 트럭이 다 올라가 있을 때)
                    if(queue.size() == bridge_length ){
                        int move = queue.poll();
                        sum = sum - move;
                    }
                    // sum <= weight 다음 트럭이 무게 이내일 때
                    else if (sum +t <= weight){
                        queue.add(t);
                        time++;
                        sum = sum + t;
                        break;
                    }
                    //sum > weight 다음 트럭이 무게 초과일 때
                    else{
                        queue.add(0);
                        time++;

                    }
                }
            }
        }

        //걸린 시간 = time + 마지막 트럭의 통과 시간(=다리의 길이)
        return time + bridge_length;
    }
}