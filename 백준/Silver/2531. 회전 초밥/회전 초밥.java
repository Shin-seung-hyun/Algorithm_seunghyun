import java.util.*;

//투 포인터
    //연속해서 K번 먹을 경우 할인
    //행사에 참가할 시, 쿠폰에 적힌 초밥 종류 무상제공
public class Main{

    static int N;   // 접시 수
    static int d;   // 초밥의 가짓수
    static int k;   // 연속해서 먹는 접시 수
    static int c;   // 쿠폰 번호
    static int []arr;
    static int []visit;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();

        visit = new int[d+1];
        arr = new int[N + k];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i =1; i<k; i++){
            arr[N+i] = arr[i];
        }

        //System.out.println(Arrays.toString(arr));
        twoPointer();
    }

    public static int cntType(){
        int count = 0;
        boolean coupon = false;

        for(int i =1; i<=d; i++){
            if(visit[i] !=0){
                count++;
                if(i == c) coupon = true;
            }
        }

        if(coupon) return count;
        else return count + 1;
    }

    public static void twoPointer(){

        int cnt = 0;
        int right = 1;

        for(int left = 1; left < arr.length; left++){
        //for(int left = 1; left <= N +k -1; left++){

            while((right- left +1) <= k && right < arr.length){
           //while((right- left +1) <= k && right <= N +k -1){

                visit[arr[right]]++;
                right++;

            }
            cnt = Math.max(cnt, cntType());
            visit[arr[left]]--;
        }

        System.out.println(cnt);
    }

}