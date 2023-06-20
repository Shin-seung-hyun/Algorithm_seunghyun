import java.io.*;
import java.util.*;

//BF
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [][]arr = new int [N][2];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i][0] = weight;
            arr[i][1] = height;
        }


        for(int i=0; i<N; i++){
            int rank = 1;
            for(int j =0; j<N; j++){

                if( i == j ) continue;

                // 자신 보다 큰 사람이라면 rank를 증가
                if( arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank++;
            }
            sb.append(rank + " ");
        }

        System.out.print(sb.toString());
    }
}