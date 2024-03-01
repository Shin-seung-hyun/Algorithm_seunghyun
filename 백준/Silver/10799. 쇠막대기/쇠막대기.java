import java.io.*;
import java.util.*;

//Stack
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char[] charArr = br.readLine().toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            
            if (charArr[i] == '(') {
                stack.push(charArr[i]);
            }

            else { // ')' 인 경우

                if (charArr[i-1] == '(') { // (괄호의 짝이 맞는) 레이저의 경우
                    stack.pop();
                    answer += stack.size(); // Stack 내, ( 막대수 더하기
                }

                else { // 막대 끝일 경우
                    stack.pop();
                    answer += 1; //막대의 끝이므로 1을 더함
                }
            }
        }

        System.out.println(answer);
    }
}