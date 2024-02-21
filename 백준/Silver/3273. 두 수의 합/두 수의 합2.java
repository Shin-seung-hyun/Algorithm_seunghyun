import java.io.*;
import java.util.*;

//투 포인터
    //  정렬 O(NlogN) + 탐색 O(N)
    //left는 작은 값부터 올라가면서, right는 큰 값부터 내려가면서 합이 x되는 쌍 찾기.
public class Main{

    static int N, X;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        for(int i =1; i<=N; i++) arr[i] = sc.nextInt();
        X = sc.nextInt();

        Arrays.sort(arr,1,N+1);
        //1 2 3 5 7 9 10 11 12

        twoPointer();

    }

    static void twoPointer(){
        int left = 1;
        int right = N;
        int cnt = 0;

        while(left < right ){
            if(arr[left] + arr[right] == X){
                cnt++;
                left ++;
                right --;
            }
            else if (arr[left] + arr[right] > X){
                right--;
            }
            else left++;
        }


        System.out.println(cnt);
    }

}