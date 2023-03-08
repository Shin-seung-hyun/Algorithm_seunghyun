import java.util.*;

//동적 프로그래밍 (DP)
public class Main{
    static int N;
    static int []Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Dy = new int[20+1];
        
        Pre();
        
        System.out.println(Dy[N]);
    }
    
    static void Pre(){
        
        //초기화
        Dy[0] = 0;
        Dy[1] = 1;
        
        for(int i =2; i<=20; i++){
            Dy[i] = Dy[i-1] + Dy[i-2];
        }
        
    }
}