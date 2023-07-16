import java.util.*;
import java.io.*;

// 문자열
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        ArrayList<String> arrList = new ArrayList<>();

        for (int i = 2; i < word.length(); i++) {
            for (int j = 1; j < i; j++) {
                StringBuilder strSb1 = new StringBuilder(word.substring(0, j));
                StringBuilder strSb2 = new StringBuilder(word.substring(j, i));
                StringBuilder strSb3 = new StringBuilder(word.substring(i));
                
                String str1 = strSb1.reverse().toString();
                String str2 = strSb2.reverse().toString();
                String str3 = strSb3.reverse().toString();
                
                arrList.add(str1 + str2 + str3);

            }
        }
        
        // 정렬
        Collections.sort(arrList);
        
        // 출력
        System.out.println(arrList.get(0));
    }
}
