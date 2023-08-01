import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //String -> Stack
        String str = br.readLine();

        Stack<Character> LStack = new Stack<>();
        Stack<Character> RStack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            LStack.push(str.charAt(i));
        }

        int cnt = Integer.parseInt(br.readLine());

        for(int i=1; i<=cnt; i++){
            st = new StringTokenizer(br.readLine());

            char ch = st.nextToken().charAt(0);

            switch(ch){
                case 'L' :      // 커서를 왼쪽으로 옮김
                    if( !LStack.isEmpty()) RStack.push(LStack.pop());
                    break;

                case 'D' :      // 커서를 오른쪽으로 옮김
                    if( !RStack.isEmpty()) LStack.push(RStack.pop());
                    break;

                case 'B' :      // 커서의 왼쪽 문자 삭제
                    if( !LStack.isEmpty()) LStack.pop();
                    break;

                case 'P' :      // 문자를 왼쪽에 추가
                    LStack.push(st.nextToken().charAt(0));
                    break;
            }// end switch
        }// end for

        // 출력
        while( !LStack.isEmpty() ) RStack.push(LStack.pop());

        while( !RStack.isEmpty() ) sb.append(RStack.pop());
        System.out.println(sb.toString());
    }
}

