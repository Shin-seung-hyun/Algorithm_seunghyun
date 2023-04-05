import java.io.*;
import java.util.*;

//투 포인터
public class Main{

    static int N, M;
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1];
        for(int i =1; i<=N; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr,1,N+1);
        // 1 2 3 4 5 7

        twoPointer();

    }

    static void twoPointer(){
        int left = 1;
        int right = N;
        int cnt =0;

        // 1 2 3 4 5 7
        
        while(left < right){
            if(arr[left] + arr[right] == M){
                left ++;
                right --;
                cnt++;
            }
            else if (arr[left] + arr[right] > M){
                right --;
            }
            else{
                left ++;
            }
        }

        System.out.println(cnt);

    }

}