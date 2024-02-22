import java.util.*;
import java.io.*;

//연결 리스트
    /*
        LinkedList :      임의의 위치에 삽입/삭제는 한 번에 O(1)복잡도를 지님
                           즉, 최종적으로 O(M)
                           단, iterator 사용해야 함.

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
        for(char c : str.toCharArray()) linkedList.add(c);

        //iterator 메소드 호출
        ListIterator<Character> cursor = linkedList.listIterator();

        //처음 커서는 문장의 맨 뒤에 있어야 하기 때문에 커서를 맨뒤로 이동(ex. abc|)
        while (cursor.hasNext()) {
            cursor.next();
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            char op = st.nextToken().charAt(0);

            switch(op){
                case 'L' :          // 왼쪽으로 이동
                    if(cursor.hasPrevious()) cursor.previous();
                    break;

                case 'D' :          // 오른쪽으로 이동
                    if(cursor.hasNext()) cursor.next();
                    break;

                case 'B' :          // 커서의 왼쪽 문자 삭제
                    //remove()는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거
                    if(cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;

                case 'P' :          // 커서의 왼쪽에 문자 추가
                    char addChar = st.nextToken().charAt(0);
                    cursor.add(addChar);
                    break;
            }
        }

        //출력
        for(char c : linkedList) sb.append(c);
        System.out.print(sb.toString());
    }
}