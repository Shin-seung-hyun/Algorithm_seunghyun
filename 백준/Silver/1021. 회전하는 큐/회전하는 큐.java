import java.util.*;
import java.io.*;

//Deque
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());   // 큐의 크기
        int M = Integer.parseInt(st.nextToken());   // 뽑아내려고 하는 수의 개수

        //양방향 순환큐
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i=1; i<=N; i++) dq.add(i);

        int cnt =0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++){
            int num = Integer.parseInt(st.nextToken());

        //중간값 찾기
            // 저장된 위치 반환. 단, 0부터 시작
            int targetIdx = dq.indexOf(num);
            int halfIdx =0;

            // idx  : 0 1 2 3
            // value: 1,2,3,4 짝수일 때는, 4/2 -1로 중간 idx 찾아주기
            if( dq.size() % 2 ==0) halfIdx = dq.size()/2 - 1;
            else halfIdx = dq.size()/2;

        // 중간값에 따라 연산 다르게 하기
            while(dq.peek() != num) {
                if (targetIdx <= halfIdx) {
                    // 2번째 연산 : 왼쪽으로 한 칸 이동
                    dq.addLast(dq.removeFirst());

                }
                else{ //targetIdx > halfIdx
                    // 3번쩨 연산 : 오른쪽으로 한 칸 이동
                    dq.addFirst(dq.removeLast());
                }

                cnt++;
            }

            // 1번째 연산
            dq.remove();
        }

        System.out.println(cnt);
    }
}