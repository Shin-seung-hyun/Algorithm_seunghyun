import java.util.*;

class Main{
    static int N;
    static long[][] Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dy = new long[10][64+1];
        DP();

        int testCase = sc.nextInt();
        for(int i =0; i< testCase; i++){
            N = sc.nextInt();

            System.out.println(Dy[9][N]);
        }

    }

    static void DP(){
        //초기화
        for(int i =0; i<=9; i++){
            Dy[i][1] = i+1;
        }

        for(int n=2; n<=64; n++){

            for(int j = 0; j<=9; j++){

                if(j==0) Dy[0][n] = Dy[0][n-1];
                else{
                    Dy[j][n] = Dy[j][n-1] + Dy[j-1][n];
                }
            }
        }

    }
}