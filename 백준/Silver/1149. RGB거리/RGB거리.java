import java.util.*;

//동적 프로그래밍(DP)
public class Main{

    static int N;
    static int[][] Dy;
    static int[] rgb;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        N = sc.nextInt();

        Dy = new int[N+1][3+1];
        rgb = new int[3+1];
        
        DP();

        System.out.println( Math.min(Dy[N][1], Math.min(Dy[N][2], Dy[N][3]) ) );

    }

    static void DP(){
        
        //초기값
        Dy[0][0] = Dy[0][1] = Dy[0][2] = 0;
        
        //점화식
        for(int i =1; i<=N; i++){
            for(int j =1; j<=3; j++){
                rgb[j] = sc.nextInt();
            }
            
            Dy[i][1] = Math.min(Dy[i-1][2], Dy[i-1][3]) + rgb[1];
            Dy[i][2] = Math.min(Dy[i-1][1], Dy[i-1][3]) + rgb[2];
            Dy[i][3] = Math.min(Dy[i-1][1], Dy[i-1][2]) + rgb[3];
        }
    }
}