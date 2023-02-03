import java.util.Scanner;
import java.util.*;

public class Main{

    public static int N,M;
    public static int Nnum[],Mnum[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N= sc.nextInt();
        Nnum = new int[N+1];
        for(int i = 1; i<=N; i++){
            Nnum[i] = sc.nextInt();
        }

        M = sc.nextInt();
        Mnum = new int[M+1];
        for(int i =1; i<=M; i++){
            Mnum[i] = sc.nextInt();
        }

        //이분탐색을 위한 정렬
            // 1 2 3 4 5
        Arrays.sort(Nnum,1, N+1);

        for(int i=1; i<=M; i++){
            search(Mnum[i], 1, N);
        }

    }

    public static void search(int x, int left, int right){

        //반례가 존재함으로 result를 1로 설정
        /*
            input:  1
                    1
                    1
                    0
            output: 1
        */
        int result = 1;

        while(left <= right){
            int mid = (left + right) /2;

            if(x < Nnum[mid]){
                right = mid-1;
            }
            else{
                left = mid +1;
                result = mid;
            }
        }

        if(Nnum[result] == x) System.out.println(1);
        else System.out.println(0);

    }

}