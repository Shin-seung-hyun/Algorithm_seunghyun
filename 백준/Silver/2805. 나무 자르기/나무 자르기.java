import java.util.Scanner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

//이분탐색 -> 매개 변수 탐색
public class Main{

    public static int N, M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i<= N; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }

        search();

    }

    //나무를 H만큼 잘랐을 때, M 만큼의 값을 얻을 수 있는지 없는지 -> true, false
    public static boolean determination(int H){
        long sum = 0;

        for(int i =1; i<=N; i++){
            if(arr[i]> H) sum+= arr[i] -H;
        }

        return sum >= M;
    }


    //이분 탐색
    public static void search(){

        long left =0;
        long right = 2_000_000_000;
        long result = 0;

        while(left <= right){
            int mid = (int)(left + right)/2;

            if(determination(mid)){
                result = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(result);
    }


}