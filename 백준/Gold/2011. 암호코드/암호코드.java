import java.util.*;

//동적 프로그래밍
public class Main{
    static int[] Dy;
    static String N;
    static int[] num;
    static int mod = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLine();
        
        Dy = new int[N.length()+1];
        num = new int[N.length()+1];
        
        if(N.charAt(0) =='0'){
            System.out.println(0);
            return;
        }
        
        DP();

        System.out.println(Dy[N.length()]);
    }
    
    static void DP(){
        Dy[0] = 1;
        Dy[1] = 1;
        
        for(int i =2; i<=N.length(); i++){
            if(N.charAt(i-1) =='0'){
                if(N.charAt(i-2) =='1' || N.charAt(i-2) =='2'){
                    Dy[i] = Dy[i-2] % mod;
                }
                else break;
            }
            
            else{
                int number = Integer.parseInt(N.substring(i-2,i));
                
                if(number < 27 && number >9){
                    Dy[i] = (Dy[i-2] + Dy[i-1]) % mod;
                }
                else{
                    Dy[i] = Dy[i-1] % mod;
                }
            }
        }
        
        
    }
}