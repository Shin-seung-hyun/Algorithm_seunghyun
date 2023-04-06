import java.util.*;

//투 포인터
class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        twoPointer();
    }

    static void twoPointer() {

        int right =0;
        int sum = 0;
        int cnt = 0;

        for(int left =1; left <=N; left++){

            while(right <=N && sum < N){
                right++;
                sum += right;
            }

            if(sum == N){
                cnt++;
            }

            sum -= left;
        }

        System.out.println(cnt);
    }
}