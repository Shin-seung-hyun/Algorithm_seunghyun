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

        while(Kim != Lim){
            Kim = Kim / 2 + Kim % 2;
            Lim = Lim / 2 + Lim % 2;
            cnt++;
        }

        System.out.println(cnt);
    }

}