import java.util.*;
import java.io.*;

//이분 탐색
    //매개 변수 탐색 알고리즘
    //N개를 만들 수 있는 최대 길이 C는 몇 cm인가?
    //길이 C로 잘랐을 때, N개의 랜선을 얻을 수 있는가?
public class Main{

    public static int N,K;
    public static int arr[];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N + 1];

        for(int i = 1; i<=N; i++){
            arr[i] = sc.nextInt();
        }
        
        System.out.println(search());
    }

    public static boolean Possible(long H){
        long sum = 0;
        for(int i  =1; i<=N ; i++){
            sum += arr[i] / H;
        }

        return sum >=K;
    }
    public static long search(){
        long left = 1;
        long right = Integer.MAX_VALUE;
        long result =0;

        while(left <= right){
            long mid = (left + right)/2;

            if(Possible(mid)){
                left = mid +1;
                result = mid;
            }
            else{
                right = mid-1;
            }
        }

        return result;
    }

}