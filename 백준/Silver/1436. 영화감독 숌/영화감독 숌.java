import java.util.*;

//완전 탐색 BF
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = 666;
        int cnt = 1;

        while(N > cnt){
            num ++;

            if(check(num)) cnt++;
        }

        System.out.println(num);
    }

    static boolean check(int n){

        int count = 0;
        while(n >0){

            if(n % 10 == 6) count++;
            else count = 0;

            if(count >=3) return true;

            n = n/10;
        }

        return false;
    }
}