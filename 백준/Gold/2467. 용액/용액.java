import java.io.*;
import java.util.*;

// 투 포인터, 이분 탐색 알고리즘
    // 투포인터
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

        twoPointer();
    }

    static void twoPointer(){
        int left = 1;
        int right = N;

        long Mix = Integer.MAX_VALUE;
        int resultX =arr[left], resultY = arr[right];

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
