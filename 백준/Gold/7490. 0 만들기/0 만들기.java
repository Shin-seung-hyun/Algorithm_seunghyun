import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int t =1; t<= testCase; t++){

            N = Integer.parseInt(br.readLine());

            sb = new StringBuilder();

            DFS(1, 1, 0, 1, "1");

            System.out.println(sb.toString());
        }
    }
    static void DFS(int depth, int num, int sum, int op, String str) {

        // 종료 조건
        if(depth == N) {
            sum += (num * op);

            if(sum == 0) sb.append(str+"\n");

            return;
        }

        // 반복 조건
        DFS(depth + 1, num * 10 + depth + 1, sum, op, str + " " + (depth + 1));
        DFS(depth + 1, depth + 1, sum + (num * op), 1,str+"+"+  (depth + 1));
        DFS(depth + 1, depth + 1, sum + (num * op), -1, str+"-"+ (depth + 1));

    }
}