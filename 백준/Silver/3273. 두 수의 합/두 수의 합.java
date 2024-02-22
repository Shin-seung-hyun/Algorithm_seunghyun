import java.io.*;
import java.util.*;

//배열
    //공간복잡도 O(2_000_000), 시간복잡도 O(n)
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];
        boolean checkArr[] = new boolean[2_000_000 +1];

        st  = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        int cnt =0;
        for(int i= 1; i<=N; i++){

            int target = X -arr[i];

            if( target > 0 && checkArr[target]) cnt++;

            // 중복 cnt++ 방지를 위해 true로 변경
            checkArr[arr[i]] = true;
        }

        System.out.println(cnt);

    }

}