import java.util.*;
import java.io.*;

public class Main{

    public static int N,M;
    public static int arr[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        //이분 탐색을 위한 정렬
        //-10 -10 2 3 3 6 7 10 10 10
        Arrays.sort(arr, 1, N + 1);

        M = sc.nextInt();
        for(int i =0; i<M; i++){
            int X = sc.nextInt();

            //중복 원소의 왼쪽 끝 값(하한)
            //찾고자하는 값이 같거나 큰 경우를 처음 만나는 위치
            int lower = lower_search(1,N,X);

            //중복 원소의 오른쪽 끝 값(=상한)
            // 찾고자 한 값을 초과한 값의 위치
            // 찾고자 하는 값이 더이상 넘어 갈 수 없는 위치
            int upper = upper_search(1,N,X);

            sb.append(upper - lower).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static int lower_search(int left, int right, int x){
        int result = right+1;

        while(left <= right){
            int mid = (left+right)/2;

            if(arr[mid] >= x){

                // x 값이 중간값보다 작거나 같은 경우, 왼쪽을 탐색하도록 오른쪽을 줄인다.
                right = mid -1;
                result = mid;
            }
            else{ // arr[mid] > x

                //x 값이 중간값보다 큰 경우, 오른쪽을 탐색하도록 왼쪽을 당긴다.
                left = mid +1;
            }
        }

        return result;
    }

    public static int upper_search(int left, int right, int x){
        int result = right+1;

        while(left <= right){
            int mid = (left+right)/2;

            if(arr[mid] > x){
                right = mid -1;
                result = mid;
            }
            else{
                left = mid +1;
            }
        }

        return result;
    }

}