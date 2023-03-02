import java.util.*;

//동적 프로그래밍 - DP
    //level 3. 새로운 정의가 필요한 경우
    // => 크기 N과 마지막을 함께 저장해야 하는 경우
class Main{
    static int N;
    static int [][] dy; // DP array

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        // N개의 열에 0 1 2 3 4 5 6 7 8 9의 행
        dy = new int [N+1][10];

        Pro();

        int sum = 0;
        for(int i =0; i <=9; i++){
            sum +=  dy[N][i];
        }
        System.out.println(sum % 10_007);
    }

    static void Pro(){

        //초기화
        for(int i =0; i<=9; i++){
            dy[1][i] = 1;
        }

        for(int i =2 ;i<= N; i++){
            for(int j = 0; j<= 9; j++){
                for(int k = 0; k<=j; k++){
                    dy[i][j] += dy[i-1][k];
                    dy[i][j] %= 10_007;
                }
            }
        }

    }
}