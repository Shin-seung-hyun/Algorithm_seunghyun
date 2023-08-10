import java.util.*;
import java.io.*;

// 투포인터, 슬라이딩 윈도우
public class Main{

    static int K;
    static ArrayList<Integer> [] alphaArrList = new ArrayList[26];
    static int minLen, maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int t=1; t<=testCase; t++) {
            String str = br.readLine();
            K = Integer.parseInt(br.readLine());

        // 1. 초기화
            minLen = Integer.MAX_VALUE;
            maxLen = Integer.MIN_VALUE;

            // 모든 alphaArrList[i]에 같은 ArrayList<>()를 넣는 것으로 안됨!!
            //Arrays.fill(alphaArrList, new ArrayList<>());

            for(int i=0; i<26; i++) alphaArrList[i] = new ArrayList<>();

            // 해당 알파벳 배열에 알바벳의 위치 저장
            for(int i=0; i< str.length(); i++){
                alphaArrList[str.charAt(i) - 'a'].add(i);
            }

        // 2. 투 포인터
            for(int i = 0; i< 26; i++){
                if( alphaArrList[i].size() >= K){
                    twoPointer(i);
                }
            }

        // 3. 출력
            if( minLen == Integer.MAX_VALUE)System.out.println(-1);
            else System.out.println(minLen + " "+ maxLen);

        } // end testCase

    }
    
   
    static void twoPointer(int idx){

        ArrayList<Integer> arrList = alphaArrList[idx];
        /*
            input : abaaaba
                    3

            alphaArrList[0] = 5 -> a의 수
            alphaArrList[1] = 2 -> b의 수 
                          
            arrList[0] = 1 2 3 4 6 -> a의 위치 모음
        */

        //알파벳의 갯수를 K개로 유지하기 위해 start와 end의 차이를 k로 설정
        int start = 0;
        int end = K - 1;
        
        while(end < arrList.size()){
            minLen = Math.min(minLen,arrList.get(end) - arrList.get(start) + 1);
            maxLen = Math.max(maxLen,arrList.get(end) - arrList.get(start) + 1);

            start++;
            end++;
        }
    } // end twoPointer()

}
