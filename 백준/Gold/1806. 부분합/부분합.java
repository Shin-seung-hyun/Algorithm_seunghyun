import java.util.*;

//두 포인터
public class Main{

    public static int N;        // N 개
    public static int S;        // 부분합
    public static int arr[];    // N개의 연속된 수열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N+1];
        for(int i = 1; i<=N ;i++){
            arr[i] = sc.nextInt();
        }

        twoPointer();
    }

    public static void twoPointer(){
        int right = 0;
        int sum = 0;
        int answer = N+1;   //S를 넘는 값들 중 가장 짧은 것을 기록

        for(int left = 1; left <= N; left++){

            //하나씩 줄이기
            sum = sum -arr[left-1];

            //S가 될 때까지 더하기
            while(right + 1 <= N && sum < S){
                sum = sum + arr[++right];
            }

            if(sum >= S){
                //몇개를 더해서 S가 됐는지 확인
                answer = Math.min(answer, right -left +1);
            }
        }

        if(answer == N+1) answer =0;
        System.out.println(answer);
    }

}