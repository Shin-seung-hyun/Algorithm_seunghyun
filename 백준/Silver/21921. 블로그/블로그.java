import java.util.*;
import java.io.*;

// 투 포인터
class Main{

    static int N;   //전체 일수
    static int X;   //알고 싶은 기간
    static int[] arr;   // 방문객 배열

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

        twoPointer();
    }

    static void twoPointer(){
        int right = 1;
        int sum = 0;
        int max = 0;
        int maxCnt = 1;

        for(int left =1; left<= N - X + 1; left++){

            while(right <= N && right - left +1 <= X){
                sum += arr[right];
                right++;
            }

            if( max == sum) maxCnt++;
            else if(sum > max){
                max = sum;
                maxCnt = 1;
            }

            sum -= arr[left];
        }


        // 출력
        if( max == 0){
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(maxCnt);
    }
}
