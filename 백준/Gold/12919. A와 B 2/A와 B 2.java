import java.util.*;
import java.io.*;

//
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();

        String  S = br.readLine();  // 대상 문자열
        String  T = br.readLine();  // 목표 문자열

        int result = DFS(S, T);

        System.out.println(result);
    }

    /*
        T의 길이를 줄이며 S와 같게 되는지 확인
        1. t.charAt(t.length()-1) == 'A'면, 마지막 글자 A를 뺀다.
        2. t.charAt(0) =='B'면, 맨 앞글자인 B를 빼고 뒤집는다.

    */
    static int DFS(String s ,String t){

    // 종료 조건
        if( s.length() == t.length()){
            if( s.equals(t)) return 1;
            else return 0;
        }

    // 반복조건
        int answer= 0;

        if( t.charAt(t.length()-1) == 'A'){
            answer +=  DFS(s, t.substring(0, t.length()-1));
        }

        if( t.charAt(0) == 'B'){

            String str = t.substring(1);

            StringBuilder sb = new StringBuilder(str);
            String tmp  = sb.reverse().toString();

            answer += DFS(s, tmp);
        }

        if( answer >0) return 1;
        else return 0;

    } // end DFS

}
