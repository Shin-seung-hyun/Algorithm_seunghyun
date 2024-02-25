import java.util.*;
import java.io.*;

//Stack
public class Main {

    static class Building{
        int idx,height;

        public Building(int idx, int height){
            this.idx= idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());   // 빌딩수

        Stack<Building> stack = new Stack<>();

        // 79_999 + ... + 1 ~= 32억임으로 long
        long sum = 0;
        for(int i=1; i<=N; i++){
            int h = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek().height <= h){
                sum += i - stack.peek().idx -1;
                stack.pop();
            }

            stack.push(new Building(i,h));
        }


        // 남아 있는 스택 처리
        while(!stack.isEmpty()){
            sum += N - stack.peek().idx;
            stack.pop();
        }

        System.out.println(sum);
    }
}