import java.util.*;

//매개 변수 탐색 알고리즘
    // 최소 금액 k을 출력하시오
    // 최소 금액 k로 M번만 인출할 수 있는가?
class Main{
    static int N;   // N 일 동안
    static int M;   // M 번 인출
    static int [] arr;  //사용한 금액

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];

        for(int i =1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        search();
    }

    public static  void search(){
        
        int left = arr[1];
        int right = 1_000_000_000;
        int result = 0;

        for(int i =1; i<=N; i++){
            left = Math.max(left, arr[i]);
        }
        while(left <= right){

            int mid = (left + right) /2;

            int extra_money = mid;
            int cnt = 1;

            for(int i =1; i<=N; i++) {

                if(extra_money - arr[i] < 0){
                    //extra_money += mid;
                    extra_money = mid;
                    cnt++;
                }
                extra_money -= arr[i];

            }
            if(cnt > M){
                left = mid + 1;
            }
            else{
                right = mid - 1;
                result = mid;
            }

        }

        System.out.println(result);
    }


}