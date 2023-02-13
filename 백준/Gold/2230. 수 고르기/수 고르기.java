import java.io.*;
import java.util.*;

//투 포인터
public class Main{

    static int N;
    static int M;
    static int [] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //1 3 5
        Arrays.sort(arr, 1, N+1);

        twoPointer();

        br.close();
    }

    public static void twoPointer(){

        int right = 1;
        int answer = Integer.MAX_VALUE;

        for(int left = 1; left<=N; left++){

            //right을 이동시키기
            while(right+1 <=N && arr[right] - arr[left] <M){
                right++;
            }

            //정답 갱신
            if(arr[right] - arr[left] >= M ) answer = Math.min(answer, arr[right] - arr[left]);
        }

        System.out.println(answer);
    }
}