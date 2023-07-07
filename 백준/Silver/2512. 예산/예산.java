import java.util.*;
import java.io.*;

//이분 탐색
    //매개 변수 탐색 알고리즘
    // N개의 지방 예산 요청액 중 최대의 총 예산 금액은?
    // 예산 금액이 C일 때, N * 예산 요청액이 <= M인가?
    // 배정된 예산들 중 최댓값인 정수를 구하시오
class Main{

    static int N;   // 지방수
    static int M;   // 총 예산
    static int [] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cost = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        // 정렬
        Arrays.sort(cost,1,N+1);

        search();
    }
    static boolean determin(int c){
        int sum =0;
        for(int i =1; i<=N; i++){
            if( cost[i] >= c) sum += c;
            else sum += cost[i];
        }

        return M >= sum;
    }

    static void search(){
        // N 값의 범위 : 3 <= N <= 10_000
        // cost[i] 의 범위 1 <= cost[i] <= 100_000
        // M 값의 범위 : N <= M <= 1_000_000_000

        //모든 result의 값은 arr의 최댓값을 넘기 않는다.
        //determin(mid)함수에서 모두가 원하는 만큼의 돈을 받을 수 있어도 무한대까지 늘어나기 때문에 범위를 지정해야 한다.
        int left = 1;
        int right = cost[N];
        int result = 0;

        while( left <= right){
            int mid = (left  + right)/2;

            if( determin(mid)){
                left = mid +1;
                result  = mid;
            }
            else{
                right = mid -1;
            }
        }

        System.out.println(result);
    }
}
