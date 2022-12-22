import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> arrList = new ArrayList<>();
        int preNum = 10;
        
        for(int num : arr){
            if(preNum != num){
                arrList.add(num);
            }
            preNum = num;
        }
        
        //ArrayList -> Array
        int [] answer = new int[arrList.size()];
        
        for(int i=0; i< answer.length; i++){
            answer[i] = arrList.get(i).intValue();
        }

        return answer;
    }
}