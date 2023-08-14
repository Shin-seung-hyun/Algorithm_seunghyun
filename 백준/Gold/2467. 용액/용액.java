import java.io.*;
import java.util.*;

// 투 포인터, 이분 탐색 알고리즘
// 산성 : 10억 , 알칼리성 : -10억
public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());   // 전체 용액의 수

        st = new StringTokenizer(br.readLine());
        arr = new int [N+1];
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        //twoPointer();

        search();
    }

    // 이분 탐색 풀이
    static void search(){

        long mix = Long.MAX_VALUE;
        int resultX = 0, resultY = 0;

        for(int i=1; i<=N; i++) {
            int left = i + 1;
            int right = N;

            while (left <= right) {

                int mid = (left + right) / 2;

                if (mix > Math.abs(arr[i] + arr[mid])) {
                    mix = Math.abs(arr[i] + arr[mid]);

                    resultX = arr[i];
                    resultY = arr[mid];
                }

                if (arr[mid] >= -arr[i]) right = mid - 1;
                else left = mid + 1;
            }
        }

        System.out.println(resultX +" " + resultY);
    }



    // 투 포인터 풀이
    static void twoPointer(){
        int left = 1;
        int right = N;

        long Mix = Long.MAX_VALUE;
        int resultX = arr[left], resultY = arr[right];

        while( left < right){


            if( Math.abs(Mix) > Math.abs( arr[left] + arr[right] )){

                Mix = Math.abs( arr[left] + arr[right] );
                resultX = arr[left];
                resultY = arr[right];
            }

            if(arr[left] + arr[right] < 0 )  left++;

            else if (arr[left] + arr[right] > 0) right--;

            else{   // arr[left] + arr[right] == 0
                break;
            }
        }

        System.out.println(resultX +" " + resultY);
    }

}
