import java.io.*;
import java.util.*;

// 투 포인터
public class Main {

    static int N;   // 정수의 길이
    static int K;   // 중복 허용 갯수
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열 입력
        arr = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
    }

    static void twoPointer(){

        int[] visit = new int [100_000 +1];
        int right = 0;
        int cnt = 0;

        for(int left = 0; left < N; left++){

            while( right < N && visit[arr[right]] +1 <= K){

                visit[arr[right]]++;
                right++;
            }

            cnt = Math.max(cnt, right - left);

            visit[arr[left]]--;
        }

        System.out.println(cnt);
    }

    //twoPointerError() 의 경우  right가 N보다 커서 증감이 멈춰진 경우 반례가 생김
    static void twoPointerError(){

        arr = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] visit = new int [100_000 +1];
        int right = 0;
        int cnt = 0;

        for(int left = 1; left <= N; left++){

            while( right+1 <= N && visit[arr[right]] <= K){
                right++;
                visit[arr[right]]++;
            }

            cnt = Math.max(cnt, right - left);

            visit[arr[left]]--;
        }

        System.out.println(cnt);
    }
}

