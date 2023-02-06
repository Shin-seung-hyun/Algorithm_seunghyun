import java.util.*;
import java.io.*;

public class Main{

    public static int N, X;
    public static int[]arr;

    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        for(int i = 1; i<=N; i++){
           arr[i] =sc.nextInt();
        }

        //이분탐색을 위한 정렬
        //1 2 3 5 7 9 10 11 12
        Arrays.sort(arr,1, N+1);

        X = sc.nextInt();

        //이분탐색
        int cnt = 0;
        for(int i = 1; i<=N; i++){

            //arr[1]~ arr[N] 중에서 X - arr[i]가 있는지 탐색
            cnt += search(1, N , X - arr[i]);
        }

        System.out.println(cnt/2);
    }

    public static int search(int left, int right, int x){

        int result = 0;
        if(x <=0) return 0;

        while(left <= right){
            int mid = (left + right)/2;

            if(arr[mid] ==x){
                return 1;
            }
            else if(arr[mid] >x){
                right = mid -1;
            }
            else{
                left = mid+1;
            }
        }

        return 0;
    }

}