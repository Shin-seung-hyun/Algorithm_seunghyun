import java.util.Scanner;

//N개 중 M개를 중복 0, 순서 x 고르기
public class Main{
    
    public static int N, M;
    public static int[]arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[M+1];
        dfs(1,1);
        System.out.print(sb.toString());
        
    }
    
    public static void dfs(int at , int depth){
        
        //재귀 종료 조건
        if(depth == M+1){
            for(int i =1; i<=M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        
        //반복 조건
        for(int i = at; i<= N; i++){
            arr[depth] = i;
            dfs( i, depth +1);
        }
    }
}