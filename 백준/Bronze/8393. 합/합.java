import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int sum =0;
        for(int i=1; i<=n; i++) sum+=i;
        System.out.println(sum);

    }
}