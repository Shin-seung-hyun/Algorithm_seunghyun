import java.util.*;
import java.io.*;

//이분 탐색
    //매개 변수 탐색 알고리즘
    //K 명에게 최대한 많은 막거리를 나눠줄 수 있는 용량은?
    //용량이 []이면, K명에게 나눠줄 수 있는가?
public class Main{

    public static int N;        //주전자 수
    public static int K;        // 사람 수
    public static int arr[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int [N+1];
        for(int i =1; i<=N ;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        search();

        br.close();
    }

    public static boolean determination(long x){

        if(x == 0) return false;

        long cnt = 0;
        for(int i =1; i<= N; i++){
            cnt += arr[i]/x;
        }

        return cnt >= K;
    }

    public static void search(){

        // 0 <= 막걸리의 용량 <= 2^31 -1
        /*
          input:    1 1
                    1
          output:   1
          --------------------
          input :   1 1
                    0
          output:   0
        */
        long left = 0;
        long right = Integer.MAX_VALUE;
        long result = 0;

        while(left <= right){
            long mid = (left + right)/2;

            if(determination(mid)){
                left = mid + 1;
                result = mid;
            }
            else{
                right = mid -1;
            }
        }
        System.out.println(result);
    }

}