import java.io.*;
import java.util.*;

// 이분탐색(매개변수 탐색 알고리즘)
    // 바위를 N개 제거한 뒤, 각 지점 사이의 거리의 최솟값 중 가장 큰 값은?
    // 각 지점 사이의 거리의 최솟값이 d일때, N개의 바위가 제거 되는가?

class Solution {
    
    public int solution(int distance, int[] rocks, int N) {
        
        
        // 바위 배열 정렬
        Arrays.sort(rocks);
        
        
        // 매개변수 탐색 알고리즘
        int left = 1;
        int right = distance;
        int result = 0;
        
        while(left <= right){
            
            int mid = (left + right)/2;
            
            if( Possible(mid, distance,rocks, N) ){
                left = mid +1;
                result = mid;
            }
            else 
                right = mid -1;
        }
        
        // 정답 출력
        return result;
    
    }
    
    static boolean Possible(int mid, int distance, int[] rocks, int N){
        
        int cnt = 0; // 삭제되는 바위의 수 
        int pre = 0;
        
        for(int i=0; i< rocks.length; i++){
            if( rocks[i] - pre < mid ){
                cnt++;
            }
            else pre = rocks[i];
        }
        if( distance - pre < mid) cnt++;
        
        return cnt <= N;
    }
}