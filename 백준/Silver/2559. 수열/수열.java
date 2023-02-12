import java.io.*;
import java.util.*;

//투 포인터
public class Main{

    static int N;
    static int K;
    static int [] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();

        br.close();
    }

    public static void twoPointer(){
        int answer = -100 * N;
        int sum = 0;
        int right =0;
        for(int left = 1; N - left +1 >= K; left++){

            //left 빼기
            sum -= arr[left-1];

            //right 옮길 수 있을 때까지 증가시키기
            while(right+1 <=N && right - left +1 <K){
                sum += arr[++right];
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

}