import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        long result = cal(a,b);

        System.out.println(result);
    }

    static long cal(long x, long y ){

        /*
            int 범위 : 2^31 -1
            long 범위 : 2^63 -1

            즉, temp = 2^31 -1 이면, (2^31-1 * 2^31-1) < 2^63-1 이지만
            a까지 2^31-1이라면  (2^31-1 * 2^31-1 * 2^31-1) > 2^63-1로 long의 범위를 넘는다.
            따라서  temp * temp % C 를 해야 한다.
        */

        if( y ==1){
            return  x % c ;
        }

        long tmp = cal(x, y/2);

        if( y % 2 ==0){
            return tmp * tmp % c ;
        }
        else {

            return (tmp * tmp %c)  * cal (x,1) % c;
        }

    }
}
