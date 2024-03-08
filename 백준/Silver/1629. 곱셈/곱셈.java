import java.util.*;
import java.io.*;

//재귀
class Main{

    static long A,B,C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        // POW함수 내 2번 POW함수 불러서 시간 초과 발생 : O(B)
        //System.out.println(func(B));

        // func() 코드를 개선
        // B가 절반씩 줄어들어서 시간복잡도 : O(logB)
        System.out.println(POW(A,B,C));
    }

    static long POW(long a, long b ,long c){

        if( b ==1) return a % c;

        long temp = POW(a,b/2,c);

        /*
            int 범위 : 2^31 -1
            long 범위 : 2^63 -1

            즉, temp = 2^31 -1 이면, (2^31-1 * 2^31-1) < 2^63-1 이지만
               a까지 2^31-1이라면  (2^31-1 * 2^31-1 * 2^31-1) > 2^63-1로 long의 범위를 넘는다.
            따라서  temp * temp % C 를 해야 한다.
        */
        if( b % 2 == 1) return ((temp * temp)%c * a) % c;
        else return temp * temp % c;
    }

    static long func(Long b){

    // 종료 조건
        if(b <= 1) {
            return 1;
        }

    // 반복 조건
        // 짝수일 때
        if(b % 2 ==0){
            return (long)(Math.pow(A, func(b / 2)) * (Math.pow(A, func(b / 2))  % C));
        }
        // 홀수일 때 -> 단, (pow * pow * A % C) 가 아니라 ( (pow * pow %C) *A) % C여야 함
        else {
            return (long)((Math.pow(A, func( b / 2 )) * Math.pow(A, func(b / 2))) % C) * A % C;
        }

    }
}