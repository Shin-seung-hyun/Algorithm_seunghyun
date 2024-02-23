import java.util.*;
import java.io.*;

//Stack
class Main{
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        //Stack 선언
        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<=K; i++){
            int num = Integer.parseInt(br.readLine());

            if( num == 0) stack.pop();
            else stack.push(num);
        }

        int sum =0;
        for(int num : stack) sum += num;
        System.out.println(sum);

    }
}