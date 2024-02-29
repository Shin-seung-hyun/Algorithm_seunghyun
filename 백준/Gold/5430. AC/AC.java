import java.util.*;
import java.io.*;

//Deque
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {

            //수행할 함수
            char[] p = br.readLine().toCharArray();

            // 배열에 들어 있는 수
            int N = Integer.parseInt(br.readLine());

            /* 방법1 */
            //str.substring(beginIdx 포함, endIdx 미포함)
            String str = br.readLine();
            String[] arr = str.substring(1, str.length()-1).split(",");

            LinkedList<Integer> dq = new LinkedList<>();
            for(int i=0; i<N; i++) dq.add( Integer.parseInt(arr[i]));

            /* 방법2 */
            st = new StringTokenizer(br.readLine(), "[],");

            LinkedList<Integer> dq = new LinkedList<>();
            for(int i = 0; i < N; i++) dq.add(Integer.parseInt(st.nextToken()));
        }


        boolean isReverse = false;
        boolean isError = false;
        for(char op : p){

            if(op == 'R'){  //R : 순서를 뒤집기
                isReverse = !isReverse;
            }
            else{ //op == 'D, 첫 번째 수를 버리기, 단, 비어 있으면 error 출력

                if( dq.isEmpty()){
                    isError = true;
                    break;
                }
                else{
                    if( isReverse) dq.removeLast();
                    else dq.removeFirst();
                }

            }
        }

        //출력
        if(isError)sb.append("error\n");
        else {

            sb.append("[");
            while(!dq.isEmpty()) {

                if (isReverse) sb.append(dq.removeLast());
                else sb.append(dq.removeFirst());

                if(dq.size()!=0)
                    sb.append(",");
            }
            //if( sb.charAt(sb.length()-1) == ',') sb.deleteCharAt( sb.length()-1);
            sb.append("]\n");
        }

    }// end testCase

        System.out.print(sb.toString());
}
}
