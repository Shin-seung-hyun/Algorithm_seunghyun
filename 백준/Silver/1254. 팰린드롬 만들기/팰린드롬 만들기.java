import java.util.*;
import java.io.*;

//문자열
// 가장 짧은 팰린드롬(앞서 읽으나 뒤에서 읽으나 같게 읽히는 문자열)
    // 문자가 팰린드롬인지 아닌지 확인
    // -> 팰린드롬이라면 앞에서 자른 문자열의 수만큼을 추가한 길이가 정답
    // -> 팰린드롬인 아니라면 앞에서 한 문자씩 자르면서 팰린드롬인지 확인

/*
문자열 자르기
    String substring(int beginIndex, int endIndex)
    beginIndex 포함, endInedx 미포함해서 문자열 자르기
*/
public class Main {

    static String S;    // 문자열
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        answer = S.length();

        for(int i =0; i< S.length(); i++){

        // 팰린드롬인지 확인
            // 팰린드롬이라면 끝
            if (isPalind(S.substring(i))) break;

            // 팰린드롬이 아니라면 팰린드롬의 길이 더하기
            answer++;
        }

        System.out.println(answer);
    }

    static boolean isPalind(String str){
        int left = 0;
        int right = str.length()-1;

        while(left <= right){

            // 다른게 있다면 팰린드롬이 아님
            if(str.charAt(left) != str.charAt(right)) return false;

            left++;
            right--;
        }

        // 끝까지 탐색했는데 모든 게 같다면 팰린드롬
        return true;
    }

}