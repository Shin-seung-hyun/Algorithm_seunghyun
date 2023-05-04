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
        int result = -100 * N;
        int sum = 0;
        int right =1;

        for(int left =1; left <= N-K +1; left++){

            while(right <=N && (right- left)+1 <=K){
                sum = sum + arr[right];
                right++;
            }

            result = Math.max(result,sum);

            sum = sum - arr[left];
        }

        System.out.println(result);
    }

}