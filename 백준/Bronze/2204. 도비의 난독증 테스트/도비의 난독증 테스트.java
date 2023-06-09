import java.util.*;
import java.io.*;

//문자열
// 대소문자를 구분하지 않고 사전순으로 가장 앞서는 문자열 출력
public class Main {

    static int N;
    static String[] strArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0 ) break;

            strArr = new String[N+1];
            for(int i=1; i<=N; i++){
                strArr[i] = br.readLine();
            }

            // 대소문자 구분 없이 정렬하는 방법
            Arrays.sort(strArr, 1, N+1, String.CASE_INSENSITIVE_ORDER);
            System.out.println(strArr[1]);
        }
    }
}