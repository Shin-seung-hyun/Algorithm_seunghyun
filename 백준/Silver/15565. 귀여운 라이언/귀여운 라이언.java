import java.io.*;
import java.util.*;

//투 포인터
public class Main{

    static int N;   //N개의 인형
    static int K;   //K개의 라이언 인형
    static int []arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();

        br.close();
    }

    public static void twoPointer(){
        int right = 0;
        int cnt = 0;
        int result  = N;

        for(int left = 1; left <=N; left++){

            while(cnt < K && right< N){
                right++;
                if(arr[right] ==1) cnt++;
            }

            if(cnt >= K){
                result = Math.min(right - left + 1, result);
            }

            if(arr[left] ==1) cnt--;
        }

        if(result == N) result = -1;
        System.out.println(result);
    }

}