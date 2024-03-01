import java.io.*;
import java.util.*;

//Stack
    // ( ( ) [ [ ] ] )  ( [ ] )
    // 2 * ( 2 + 3 * 3) + (2 * 3)
    // 분배 법칙 이용
    // 4 + (6 * 3) + 6
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        int answer = 0;
        int sum = 1;     // 현재 괄호의 값
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);
            switch(c){
                case '(':
                    sum *= 2;
                    stack.push( c );
                    break;

                case '[':
                    sum *= 3;
                    stack.push( c);
                    break;

                case ')':

                    //종료 조건
                    if(stack.isEmpty() || stack.peek() != '('){
                        System.out.println("0");
                        return;
                    }

                    if(str.charAt(i-1)== '(')  // 바로 앞이 '('이면 값이 2배로 증가
                        answer += sum;
                    
                    stack.pop();
                    sum /= 2;

                    break;

                case ']':

                    // 종료 조건
                    if(stack.isEmpty() || stack.peek() != '['){
                        System.out.println("0");
                        return;
                    }

                    if(str.charAt(i-1) == '[') // 바로 앞이 '['이면 값이 3배로 증가
                        answer += sum;

                    stack.pop();
                    sum /=3;

                    break;
            }

        }

        if(stack.isEmpty()) System.out.println(answer);
        else System.out.println("0");
    }
}