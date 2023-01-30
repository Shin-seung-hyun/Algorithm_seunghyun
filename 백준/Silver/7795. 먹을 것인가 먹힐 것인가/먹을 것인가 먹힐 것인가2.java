import java.util.Scanner;
import java.util.Arrays;

// 배열의 인덱스를 1부터 시작하지 않으면 mid를 계산할 때, 0+0/2 와 같이 예외가 발생함
// ex) x = 8, B[9, 10, 11]일 경우
public class Main{

    public static int N ;
    public static int M;
    public static int A[],B[];
    public static Scanner sc = new Scanner(System.in);

    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N+1];
        B = new int[M+1];

        for(int i = 1; i<= N; i++) A[i] = sc.nextInt();
        for(int i = 1; i<= M; i++) B[i] = sc.nextInt();

        //A : 8 1 7 3 1
        //B : 1 3 6
        Arrays.sort(B, 1, M+1);

        int cnt = 0;

        //N번 이분 탐색
        for(int i = 1 ; i<=N; i++){
            cnt += search(1, M, A[i]);
        }

        System.out.println(cnt);
    }

    public static void main(String[] args){

       int testCase = sc.nextInt();
        for(int i = 0; i< testCase; i++){
            input();
        }
    }

    public static int search(int left, int rigth, int x){

        //B 배열에서 X이하의 수가 없다면 left를 반환함
        int result = 0;
        while(left <= rigth){

            int mid = (left + rigth) / 2;

            if(x > B[mid]) {
                left = mid+1;
                result = mid;
            }
            else{
                rigth = mid -1;
            }
        }

        return result;
    }

}