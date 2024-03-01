import java.util.*;
import java.io.*;

//Deque
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
            boolean isCorrect = true;

            char[] charArr = str.toCharArray();

            Stack<Character> stack = new Stack<>();

            for(char c : charArr){

                if (c == '(' || c == '[') stack.push(c);
                else if ( c == ')' || c ==']' ){

                    if(stack.isEmpty()) isCorrect = false;
                    else if ( ( stack.peek() == '(' && c == ')' ) ||
                              ( stack.peek() == '[' && c == ']' )  ){

                        stack.pop();
                    }
                    else  isCorrect = false;

                }
            }

            if(!stack.isEmpty()) isCorrect = false;

            //출력
            if(isCorrect) System.out.println("yes");
            else System.out.println("no");

        }// end while

    }//end main
}
