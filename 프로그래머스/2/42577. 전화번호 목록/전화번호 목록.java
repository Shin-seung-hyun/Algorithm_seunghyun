import java.util.*;
import java.io.*;

//https://bada744.tistory.com/96
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> hashSet = new HashSet<>();
        
        for(int i=0; i<phone_book.length; i++){
            hashSet.add(phone_book[i]);
        }
        
        
        for(int i=0; i<hashSet.size(); i++){
            for(int j =0; j< phone_book[i].length(); j++){
                
                if( hashSet.contains( phone_book[i].substring(0,j)) ) return false;
            }
        }
        
        
        return true;
    }
}