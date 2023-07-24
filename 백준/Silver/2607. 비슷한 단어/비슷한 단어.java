import java.io.*;
import java.util.*;

//더하거나, 빼거나, 바꾸거나 -> 비슷한 단어
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] alphabet = new int [26];
        int [] check;

    // 기준 문자열
        String standard = br.readLine();
        for(int i=0; i<standard.length(); i++){
            alphabet[standard.charAt(i) - 'A']++;
        }

    //나머지 문자열
        int result = 0;
        for(int i=1; i<N; i++){
            String str = br.readLine();

            // 길이가 1넘게 차이나면 비슷한 수 X
            if(Math.abs(str.length() - standard.length()) > 1) continue;

            check = alphabet.clone();   // alphabet 배열 복사
            int cnt =0; //기준값과 같은 알파벳의 개수
            for(int j=0; j<str.length(); j++){

                //str 문자열의 알파벳이 standard 알파벳에도 존재하면 cnt++
                if( check[ str.charAt(j) - 'A'] >0 ){
                    cnt++;
                    check[ str.charAt(j) - 'A']--;  // 단어가 중복 등장할 경우 대비
                }
            }

        // 조건 비교
            // 기준 문자열 길이와 비교 문자열 길이 차이
            // 같은 경우 or 한 글자만 바뀐경우
            if(standard.length() == str.length() && (standard.length() == cnt || standard.length() - 1 == cnt)) {
                result++;
            }
            // 비교 문자열이 짧은 경우 (제거)
            else if (standard.length() == str.length() - 1 && str.length() - 1 == cnt) {
                result++;
            }
            // 비교 문자열이 긴 경우 (추가)
            else if (standard.length() == str.length() + 1 && str.length() == cnt) {
                result++;
            }

        }

        System.out.println(result);
    }
}