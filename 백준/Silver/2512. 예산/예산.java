import java.util.*;
import java.io.*;

//이분 탐색
    //매개 변수 탐색 알고리즘
    // N개의 지방 예산 요청액 중 최대의 총 예산 금액은?
    // 예산 금액이 C일 때, N * 예산 요청액이 <= M인가?
    //배정된 예산들 중 최댓값인 정수를 구하시오
public class Main{

    public static int N,M;
    public static int arr[];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   //지방의 수

        arr = new int[N + 1];

        for(int i = 1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        M = sc.nextInt();   //총 예산

        System.out.println(search());
    }

    public static boolean Possible(int totalCnt){
        int sum = 0;

        for(int i =1 ;i <=N; i++){
            if(arr[i] >= totalCnt) sum += totalCnt;
            else sum += arr[i];
        }

        return sum <= M;
    }

    public static int search(){
        int left = 0;
        int right = 0;
        int result = 0;

        //right 값의 범위를 지정해 줌
            //모든 result의 값은 arr의 최댓값을 넘기 않는다.
            //Possible(mid)함수에서 모두가 원하는 만큼의 돈을 받을 수 있어도 무한대까지 늘어나기 때문에 범위를 지정해야 한다.
        for(int i = 1; i<=N ; i++){
            right = Math.max(right, arr[i]);
        }
        while(left <= right){

            int mid = (left + right)/2;
            if(Possible(mid)){
                left = mid +1;
                result = mid;
            }
            else{
                right = mid - 1;
            }
        }

        return result;
    }

}