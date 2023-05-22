import java.util.*;
import java.io.*;

/*
1. N까지 + 또는 - 로만 움직이는 경우
2. N과 가까운 번호를 누른 후, + 또는 - 로만 움직이는 경우
둘을 비교하여 더 작은 값을 찾아야 함

단, 채널을 돌릴 때, 아래에서 N까지 시도해볼 수도 있고, 위에서 N까지 시도해볼 수도 있다.
예를 들어, N = 500000인 경우 480000부터 시도할 수 있지만, 520000부터 시도할 수 있다.
즉, 0 부터 50만까지가 아니라, 0부터 100만까지의 경우의 수를 시도해봐야 한다.
*/
public class Main{
    static int N;   //목표 채널
    static int M;   // 고장난 갯수
    static boolean []num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        num = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                num[Integer.parseInt(st.nextToken())] = true;
            }
        }

        //1. N까지 + 또는 - 로만 움직이는 경우
        int answer = Math.abs(N - 100);

        for (int i = 0; i <= 1_000_000; i++) {

            //2. N과 가까운 번호를 누른 후, + 또는 - 로만 움직이는 경우
            int cnt = check(i);

            if (cnt > 0) {
                int press = Math.abs(N - i);  // +,- 누르는 횟수
                answer = Math.min(answer, press + cnt);
            }
        }

        System.out.println(answer);
    }

    public static int check(int n) {

        if (n == 0) {
            if (num[0]) return 0;
            else return 1;
        }

        int cnt = 0;
        while (n > 0) {
            if (num[n % 10]) return 0;  // 고장난 버튼이 있으면 종료
            cnt++;
            n /= 10;
        }

        return cnt;
    }

}