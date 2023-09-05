import java.util.*;
import java.io.*;

// 이분탐색 -> 매개변수 탐색 알고리즘
    // N명을 심사하는데 걸리는 최소 시간 t는?
    // 시간이 t일 때, N명을 심사할 수 있는가?
class Solution {
    public long solution(int n, int[] times) {

        // times 정렬
        Arrays.sort( times);

        // 이분 탐색
        return search(n, times);
        
    }

    static long search(int n, int[] times){
        
        // 이분탐색
        long left = 1;
        long right = n * (long)times[times.length -1]; // 심사 시간의 최댓값
        long answer = 0;
        
        
        while(left <= right){
            
            long mid = (left + right)/2;
            
            if( Possible(mid, n, times)) { // 심사할 수 있으면 시간 더 줄이기
                right = mid -1;
                answer = mid;
            }
            
            else left = mid +1;
        }
        
        
        return answer;
    }
    
    
    // 제한 시간 안에 심사 n명을 심사할 수 있는지 확인    
    static boolean Possible(long mid, int n, int[] times ){
        
        long sum = 0;
        for(int time : times){
            sum += mid / time;
        }
        
        return sum >= n;
    }
    
}