import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] visit;
    static int[] arr;
    static ArrayList<Integer> arrList = new ArrayList<>();
    
    public int solution(String numbers) {
        
        arr = new int[numbers.length()];
        visit = new boolean[numbers.length()];
        
        for(int i=0; i<arr.length; i++) arr[i] = numbers.charAt(i) - '0';
        
        
        // DFS로 중복 X, 순서 O 나열
            // 12 13 14 ,21 23 24
        
        int answer = 0;
        for(int i=0; i< arr.length; i++){
            DFS(i, 0 , "");
        }
        
        for(int val : arrList) System.out.println( val);
        return arrList.size();
    }
    
    // 소수 판별 알고리즘
    static void check( int number){
        
        if( number == 0 || number == 1 ) return;
        else if ( number == 2 && !arrList.contains(2)){
            arrList.add(2);
            return;
        } 
        else{
            
            for(int i=2; i<= Math.sqrt(number); i++ ){
                if( number % i == 0) return;
            }
        }
        
        arrList.add(number);
    }
    
    // 숫자 만들기
    static void DFS(int x, int depth, String str){
        // 종료 조건
        if( depth == x+1){
            
            int number = Integer.parseInt(str);
            //System.out.println(number);
            
            // 소수 판별
            if( !arrList.contains(number) ) check(number);
            
            return;
        }
        
        
        for(int i=0; i<arr.length; i++){
            
            if( visit[i]) continue;
            
            visit[i] = true;
            DFS(x, depth+1, str + arr[i] );
            visit[i] = false;
        } 
        
    }
}