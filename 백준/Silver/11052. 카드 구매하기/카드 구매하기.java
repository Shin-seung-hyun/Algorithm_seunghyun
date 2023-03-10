import java.util.*;

//동적 프로그래밍(DP)
public class Main{

    static int[] Dy;
    static int[] num;
    static int N;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        N = sc.nextInt();

        Dy = new int[N+1];
        num = new int[N+1];

        for(int i =1; i<=N; i++){
            num[i] = sc.nextInt();
        }

        Pre();

        System.out.print(Dy[N]);
    }

    static void Pre(){

        //초기화
        Dy[1] = num[1];

        for(int i= 2; i<=N; i++){
            int tmp = 0;
            for(int j =1; j<= i-1; j++){
                tmp = Math.max(tmp, Dy[j] + num[i-j]);
            }
            Dy[i] = Math.max(num[i], tmp);
        }
    }
}