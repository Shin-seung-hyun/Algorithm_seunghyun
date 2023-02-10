import java.io.*;

public class Main{
    
     static int N;
     static int[] cnt;
     static int kind;
     static String str;
     
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        cnt = new int[26];
        
        twoPointer();
    }
    
    // x 알파벳 개수 증가
    static void add(char x){
         cnt[x -'a']++;
    }
    
    // x 알파벳 개수 감소
    static void erase(char x){
         cnt[x -'a']--;
    }
    static void twoPointer(){
         int left = 0; 
         int answer =0;
         
         for(int right = 0; right < str.length(); right++){
             
             //right를 오른쪽으로 이동
             add(str.charAt(right));
             
             //kind 와 N 비교
                //kind 가 N 이하이면 kind 가 N보다 클 때까지 right를 오른쪽으로 이동
             while(true){
                 
                 kind = 0;
                 
                 for(int i =0; i<26; i++){
                     if(cnt[i] != 0) kind++;
                 }
                 
                 if(kind > N){
                     
                     //left를 이동
                     erase(str.charAt(left));
                     left++;

                 }
                 else {
                     //kind <= N
                     break;
                 }
             }
             
             //정답 갱신
             answer = Math.max(answer, right - left +1);
         }

        System.out.println(answer);
    }

}