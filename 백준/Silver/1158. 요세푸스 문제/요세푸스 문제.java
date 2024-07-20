import java.util.*;
import java.io.*;

//연결 리스트
/*
N명의 사람을 담을 배열에
    LinkedList(연결리스트) 사용 시, 삭제할 위치만 기억하고 있다면(= K번째 요소를 찾기 위해 매번 리스트의 처음부터 순회하지 않고, 이전에 제거된 요소의 위치(idx)부터 시작한다면)
        시간복잡도 : N * O(1) = O(N)

    ArrayList, Array 사용 시,
        시간복잡도 : N * O(N) = O(N^2)

단, 현재의 풀이는 iterator를 사용하지 않고 linkedList.remove를 사용해 O(N^2) 시간복잡도를 갖는다.
*/

class Main{
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=n; i++) list.add(i);

        int idx = 0;
        sb.append("<");

        while(list.size() >1){

            // LinkedList의 특정 인덱스에서 요소를 제거하는 작업은 최악의 경우 O(n)
                    idx = (idx + k -1) % list.size();
            sb.append(list.remove(idx) + ", ");
        }

        sb.append(list.remove());
        sb.append(">");

        System.out.println(sb.toString());
    }
}