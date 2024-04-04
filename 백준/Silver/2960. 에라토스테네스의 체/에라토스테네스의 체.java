import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());   // K번째로 지워진 수

        boolean []arr = new boolean[N+1];

        int cnt = 0;
        for(int i =2; i<=N; i++){

            if( arr[i]) continue;

            for( int j = i; j<=N; j= i+j) {
                if(arr[j]) continue;

                arr[j] = true;
                cnt++;

                if ( cnt == K) {
                    System.out.println( j);
                    return;
                }
            }
        }

    }
}
