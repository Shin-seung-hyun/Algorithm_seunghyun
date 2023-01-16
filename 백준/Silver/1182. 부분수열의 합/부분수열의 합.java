import java.util.Scanner;

public class Main{
    
    public static int N, S;
    public static int answer=0;
    public static int arr[];
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        
        arr = new int[N];
        
        for(int i =0; i< N; i++) arr[i] = sc.nextInt();
        
        dfs(0,0);
        
        //만약 s가 0이라면 아무것도 선택하지 않아도 ans++가 됨.
        //즉, 공집합을 하나 빼주어야 함.
        if(S ==0) answer--;
        
        System.out.print(answer);
    }
    
    public static void dfs(int depth, int value){
        
        if(depth ==N ){
            if(value == S) answer++;
            return;
        }
        
        //해당 값이 포함될 때
        dfs(depth+1, value+ arr[depth]); 
        
        //해당 값이 포함되지 않을 때
        dfs(depth+1, value);
    }
}