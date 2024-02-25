import java.util.*;
import java.io.*;

//Stack
class Main{
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // N개의 높이가 서로 다른 탑
        int N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>(); // int[] = {num, height}

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int h = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                stack.push(new int[]{i, h});
                sb.append("0 ");
            }
            else{
                if( stack.peek()[1] > h ){
                    sb.append(stack.peek()[0] + " ");
                    stack.push(new int[]{i,h});
                }
                else{
                    //큰 거 찾을 때까지 pop
                    while(stack.peek()[1] < h){
                        stack.pop();
                        if( stack.isEmpty()) {
                            sb.append("0 ");
                            break;
                        }
                    }

                    if(!stack.isEmpty())sb.append(stack.peek()[0] + " ");

                    stack.push(new int[]{i,h});
                }
            }
        }

        System.out.print(sb.toString());
    }
}