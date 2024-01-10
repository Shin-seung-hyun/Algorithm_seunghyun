import java.util.*;
import java.io.*;

/*
    완전탐색 O(2^N)
    DP O(N^2)
    이분탐색 O(Nlog^N)
    투 포인터 O(N)
*/
class Main{
    static int N;   // 수열의 길이
    static int[] arr; // 수열을 저장
    static int[] Dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Dy = new int[N+1];
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //가짜식 Dy[i] : i가 제일 큰 수일 때, 가장 긴 증가하는 부분 수열의 길이
        //초기화
        Dy[1] = 1;

        //점화식1
        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){

                if( arr[i] <= arr[j]) continue;
                Dy[i] = Math.max(Dy[j], Dy[i]);
            }
            Dy[i] +=1 ;
        }

        //점화식2
        for(int i =2; i<=N; i++){
            Dy[i] = 1;

            for(int j =1; j<= i; j++){
                if(arr[j] < arr[i] && Dy[i] <= Dy[j]){
                    Dy[i] = Dy[j] + 1;
                }
            }
        }

        int cnt= 0;
        for( int val : Dy) cnt = Math.max(cnt, val);

        System.out.println(cnt);
    }
}