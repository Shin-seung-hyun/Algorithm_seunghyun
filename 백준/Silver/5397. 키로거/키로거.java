import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        LinkedList<Character> list;

        for(int t= 1; t<=testCase; t++){
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();

            int L = str.length();

            //연결 리스트 선언 및 삽입
            list = new LinkedList<>();

            // 커서
            /*
                커서의 길이는 str.length 까지
                 str:      a   b   c   d
                cursor : 0   1   2   3   4
            */
            int cursor = 0;

            for(char c : str.toCharArray()){

                switch (c) {

                    case '-' :      // 백스페이스, 커서의 왼쪽 삭제
                        if(cursor > 0){
                            cursor--;
                            list.remove(cursor);
                        }
                        break;

                    case '<' :      // 오른쪽으로 1 이동
                        if(cursor > 0) cursor--;
                        break;

                    case '>' :      // 왼쪽으로 1 이동
                        if( cursor < list.size()) cursor++;
                        break;

                    default:        // 비밀번호
                        list.add(cursor, c);
                        cursor++;
                        break;
                }
            }

            //출력
            for(char c : list) sb.append(c);
            System.out.println(sb.toString());

        }// end tesCase

    }//end main
}