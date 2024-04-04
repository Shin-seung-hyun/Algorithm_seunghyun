import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());    // 반의 수
        for(int i=1; i<=K; i++){

            st = new StringTokenizer(br.readLine());
            int stuNum = Integer.parseInt(st.nextToken());

            int []arr = new int[stuNum];

            for(int j=0; j<stuNum; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int largestGap = 0;
            for(int k = arr.length-1; k > 0; k--){
                largestGap = Math.max(largestGap, arr[k] - arr[k-1]);
            }

            sb.append(  "Class " + i + "\n");
            sb.append(  "Max " + arr[stuNum-1] + ", " +
                        "Min " + arr[0] + ", " +
                        "Largest gap " + largestGap + "\n");
        }

        System.out.print(sb.toString());
    }
}
