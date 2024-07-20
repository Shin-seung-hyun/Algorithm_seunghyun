import java.io.*;
import java.util.*;

//큐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int sum =0;
        for(int i=1; i<=N; i++){

            int cnt = 0;
            int tmp = i;
            while(tmp > 0){

                tmp = tmp/10;
                cnt++;
            }
            sum+=cnt;
            //System.out.println(cnt);
        }
        System.out.println(sum);

    }
}