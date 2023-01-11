import java.util.Scanner;

//중복 0, 순서 x
public class Main{
    
    public static int N, M;
    public static int[]arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[M];
        dfs(1,0);
        System.out.print(sb.toString());
        
    }
    
    public static void dfs(int at , int depth){
        
        //재귀 종료 조건
        if(depth == M){
            for(int val : arr) sb.append(val).append(" ");
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