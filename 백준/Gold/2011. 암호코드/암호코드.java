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
        for(int i =1; i<=N.length(); i++){
            num[i] = N.charAt(i-1) -'0';
        }

        DP();

        System.out.println(Dy[N.length()]);
    }

    static void DP(){
        if(num[1] ==0){
            return;
        }

        Dy[0] = 1;
        Dy[1] = 1;

        //250

        for(int i =2; i<=N.length(); i++){
            if(num[i] ==0){
                if(num[i-1] == 1 || num[i-1] == 2){
                    Dy[i] = Dy[i-2] % mod;
                }
                else break;
            }

            else{
                int number = num[i-1] *10 + num[i];

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