import java.util.*;

//동적 프로그래밍(DP)
    //level 1. 진짜 문제와 가짜 문제가 같을 때
class Main{
    static long[] Dy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int testCase = sc.nextInt();

        //미리 계산
        Pre();

        for(int i =1; i<=testCase; i++){
            int N = sc.nextInt();

            sb.append(Dy[N]).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void Pre(){
        Dy = new long[1_000_000 +1];

        //초기화
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for(int i = 4; i<=1_000_000; i++){
            Dy[i] = (Dy[i-3] + Dy[i-2] + Dy[i-1]) % 1_000_000_009 ;
        }
    }


}