import java.util.*;
import java.io.*;

//Stack
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());   // 빌딩수

        Stack<Integer> stack = new Stack<>();
        
    //방법1.
        // 79_999 + ... + 1 ~= 32억임으로 long
        long sum = 0;
        for(int i=1; i<=N; i++){
            int height = Integer.parseInt(br.readLine());
            
            // 제일 큰 빌딩 높이를 만났을 때, stack pop
                // 중복일 때도 옥상을 볼 수 없음.
            while(!stack.isEmpty() && stack.peek() <= height){
                stack.pop();
            }
            sum += stack.size();
            
            stack.push(height);
        }
        
        System.out.println(sum);

    //방법2. sum 계산
//        for(int i=1; i<=N; i++){
//            int height = Integer.parseInt(br.readLine());
//
//            while(!stack.isEmpty() && stack.peek() <= height){
//                sum += i - stack.peek() -1;
//                stack.pop();
//            }
//            stack.push(height);
//        }
//        System.out.println(sum);
//        
//        // 남아 있는 스택 처리
//        while(!stack.isEmpty()){
//            sum += N - stack.peek();
//            stack.pop();
//       }
//
//        System.out.println(sum);
    }
}