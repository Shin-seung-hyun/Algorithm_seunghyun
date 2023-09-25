import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 경기 수
        int M = Integer.parseInt(st.nextToken());   // 위원 수

        int []cost = new int [N];
        for(int i =0; i<N; i++) cost[i] = Integer.parseInt(br.readLine());

        int [] vote = new int [N];

        for(int i=0; i<M; i++){
            int c = Integer.parseInt(br.readLine());

            for(int j = 0; j<N; j++){
                if( cost[j] <= c) {
                    vote[j]++;
                    break;
                }
            }
        }

        //System.out.println(Arrays.toString(vote));

        // 출력
        int max = vote[0];
        int idx = 0;
        for(int i =0; i<N; i++){
            if(max < vote[i]){
                max = vote[i];
                idx = i;
            }

        }

        System.out.println(idx+1);
    }

}