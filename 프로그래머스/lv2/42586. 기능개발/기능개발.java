import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int [] day = new int[progresses.length];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i =0; i< progresses.length; i++){
            day[i]=(100 - progresses[i])/speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0){
                day[i] += 1;
            }
        }

        int pre = day[0];
        int cnt = 1;
        for(int i= 1; i< day.length; i++){
            if(pre < day[i]) {
                arr.add(cnt);
                cnt = 1;
                pre = day[i];
            }
            else {
                cnt++;
            }
        }
        arr.add(cnt);
        
        int [] answer = new int[arr.size()];
        for(int i =0; i< answer.length; i++){
            answer[i] = arr.get(i);
        }
        return answer;
        

    }
}