import java.io.*;

//BF
// O(3000 * 10 = 30000)
// 최대 3000자리, 0~9까지는 10개 -> 3000 * 10 = 30000 내에서 찾아짐
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int strIndex = 0;

        for(int N=1; N< 30_000; N++){
            String tmp = String.valueOf(N);

            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == str.charAt(strIndex))
                    strIndex++;

                if (strIndex == str.length()) {
                    System.out.println(N);
                    return;
                }
            }

        }

    }
}