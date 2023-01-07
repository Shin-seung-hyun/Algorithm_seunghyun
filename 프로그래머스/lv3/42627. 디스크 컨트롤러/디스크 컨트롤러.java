import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int time = 0;

        Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        int i = 0;
        while(count < jobs.length){
            while (i< jobs.length && jobs[i][0] <= time){
                queue.add(jobs[i++]);
            }

            if(queue.isEmpty()){
                time = jobs[i][0];
            }
            else{
                int[] tmp = queue.poll();
                answer += tmp[1] + time - tmp[0];
                time += tmp[1];
                count++;
            }
        }

        return answer/ jobs.length;
    }
}