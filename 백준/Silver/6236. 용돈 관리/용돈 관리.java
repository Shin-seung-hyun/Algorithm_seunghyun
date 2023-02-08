import java.util.*;

//이분 탐색
    //매개 변수 탐색 알고리즘
    // M번만 인출할 수 있을 때, 최소 필요한 금액 K는?
    // 금액이 K일 때 ,M번만 인출할 수 있는가?
public class Main{

    public static int N;        //일
    public static int M;        //인출 횟수
    public static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int [N+1];
        for(int i =1; i<=N ;i++){
            arr[i] = sc.nextInt();
        }

        search();
    }

    public static boolean determination(int money){
        int cnt = 1;
        int tmp = money;

        for(int i =1; i<=N ; i++){
            tmp = tmp - arr[i];

            if(tmp < 0){
                cnt++;
                tmp = money;
                tmp = tmp - arr[i];
            }
        }

        return cnt <= M;
    }
    
    public static void search(){

        //최소 금액 k의 범위 : 쓸 금액의 최대 <= K <= 100_000(번) * 10_000(원)
        int left = arr[1];
        int right = 1_000_000_000;
        int result = 0;

        for(int i =1; i<=N; i++){
            left = Math.max(left, arr[i]);
        }

        while(left <= right){

            int mid = (left + right)/2;

            if(determination(mid)){
                right = mid -1;
                result = mid;
            }
            else{
                left = mid +1;
            }
        }
        System.out.println(result);
    }

}