import java.util.*;
import java.io.*;

//완전탐색 BF
class Main{
    static int N;
    static int M;
    static int [][]arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1][M+1];

        //버퍼 제거
        sc.nextLine();

        for(int i =1; i<=N; i++){
            String str= sc.nextLine();

            for(int j = 0; j<M; j++){
                arr[i][j+1] = (str.charAt(j) - '0');
            }
        }

        check_square();
    }

    public static void check_square(){
        int answer = 1;
        int maxSquare = Math.min(N,M);

        for(int x = 2; x<=maxSquare; x++){
            for(int i =1; i<=N; i++){

                if((i + x -1) > N) continue;

                for(int j = 1; j<=M; j++){

                    if((j + x -1) > M) continue;

                    if(arr[i][j] == arr[i][j+x-1]) {
                        if(arr[i + x - 1][j] == arr[i+x-1][j+x-1]){
                            if(arr[i][j] == arr[i+x-1][j+x-1]) answer = x;
                        }
                    }
                }
            }
        }

        System.out.println(answer * answer);
    }

}