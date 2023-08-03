import java.io.*;
import java.util.*;

//투 포인터
public class Main{

    static int N, M;
    static int[]arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i = 1; i<= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        twoPointer();

        br.close();
    }
    public static void twoPointer() {

        int right = 1;
        int sum = 0;
        int cnt = 0;

        for (int left = 1; left <= N; left++) {

            while (right <= N && sum < M) {
                sum = sum + arr[right];
                right++;
            }

            if (sum == M) cnt++;

            sum = sum - arr[left];
        }

        System.out.println(cnt);
    }
    static void twoPointer(){
        int right =0;
        int answer =0;
        int sum = 0;

        for(int left =1; left <=N; left++){
            
            sum = sum - arr[left -1];

            while(right +1 <= N && sum < M){
                sum = sum + arr[++right];
            }
            
            if(sum == M) answer++;
        }
        System.out.println(answer);
    }

}