import java.util.*;

//동적 프로그래밍(DP)
public class Main{

    static long[] Dy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        Pre();

        for(int i= 1; i<=testCase; i++){
            int N = sc.nextInt();

            sb.append(Dy[N]).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void Pre(){

        Dy = new long[100_000+1];

        //초기화
        Dy[0] = 1;
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 2;

        for(int i =4; i<=100_000; i++ ){
            if(i < 6){
                Dy[i] = Dy[i-2] + Dy[i-4];
            }
            else{
                Dy[i] = (Dy[i-2] + Dy[i-4] + Dy[i-6]) % 1_000_000_009;
            }
        }
    }
}