import java.util.*;
import java.io.*;

class Solution {
    
    static int N;
    static ArrayList<String> arrList = new ArrayList<>();
    static Character[] chArr = new Character[]{
        'A','E','I','O','U'
    };
    
    public int solution(String word) {
        
        N = word.length();
        
        //중복 O, 순서 O 나열
        DFS(0, "");
        
        // arrList에서 몇번째 단어인지 확인
        int answer =0;
        for(int i=0; i<arrList.size(); i++){
            
            if(arrList.get(i).equals(word)){
                answer = i;
                break;  
            } 
        }
        
        // 정답 출력 
        return answer;
    }
    
    static void DFS(int depth, String str){
        
        arrList.add(str);
        
        //종료조건 
        if( depth == 5){
            return;
        }
        
        //반복 조건
        for(int i =0; i<chArr.length; i++){
            
            DFS(depth+1, str + chArr[i]);
        }
    }
}