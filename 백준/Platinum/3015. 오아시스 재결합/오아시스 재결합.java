import java.util.*;
import java.io.*;

//Stack
    //서로 볼 수 있는 쌍의 수
public class Main {

    static class Pair{
        int height; //키
        int cnt;    // 같은 키의 사람이 몇 번 등장했는지

        public Pair(int height, int cnt ){
            this.height = height;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Pair> stack = new Stack<>();

        long answer = 0;   // 키가 전부 내림차순일 때, 갯수 = n(n+1)/2 임으로 long의 범위
        for(int i=1; i<=N; i++){
            int h = Integer.parseInt(br.readLine());
            
            // new Pair(h,cnt)에 저장될 나와 같은 키의 사람 카운트
            int cnt = 1;
            
             while(!stack.isEmpty() && stack.peek().height <= h){

                 //원래는 answer++이지만 중복되는 키를 가진 사람도 저장하기 위해 stack.peek().cnt를 더함.
                 answer += stack.peek().cnt;

                 if( stack.peek().height == h) cnt += stack.peek().cnt;

                 stack.pop();
             }

            // stack이 비어있지 않다
                //  = 스택의 최상단에 있는 사람의 키  > 현재 입력으로 들어온 사람의 키
                // 현재 처리하고 있는 사람과 짝을 이룰 수 있음으로 answer++
            if(!stack.isEmpty()) answer++;

            stack.push(new Pair(h,cnt));
        }

        System.out.println(answer);


    }
}