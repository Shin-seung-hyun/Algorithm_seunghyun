import java.util.*;
import java.io.*;

//문자열
// 대소문자를 구분하지 않고 사전순으로 가장 앞서는 문자열 출력
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            int N =Integer.parseInt(br.readLine());

            if(N == 0) break;

            ArrayList<String> arrList = new ArrayList<>();

            for(int i =0; i<N; i++){
                arrList.add(br.readLine());
            }

        /* ArrayList 정렬 */
            // 방법1. 익명 클래스로 Comparator 생성
            Collections.sort(arrList, new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    return o1.toUpperCase().compareTo(o2.toUpperCase());
                }
            });

            // 방법2. 람다식으로 Comparator 생성
            Collections.sort(, (o1,   o2) -> o1.toUpperCase().compareTo(o2.toUpperCase() ));

            System.out.println(arrList.get(0));
        }

    }
}