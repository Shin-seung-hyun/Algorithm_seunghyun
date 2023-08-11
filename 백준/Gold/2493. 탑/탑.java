import java.util.*;
import java.io.*;

//Stack
public class Main{

    static int N;

    static class Top{
        int height;
        int idx;

        public Top(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());   // 탑의 수

        Stack<Top>  stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){

            int h = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){ // 탑이 없다면
                sb.append("0 ");
                stack.push(new Top(i, h));
            }
            else{               // 탑이 있다면

                while(true) {

                    // stack의 peek 과 현재 h 비교
                    Top pre = stack.peek();

                    if (pre.height >= h) {
                        sb.append(pre.idx + " ");
                        stack.push(new Top(i, h));
                        break;
                    }
                    else stack.pop();

                    if(stack.isEmpty()){ // 탑이 없다면
                        sb.append("0 ");
                        stack.push(new Top(i, h));
                        break;
                    }

                }// end while
            }
        } // end for

        //  출력
        System.out.println(sb.toString());
    }
}
