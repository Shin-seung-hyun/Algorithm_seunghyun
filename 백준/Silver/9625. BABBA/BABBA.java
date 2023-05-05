import java.util.*;

// 동적 프로그래밍 DP
class Main{

    static int K;   //k번 눌렀을 때
    static int [][]Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();

        Dy = new int [K+1][2];

        DP();

        System.out.println(Dy[K][0] + " " + Dy[K][1]);
    }
    static void DP(){

        //초기값
        Dy[0][0] = 1;
        Dy[0][1] = 0;
        Dy[1][0] = 0;
        Dy[1][1] = 1;

        if(K >= 2){

            for(int i =2; i<=K; i++){
                Dy[i][0] = Dy[i-1][1];
                Dy[i][1] = Dy[i-1][0] + Dy[i-1][1];
            }
        }
        //System.out.println(Arrays.deepToString(Dy));
    }
}