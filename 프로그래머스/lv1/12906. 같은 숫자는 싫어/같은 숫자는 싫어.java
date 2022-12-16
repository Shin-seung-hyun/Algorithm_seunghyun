import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        int tmp = -1;
        
        for(int n : arr){
            if(tmp !=n){
                answer.add(n);
                tmp = n;
            }
        }
        return answer;
        
    }
}