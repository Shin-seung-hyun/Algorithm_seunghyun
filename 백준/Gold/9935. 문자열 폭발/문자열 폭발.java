import java.io.*;
import java.util.*;

//Stack
public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i =0; i<str.length(); i++){

            stack.push(str.charAt(i));

            if( stack.size() >= bomb.length()){
                boolean check = true;

                for(int j= 0; j< bomb.length(); j++){

                    // stack.get(int idx) idx의 값을 찾아서 반환해줌
                    if( stack.get( stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        check = false;
                        break;
                    }
                }

                if( check){
                    for(int j = 0; j< bomb.length(); j++) stack.pop();
                }
            }

        }
        for( char ch  : stack) sb.append(ch);

        if(sb.length() == 0 ) System.out.println("FRULA");
        else System.out.println(sb.toString());
    }

}