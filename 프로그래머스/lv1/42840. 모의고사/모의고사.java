import java.util.*;
import java.io.*;

class Solution {
    
    public int[] solution(int[] answers) {

        int[][] pattern = {

            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}    
        };
                
        int[] score = new int [3];

        for(int i=0; i< answers.length; i++){
            
            if( answers[i] == pattern[0][i % 5]) score[0]++;
            if( answers[i] == pattern[1][i % 8]) score[1]++;
            if( answers[i] == pattern[2][i % 10]) score[2]++;
        }
        
        // 최댓값  찾기
        int max = Math.max( score[0], Math.max( score[1], score[2]));
        
        // 높은 점수가 여러명인지 확인
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i=0; i< 3; i++){
            if( max == score[i]) arrList.add( i+1);
        }
        
        // 결과값을 출력
        int []result = new int [arrList.size()];
        for(int i=0; i< arrList.size(); i++) result[i] = arrList.get(i);
        
        return result;
    }
}