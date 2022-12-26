import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        
        int pick = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums){
            set.add(n);
        }
        
        if(pick <= set.size()) return pick;
        else return set.size();
    }
}