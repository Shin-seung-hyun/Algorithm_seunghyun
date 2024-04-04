import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());   // A 진법
        int B = Integer.parseInt(st.nextToken());   // 정이가 사용하는 B 진법

        int m = Integer.parseInt(br.readLine());    // A 진법으로 나타낸 숫자의 자리수

        int value = 0;  // 10진법으로 나타냈을 때

        //A 진법 -> 10진법
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            value += (Math.pow(A,m-1) * Integer.parseInt(st.nextToken()) );
            m--;
        }

        //System.out.println(value);

        if(value == 0) System.out.println(0);

        //10진법 -> B진법
        Stack<Integer> stack =  new Stack<>();
        while(value != 0){

            stack.push(value % B);

            value /= B;
        }

        while(!stack.isEmpty()){

            System.out.print(stack.pop()+ " ");
        }

    }
}
