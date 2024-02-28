import java.util.*;
import java.io.*;

//Stack
public class Main {

    static class Pair {
        int idx;    // 넓이 계산 시, 가로 길이를 알기 위해 선언
        int height;

        Pair( int idx, int h) {
            this.idx = idx;
            this.height = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0) break;

            long answer = 0; // 가장 큰 직사각형의 넓이
            Stack<Pair> stack = new Stack<>();

            for(int i =1; i<=N; i++){
                int h = Integer.parseInt(st.nextToken());
                int curIdx = i-1; // 넓이 계산 시, 시작할 idx 저장

                // 이전 체인의 높이(stack.peel())보다 현재 히스토그램 높이(h)가 작거나 같을 경우,
                    // i번째 막대보다 작은 이전 체인들을 pop하면서 최대 넓이를 구해준다.
                    //단, 넓이는 pop되는 요소의 인덱스 바로 앞까지가 넓이를 구해야 함으로 i-1
                while(!stack.isEmpty() && stack.peek().height >= h){

                    long rectangle = (long)(i-1 - stack.peek().idx) *  stack.peek().height;

                    curIdx = stack.peek().idx;
                    answer = Math.max(answer,rectangle);

                    stack.pop();
                }

                stack.push(new Pair(curIdx,h ));
            }

            //Stack에 남아있는 체인들이 존재하면, 나머지도 위와 같은 과정을 거친다.
            while(!stack.isEmpty()){
                answer = Math.max(answer, (long) (N- stack.peek().idx) * stack.peek().height);

                stack.pop();
            }

            System.out.println(answer);
        }
    }
}