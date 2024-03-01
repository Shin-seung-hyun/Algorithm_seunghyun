import java.util.*;
import java.io.*;

//Stack
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){

            String str = br.readLine();

            //종료 조건
            if( str.equals(".")) break;

            //시작
            char[] charArr = str.toCharArray();

            Stack<Character> stack = new Stack<>();

            boolean isCorrect = true;
            for(char c : charArr){

                switch(c){

                    case '(':
                    case '[':
                        stack.push(c);
                        break;

                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                        else isCorrect = false;
                        break;

                    case ']':
                        if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                        else isCorrect = false;
                        break;
                }
            }
            if(!stack.isEmpty()) isCorrect = false;

            //출력
            if( isCorrect) System.out.println("yes");
            else System.out.println("no");

        }// end while

    }//end main
}
