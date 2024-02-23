import java.util.*;
import java.io.*;

//연결 리스트
/*
N명의 사람을 담을 배열에
    LinkedList(연결리스트) 사용 시,
        시간복잡도 : N * O(1) = O(N)

    ArrayList, Array 사용 시,
        시간복잡도 : N * O(N) = O(N^2)
*/

class Main{
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 사람수
        int K = Integer.parseInt(st.nextToken());   // K번째 사람 제거

        //N명의 사람을 담은 LinkedList O(N), ArrayList O(N^2)
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=1; i<=N; i++) list.add(i);

        //요세푸스 순열을 담을 arrList
        ArrayList<Integer> arrList = new ArrayList<>();

        int idx = 0;
        while(list.size() >0) {

            idx = (idx + K - 1) % list.size();
            arrList.add(list.remove(idx));
        }

        //출력
        StringBuilder sb = new StringBuilder();

        sb.append("<");
        for(int i=0; i< arrList.size(); i++) {
            sb.append(arrList.get(i));

            if( i < arrList.size()-1)
                sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb.toString());

    }//end main
}