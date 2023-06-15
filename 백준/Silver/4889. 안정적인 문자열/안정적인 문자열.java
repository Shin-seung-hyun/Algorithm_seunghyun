import java.util.*;
import java.io.*;

//문자열
    // "{" 라면 stack.push()
    // "}" 라면 stack.pop()
    // 단, "}" 를 pop 할 때, "{" 가 stack에 들어 있지 않다면 "}" -> "{" 로 변경해서 stack에 저장
    // 문자열을 다 돌았을 때, stack이 비어 있다면 0 (안정적인 문자열), stack이 비어있지 않다면 stack.size()/2
    // 입력이 }{ 으로 들어왔다면 stack에는 {{ 이 저정되어 있음

/*
    boolean contains(CharSequence s)
    특정 문자열이 포함되어 있는지 확인하는 함수
    대소문자 구분
*/
public class Main {
    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 1;
        while(true){
            str = br.readLine();
            if(str.contains("-")) break;

            isStable(str, index);

            index++;
        }

        System.out.print(sb.toString());
    }

    static void isStable(String s, int index) {
        Stack<String> stack = new Stack<>();

        // } 에서 { 로 바꾼 횟수 저장
        int cnt = 0;
        for(int i =0; i< s.length(); i++){

            if( s.charAt(i) == '{') stack.push("{");

            // s 가 '}' 라면
            else{

                if(stack.isEmpty()){
                    cnt++;
                    stack.push("{");
                }
                else stack.pop();
            }
        }

        // cnt + { 에서 } 로 바꿔야될 횟수, stack.size()/2
        if( !stack.isEmpty() ) cnt += stack.size()/2;

        sb.append(index +". " + cnt ).append("\n");
    }

}