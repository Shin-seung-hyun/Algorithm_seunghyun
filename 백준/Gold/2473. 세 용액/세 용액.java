import java.util.*;
import java.io.*;

public class Main {
    static int N;   //용액의 수
    static long[] arr;
    static long[] answer;

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

        long diff = Long.MAX_VALUE;

        // 가장 왼쪽부터 시작해서 가장 오른쪽 끝까지
        for(int i = 1; i <= N-2; i++) {
            int left = i+1;
            int right = N;

            while(left < right) {

                long sum = arr[i] + arr[left] + arr[right];

                // 차이가 더 작다면 원소 저장
                if(Math.abs(sum) < diff) {
                    diff = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if(sum > 0) right--;
                else left++;

            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}