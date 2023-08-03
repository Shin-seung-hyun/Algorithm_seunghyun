import java.util.*;
import java.io.*;

// 문자열
/* 풀이
    1. 문자열의 길이가 길이가 같으면 바로 비교
    2. 문자열의 길이가 다르면, 최소공배수를 구하기
        두 문자열을 최소공배수만큼 늘리기
    3. 두 문자열 비교

*/
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        String F = first;
        String S = second;

        if (first.length() != second.length()) {

            // 최소공배수 구하기
            int len = lcd(first.length(), second.length());

            while (F.length() != len) {
                F += first;
            }

            while (S.length() != len) {
                S += second;
            }
        }

        if (F.equals(S)) System.out.println(1);
        else System.out.println(0);
    }

    private static int lcd(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        int tmp;
        while (b > 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }
}