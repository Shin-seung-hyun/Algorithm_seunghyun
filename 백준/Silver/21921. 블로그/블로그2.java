import java.util.*;
import java.io.*;

// 슬라이딩 윈도우
class Main{

    static int N;   //전체 일수
    static int X;   //알고 싶은 기간
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    static void solve(){
        int sum = 0;
        for(int i=1; i<=X; i++) sum += arr[i];

        int max = sum;
        int maxCnt =1;
        for(int i= X+1; i<=N; i++){

            // arr[i] : 새로운 것은 더하고
            // arr[i-X]: 기존의 것은 빼자
            sum = sum + arr[i] - arr[i-X];

            if(max == sum) maxCnt++;

                // 최댓값 갱신
            else if ( max < sum){
                max = sum;
                maxCnt = 1;
            }
        }

        if( max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(maxCnt);
        }
    }

}
