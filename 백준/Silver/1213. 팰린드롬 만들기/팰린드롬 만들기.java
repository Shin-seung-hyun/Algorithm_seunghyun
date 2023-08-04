import java.io.*;
import java.util.*;

// 문자열
// 영어 이름의 배열을 변경하여 팰린드롬으로 바꾸기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();

        int []alpha = new int [26];

        for(int i=0; i< str.length(); i++){
            alpha[str.charAt(i)- 'A']++;
        }

        // 글자 수가 짝수 -> 홀수 0개
        // 글자 수가 홀수 -> 홀수 1개
        int checkOdd = 0;
        for(int i =0; i< alpha.length; i++){
            if ( alpha[i] % 2 == 1) checkOdd++;
        }

        // 팰린드롬을 만들 수 없을 때
        if( (str.length() % 2 ==0 && checkOdd !=0) || (str.length() % 2 ==1 && checkOdd != 1 ) ){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

     // 팰린드롬 만들기
        // front
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< alpha.length; i++){

            for(int j = 0; j< alpha[i] /2; j++){
                sb.append( (char)(i + 'A') ) ;
            }
        }

        // mind
        String s = "";
        for(int i= 0; i< alpha.length; i++){
            if( alpha[i] % 2 == 1){
                s = String.valueOf( (char)( i + 'A') );
            }
        }

        //end
        // sb.reverse().toString();

        // 출력 ( front + mid + end)
        System.out.println(sb.toString() + s  + sb.reverse().toString() );
    }

}
