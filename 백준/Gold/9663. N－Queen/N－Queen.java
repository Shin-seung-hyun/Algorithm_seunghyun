import java.util.Scanner;

//N개 중에서 N개를 중복 o, 순서o 나열하기
public class Main{
    
    public static int N;
    public static int arr[]; //index 열, value 행
    public static int cnt =0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        arr = new int[N];
        
        N_Queen(0);
        
        System.out.print(cnt);
    }
    
    //퀸을 놓아도 되는 자리인지 확인
    public static boolean Possible(int col){
        
        for(int i = 0; i< col; i++){
            
            //depth 열의 행값과 i열의 행값이 같을 때 
            if(arr[col] == arr[i]) return false;
            
            //이전의 퀸값과 대각선으로 만날 때
            else if((arr[col] + col) == (arr[i] + i) || (arr[col] - col) == (arr[i] - i)) return false;
        }
        return true;
    }
    
    public static void N_Queen(int depth){
        
        //재귀 종료 조건
        if(depth == N){
            cnt++;
            return;
        }
        
        //재귀 반복
        for(int i =0; i< N ; i ++){
           
            arr[depth] = i;
            
            if(Possible(depth)){
                N_Queen(depth+1);
            }
        }
        
    }
}