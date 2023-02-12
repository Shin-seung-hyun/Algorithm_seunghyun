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

    static void twoPointer(){
        int right =0;
        int answer = N;
        int sum = 0;

        for(int left =1; left <= N; left++){

            //right가 조건에 만족할 때까지 증가
            while(right +1 <= N && sum <K){
                right++;
                if(arr[right] ==1 )sum++;

            }
            if(sum ==K){
                answer = Math.min(answer, right - left +1);
            }
            
            //left 감소
            if(arr[left] ==1 )sum--;

        }
        if(answer == N) answer =-1;
        System.out.println(answer);
    }

}