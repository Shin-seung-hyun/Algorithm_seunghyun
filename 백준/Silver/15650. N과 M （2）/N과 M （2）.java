import java.util.Scanner;

//N개 중 M개를 중복 x, 순서 x 고르기
public class Main {

    public static int[] arr;
    public static boolean[] visit;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int [M+1];
        visit  = new boolean[N+1];

        DFS(1,1);

        System.out.print(sb.toString());
    }

    public static void DFS(int depth, int at) {

        // 종료 조건
        if( depth == M+1){
            for(int i=1; i<=M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }
        
        // 반복 조건
        for(int i =at; i<=N; i++){

            if(visit[i]) continue;

            visit[i] = true;
            arr[depth] = i;
            DFS(depth +1, i);
            visit[i] = false;
        }

    }

}