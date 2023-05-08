import java.util.*;

//완전탐색 BF
class Main{
    static int N;       // 참가자의 수
    static int Kim;     //김지민 번호
    static int Lim;     //임한수 번호

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Kim = sc.nextInt();
        Lim = sc.nextInt();

        check(N );
    }

    public static void check(int num){

        int cnt = 0;

        while(num > 1 ){

            cnt++;

            if((Kim/2) != (Lim/2)){
                if((Kim-Lim ==-1) || (Kim- Lim ==1)) break;
            }

            if((Kim % 2) ==1 ){
                Kim = Kim/2 +1;
            }
            else Kim = Kim/2;


            if((Lim % 2) ==1){
                Lim = Lim/2 +1;
            }
            else Lim = Lim/2;

            num = (num/2) + (num % 2);
        }
        System.out.println(cnt);
    }


}