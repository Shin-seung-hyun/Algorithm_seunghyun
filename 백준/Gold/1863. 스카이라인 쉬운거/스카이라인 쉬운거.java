import java.io.*;
import java.util.*;

// Stack
public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int answer =0;
        Stack<Integer> stack = new Stack<>();   // 건물 높이 변화를 확인하기 위해 stack 사용

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            // stack이 비어 있으면 최근 값(stack.peek())과 새로 들어올 값(y)을 비교할 수 없다.
            // 최근 값보다 y가 더 작다면, 최근 빌딩 너비 확정!
            while(!stack.isEmpty() && stack.peek() > y){

                int deleteY = stack.pop();

                // 높이가 0은 건물로 취급하지 X
                if(deleteY == 0) continue;

                // 너비가 확정된 빌딩과 높이가 같은 빌딩은 모두 함께 제거
                if( !stack.isEmpty() && stack.peek() == deleteY) continue;

                answer++;
            }

            stack.push(y);
        }

        // 입력을 다 받았는데 stack 에 건물이 남아 있다면
        //직전까지의 코드에서 마지막에 push를 함으로 마지막으로 들어오는 값의 빌딩 검사가 필요하다.
        while(!stack.isEmpty()){
            int deleteY = stack.pop();
            
            if(deleteY == 0)continue;
            
            if(!stack.isEmpty() && stack.peek() == deleteY)continue;
            
            answer++;
        }

        System.out.println(answer);
    }
}
