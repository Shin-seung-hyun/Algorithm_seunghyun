import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer > map = new HashMap<>();
        
        for(String clothe[] : clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1],1)+1);
        }
        //headgear:2, eyewear:1
        //headgear 경우의 수  0,1,2 /eyewear 경우의 수 0,1 
        for(String key: map.keySet()){
            answer = answer * map.get(key);
        }
        
        return answer-1;
    }
}