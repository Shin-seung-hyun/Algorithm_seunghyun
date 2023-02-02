import java.util.Scanner;
import java.util.Arrays;

//이분 탐색 -> 매개 변수 탐색 알고리즘
public class Main{

    public static int N; // 집의 개수
    public static int C; // 공유기의 개수
    public static int[] arr;

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        arr = new int[N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        //fromIndex는 포함, toIndex는 미포함
        Arrays.sort(arr , 1 ,N+1);

        //이분 탐색
        search();
    }

    public static boolean determination(int D){

        int cnt =1;
        int last = arr[1];

        for(int i =2; i<=N; i++){
            if(arr[i] - last < D) continue;

            last = arr[i];
            cnt++;
        }

        return cnt >= C;
    }

    public static void search(){

        int left =1;
        int right = 1_000_000_000; //10억
        int result = 0;

        while(left <= right){
            int mid = (left + right) /2;

            if(determination(mid)){

                result = mid;
                left = mid +1;
            }
            else{
                right = mid -1;
            }

        }

        System.out.println(result);
    }

}