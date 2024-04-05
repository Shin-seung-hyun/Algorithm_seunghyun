import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();

        int cnt = 0;
        while(str.length() >=2){

            int sum = 0;
            for( char c : str.toCharArray()){
                sum += (c - '0');
            }

            str = String.valueOf(sum);
            //System.out.println(str);
            cnt++;
        }

        System.out.println(cnt);
        if( Integer.parseInt(str) % 3 ==0) System.out.println("YES");
        else System.out.println("NO");
    }
}
