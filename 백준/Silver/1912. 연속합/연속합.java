import java.util.*;
import java.io.*;

class Main{
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dy = new int[N + 1];
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        //초기값
        dy[1] = arr[1];

        //dy[i] : i 번째를 포함하고 i번째 까지의 합 중 가장 큰 값

        //점화식
        int answer = dy[1];
        for (int i = 2; i <= N; i++){

            //(이전까지 더한 합 + 현재 값) vs 현재 값 중에 더 큰 값을 dy에 저장
            dy[i] = Math.max(dy[i - 1] + arr[i], arr[i]);
            answer = Math.max(dy[i], answer);
        }

        System.out.println(answer);
    }
}