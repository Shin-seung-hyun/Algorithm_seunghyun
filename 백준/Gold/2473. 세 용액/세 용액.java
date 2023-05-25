import java.util.*;
import java.io.*;

public class Main {
    static int N;           //용액의 수
    static long[] arr;      //용액 배열
    static long[] answer;   //결과 값
    static long interval;   //용액을 합친 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        answer = new long[3];
        arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //-97 -6 -2 6 98
        Arrays.sort(arr,1,N+1);

        //첫번재 용액의 위치(i) 정하고, 두 포인터를 이용하여 나머지 두 용액 정하기
        interval = Long.MAX_VALUE;

        // 가장 왼쪽부터 시작해서 가장 오른쪽 끝까지
        for(int i = 1; i <= N-2; i++) {
            twoPointer(i);
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }


    static void twoPointer(int i){
        int left = i+1;
        int right = N;

        while(left < right) {

            // arr,asnwer 배열이 int 라면 아래와 같이 해야 함.
            //long sum = Long.valueOf(arr[i] + Long.valueOf(arr[left] + arr[right]));
            long sum = arr[i] + arr[left] + arr[right];

            if(Math.abs(sum) < interval) {

                interval = Math.abs(sum);

                answer[0] = arr[i];
                answer[1] = arr[left];
                answer[2] = arr[right];
            }

            if(sum > 0) right--;
            else left++;

        }
    }

}