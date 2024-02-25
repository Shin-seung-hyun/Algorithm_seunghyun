import java.util.*;
import java.io.*;

//Stack
class Main{

    static class Top{
        int idx;
        int height;

        public Top(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // N개의 높이가 서로 다른 탑
        int N = Integer.parseInt(br.readLine());

        //방법1.
        //Stack<int[]> stack = new Stack<>(); // int[] = {num, height}

        //방법2.
        Stack<Top> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int h = Integer.parseInt(st.nextToken());

            if( i == 1 ){
                stack.push( new Top(1,h ));
                sb.append("0 ");
                continue;
            }

            while(true){
                Top top = stack.peek();

                if(top.height >= h){
                    sb.append(top.idx + " ");
                    stack.push(new Top(i,h));
                    break;
                }
                else stack.pop();

                if( stack.isEmpty()){
                    sb.append("0 ");
                    stack.push(new Top(i,h));
                    break;
                }
            }
        }

        //출력
        System.out.print(sb.toString());
    }
}