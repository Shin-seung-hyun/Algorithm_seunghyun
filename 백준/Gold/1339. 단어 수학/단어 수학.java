import java.util.*;
import java.io.*;

// 완전탐색(BF)
/// 나올 수 있는 알파벳의 종류가 총 10개임으로 모든 경우의 수는 10! = 3,628,800
/// 각 경우마다 알파벳 -> 숫자로 치환하는 연산 = 단어의 수 10 * 단어의 길이 8 = 80
/// 즉 시간 복잡도는 O(10!)

// 예시
// GCF + ACDEB
// = (100G + 10C + 1F) + (10000A + 1000C + 100D + 10E + 1B)
// = 10000A + 1B + 1010C + 100D + 10E + 1F + 100G
// 높은값부터 9~0씩 곱하기
public class Main {

    static int N;    //N 개의 단어
    static String[] str;
    static int[] alpha = new int[26];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        str = new String[N+1];
        for(int i =1; i<=N; i++){
            str[i] = br.readLine();
        }

        solve();

        System.out.println(result);
    }

    //// = 10000A + 1B + 1010C + 100D + 10E + 1F + 100G 만들기
    static void solve(){

        for(int i =1; i<=N; i++){

            int tmp = (int)Math.pow(10, str[i].length() -1);

            for(int j = 0; j< str[i].length(); j ++){

                int val = str[i].charAt(j) - 'A';
                alpha[val] = alpha[val] + tmp;

                tmp /= 10;
            }
        }

        // 큰 순서 대로 정렬
        Arrays.sort(alpha);

        // 높은값부터 9~0씩 곱하기
        int num = 9;
        for (int i = 25; i >= 0; i--) {
            if (alpha[i] == 0) continue;

            result += (alpha[i] * num);
            num--;
        }

    }
}