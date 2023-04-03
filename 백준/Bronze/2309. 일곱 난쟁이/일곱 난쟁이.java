import java.util.*;

public class Main{

    //9개 중에 7개를 중복 X 순서 X(조합) 나열하기
    static int N =9;
    static int M =7;
    static int[] arr, tmp, result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[N];
        tmp = new int [M];
        result = new int[M];
        for(int i =0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        //7 8 10 13 15 19 20 23 25

        DFS(0, 0);

        for(int val: result){
            System.out.println(val);
        }
    }

    static void DFS(int depth, int at ){

        //종료 조건
        if(depth == M){
            int sum =0;

            // 더한 값이 100 이라면 출력
            for(int val : tmp){
                sum += val;
            }

            if(sum ==100){
                for(int i = 0; i<M; i++){
                    result[i] = tmp[i];
                }
            }
            return;
        }

        //재귀 조건
        for(int i =at; i<N; i++){
            tmp[depth] = arr[i];
            DFS(depth+1, i+1 );
        }

    }


}