import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        Deque<Integer> dq = new LinkedList<>();

        int answer = 0;
        for (int i = 1; i <= N; i++) dq.add(i);

        for (int i = 0; i < M; i++) {
            int num = scan.nextInt();
            int cnt = 0;

            while (dq.peekFirst() != num) {
                dq.add(dq.remove());
                cnt++;
            }

            answer += Math.min(cnt, dq.size() - cnt);

            dq.removeFirst();
        }

        System.out.println(answer);
    }
}
