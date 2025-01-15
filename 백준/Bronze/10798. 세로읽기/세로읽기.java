import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //2차원 배열
        char s[][] = new char[5][];
        for(int i = 0; i < 5; i++) {
            s[i] = br.readLine().toCharArray();
        }

        for(int j = 0; j < 15; j++) {
            for(int i = 0; i < 5; i++) {
                if(j < s[i].length) sb.append(s[i][j]);
            }
        }

        System.out.println(sb.toString());
    }
}
