import java.io.*;
import java.util.*;

//이분탐색
public class Main{

    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();;

        twoPointer();


    }
    static void twoPointer(){
        int right = 0;
        int cnt = 0;
        int sum = 0;

        for(int left =1; left <=N; left++){

            //하나씩 줄이기
            sum -= left-1;

            //sum이 될 때까지 더하기
            while(right<=N && sum < N) sum+= ++right;

            if(sum == N){
                if(N >= (right - left +1) )cnt++;
            }
        }

        System.out.println(cnt);
    }


}