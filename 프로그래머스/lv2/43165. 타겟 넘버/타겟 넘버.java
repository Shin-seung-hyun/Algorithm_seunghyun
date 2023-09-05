import java.io.*;
import java.util.*;

class Solution {
    
    static int cnt =0;
    static int[] arr;
    public int solution(int[] numbers, int target) {
        
        arr = new int [numbers.length];
        
        DFS( 0, numbers, target);
        
        return cnt;
    }
    
    static void DFS(int depth, int[] numbers, int target){
        
        if( depth == numbers.length){
            
            //if( sum == target)cnt++;
            
            int sum =0;
            for(int val : arr) sum += val;
            
            if( sum == target){
                cnt++;
                //for(int val : arr) System.out.print( val +" ");
            } 
            
            return;
        }
        
        //+일 때
        arr[depth] = numbers[depth];
        DFS(depth+1, numbers, target);
        
        //-일 때
        arr[depth] = numbers[depth] * -1;
        DFS(depth+1, numbers, target);
    }
    
}