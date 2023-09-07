class Solution {
    public int[] solution(int brown, int yellow) {
    
        int[] answer = new int[2];
        
        // 노란색의 약수 구하기
        for(int i=1; i<= Math.sqrt(yellow); i++){
            
            if( yellow % i == 0){
                
                //노란색 격자의 가로, 세로
                int x = yellow/i;
                int y = i;
                
                if( x < y ) continue;
                
                // (가로 +2) * (세로 +2) == yellow + brown  
                if( (x+2) * (y+2) != yellow + brown) continue;
                
                answer[0] = x+2;
                answer[1] = y+2;
            }
        }
        
        return answer;
    }
}