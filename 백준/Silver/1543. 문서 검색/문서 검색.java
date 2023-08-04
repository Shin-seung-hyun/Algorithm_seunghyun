import java.io.*;
import java.util.*;

// 문자열
// 영어 이름의 배열을 변경하여 팰린드롬으로 바꾸기
public class Main {

    static String input;
    static String find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        input = br.readLine();
        find = br.readLine();

    // 방법1. 완전탐색
        int answer = 0;
        for(int i=0; i + find.length()-1 < input.length(); i++){

            answer = Math.max ( answer ,check( input.substring(i) ) );
        }

        System.out.println(answer);


    // 방법2. repalce

        // 처음 input 길이 저장
        int inputLen = input.length();

        // find 문자열 지우기
        String str = input.replace( find, "");

        int result = (inputLen - str.length() ) / find.length();

        System.out.println(result);

    }

    static int check( String str){

        int cnt = 0;
        int idx = 0 ;
        for(int i = 0; i< str.length(); i++){

            if( find.charAt(idx) == str.charAt(i)) idx++;
            else idx =0;

            if( idx == find.length()){
                cnt ++;
                idx =0;
            }
        }

        return cnt;
    }

}
