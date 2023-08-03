import java.io.*;
import java.util.*;

// 문자열
// 1. 첫번째 문자열 길이 * 두번째 문자열 길이 만큼 늘리기
// 2. 두 문자열 비교
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String first = br.readLine();
        String second = br.readLine();

/* 방법1 */
//        String f = first.repeat(second.length());
//        String s = second.repeat(first.length());
//
//        if(f.equals(s)) System.out.println(1);
//        else System.out.println(0);

/* 방법2 */
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i= 0; i< first.length(); i++){
            sb2.append(second);
        }

        for(int i=0; i< second.length(); i++){
            sb1.append(first);
        }

//      System.out.println(sb1.toString());
//      System.out.println(sb2.toString());

        if(sb1.toString().equals(sb2.toString())) System.out.println(1);
        else System.out.println(0);
    }

}

