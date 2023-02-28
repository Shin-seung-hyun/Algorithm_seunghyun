import java.util.*;

//동적 프로그래밍 DP
    //level 1. 가짜 문제와 진짜 문제가 같을 때
class Main{
    static int[] Dy;    //DP array
    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Pre();

        System.out.println(Dy[N]);

    }

    static void Pre(){
        Dy = new int[10_000 +1];

        Dy[1] = 1;
        Dy[2] = 2;

        for(int i = 3; i<= N; i++){
            Dy[i] = (Dy[i-2] + Dy[i-1]) % 10_007;
        }

    }
}