import java.util.*;
import java.io.*;

class Solution {
    
    static class Node{
        int idx;
        int value;
    }
    
    public int[] solution(int[] answers) {
        
        int[] score = new int [3];
        
        int[]arr1 = {1,2,3,4,5};
        int[]arr2 = {2,1,2,3,2,4,2,5};
        int[]arr3 = {3,3,1,1,2,2,4,4,5,5};

        for(int i=0; i< answers.length; i++){
            
            if( answers[i] == arr1[i % 5]) score[0]++;
            if( answers[i] == arr2[i % 8]) score[1]++;
            if( answers[i] == arr3[i % 10]) score[2]++;
        }
        
        int max = Math.max( score[0], Math.max( score[1], score[2]));
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i=0; i< 3; i++){
            if( max == score[i]) arrList.add( i+1);
        }
        
        int []result = new int [arrList.size()];
        for(int i=0; i< arrList.size(); i++) result[i] = arrList.get(i);
        
        return result;
    }
}