import java.util.Scanner;
import java.util.Arrays;

public class Main{

    public static int N ;
    public static int M;
    public static int A[],B[];
    public static Scanner sc = new Scanner(System.in);

    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N];
        B = new int[M];

        for(int i = 0; i< N; i++) A[i] = sc.nextInt();
        for(int i = 0; i< M; i++) B[i] = sc.nextInt();

        //A : 8 1 7 3 1
        //B : 1 3 6
        Arrays.sort(B);

        int cnt = 0;

        //N번 이분 탐색
        for(int i = 0 ; i< A.length; i++){
            cnt += search(0, M-1, A[i]);
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
                left = mid +1;
                result = mid + 1;
            }
            else{
                rigth = mid -1;
            }
        }

        return result;
    }

}