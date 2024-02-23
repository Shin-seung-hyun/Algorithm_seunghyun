import java.util.*;
import java.io.*;

//Stack
    // 스택을 구현하는 방식에는 Array(배열), LinkedList(연결 리스트) 2가지가 있다.
class Main{
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //배열로 stack 구현하기
        int[] stack = new int[N];
        int idx =0; // 다음 원소를 추가할 곳을 가리킴.

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            switch (op){
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    stack[idx] = num;
                    idx++;
                    break;

                case "pop" :
                    if(idx == 0) sb.append("-1").append("\n");
                    else {
                        idx--;
                        sb.append(stack[idx]).append("\n");
                    }
                    break;

                case "size" :
                    sb.append(idx).append("\n");
                    break;

                case "empty" :
                    if( idx == 0) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;

                case "top" :
                    if( idx ==0) sb.append("-1").append("\n");
                    else sb.append(stack[idx-1]).append("\n");
                    break;
            }
        }

        //출력
        System.out.print(sb.toString());

    }//end main
}