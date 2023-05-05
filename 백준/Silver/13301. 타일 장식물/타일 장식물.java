import java.util.*;

// 동적 프로그래밍 DP
class Main{

    static int N;   //타일 수
    static long [][]Dy;
    static long []Dy2;
    static long answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Dy = new long[N+2][2];
        Dy2 = new long[N+2];

        Dy();

        System.out.println(answer);
    }

    static void Dy(){

        //초기화
        Dy2[1] = 1;
        Dy2[2] = 1;

        for(int i =2; i<=N+1; i++){
            Dy2[i] = Dy2[i-1] + Dy2[i-2];
        }

        // 방법1
        answer = Dy2[N] * 2 + Dy2[N+1] *2;

        //방법2
        /*
        Dy[1][0] = 1; Dy[1][1] = 4;
        Dy[2][0] = 1;

        for(int i =2; i<=N+1; i++){
            Dy[i][0] = Dy[i-1][0] + Dy[i-2][0];
        }
        for(int i =2; i<=N; i++){
            Dy[i][1] = Dy[i][0] * 2 + Dy[i+1][0] *2;
        }
        */

        //System.out.println(Arrays.deepToString(Dy));
    }

}