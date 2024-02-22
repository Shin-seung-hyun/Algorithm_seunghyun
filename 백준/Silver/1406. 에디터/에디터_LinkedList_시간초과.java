import java.util.*;
import java.io.*;

/*
시간초과 코드
LinkedList : (찾아가는 상황을 제외하고, 삽입삭제만 본다면)
             임의의 위치에 삽입/삭제는 한 번에 O(1)복잡도를 지님.
             즉, M번의 연산을 통해 O(M) 시간복잡도를 가진다.

             그러나, LinkedList.add(index, element)와 .remove(index)는
             사용할 때마다 커서 위치부터 탐색(최악 O(N)) + 삽입/삭제를(O(1)) 해야함으로
             최악의 경우 O(N * M)의 복잡도를 가진다.

LinkedList + iterator: iterator를 사용한다면, iterator가 현재 위치를 기억하고 있음으로
                       현재 위치에 대한 접근, 삽입, 삭제 연산을 O(1)시간 안에 할 수 있다.
                       따라서 iterator 사용시, 시간 복잡도 = O(M)이 된다.

ArrayList,Array : 임의의 위치에 삽입/삭제는 한 번에 O(N) 복잡도를 지님
                  즉, 최종적으로 O(N*M)
*/


class Main{
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int N = str.length();
        int M = Integer.parseInt(br.readLine());    // 입력할 명령어의 수

        //연결 리스트 선언
        LinkedList<Character> linkedList = new LinkedList<>();

        //연결 리스트 입력
        //for(int i=0; i<N; i++) linkedList.add(str.charAt(i));
        for(char c : str.toCharArray())linkedList.add(c);

        int cursor = linkedList.size();

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            char op = st.nextToken().charAt(0);

            switch(op){
                case 'L' :          // 왼쪽으로 이동
                    if(cursor >0) cursor--;
                    break;

                case 'D' :          // 오른쪽으로 이동
                    if(cursor < linkedList.size()) cursor++;
                    break;

                case 'B' :          // 커서의 왼쪽 문자 삭제
                    if(cursor > 0) linkedList.remove(--cursor);
                    break;

                case 'P' :          // 커서의 왼쪽에 문자 추가
                    char addChar = st.nextToken().charAt(0);
                    linkedList.add(cursor++, addChar);
                    break;
            }
        }

        //출력
        for(char c : linkedList) sb.append(c);
        System.out.print(sb.toString());
    }
}