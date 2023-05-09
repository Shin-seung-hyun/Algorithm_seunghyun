import java.util.*;
import java.io.*;

//이분 탐색
    //매개 변수 탐색 알고리즘
    //N개를 만들 수 있는 최대 길이 C는 몇 cm인가?
    //길이 C로 잘랐을 때, N개의 랜선을 얻을 수 있는가?
public class Main{

    public static int K;    // 이미 가지고 있는 랜선의 수
    public static int N;    // 필요한 랜선의 수
    public static int []arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();

        arr = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            arr[i] = sc.nextInt();
        }

        search();
    }

    public static boolean Possible(long H){
        int cnt = 0;

        for(int i =1; i<=K; i++){
            cnt += (arr[i] / H);
        }

        return N <= cnt;
    }

    public static long search() {
        long left = 1;
        long right = Integer.MIN_VALUE;
        long result = 0;

        for (int i = 1; i <= K; i++) {
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            long mid = (left + right) / 2;

            if (Possible(mid)) {
                left = mid + 1;
                result = mid;
            }
            else right = mid - 1;

        }

        System.out.println(result);
    }

}