import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int result = Math.min( Math.abs(x), Math.abs(y));
        result = Math.min(result, Math.abs( y-h));
        result = Math.min(result, Math.abs( x-w));

        System.out.println(result);

    }

}
