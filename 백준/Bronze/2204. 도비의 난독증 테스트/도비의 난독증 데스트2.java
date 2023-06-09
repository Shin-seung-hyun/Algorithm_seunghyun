import java.util.*;
import java.io.*;

//문자열
// 대소문자를 구분하지 않고 사전순으로 가장 앞서는 문자열 출력
class test{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            int N =Integer.parseInt(br.readLine());

            if(N == 0) break;

            List<String> list = new ArrayList<>();

            for(int i =0; i<N; i++){
                list.add(br.readLine());
            }

            Collections.sort(list, new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    return o1.toUpperCase().compareTo(o2.toUpperCase());
                }
            });

            System.out.println(list.get(0));
        }

    }
}