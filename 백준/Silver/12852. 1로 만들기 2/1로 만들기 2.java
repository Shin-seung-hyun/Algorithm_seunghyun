import java.util.*;
import java.io.*;

/*
DP + 역순 출력

    `1로 만들기`와 소스 코드 비교! (경로 탐색 X)
    https://www.acmicpc.net/problem/1463

        //점화식
        for (int i = 2; i <= N; i++){

        // Dy[i] = Math.min( Dy[i-1]+1, Dy[i/2]+1, Dy[i/3]+1)의 개념
            // 1을 빼는 경우
            Dy[i] = Dy[i-1] + 1;

            // 1을 뺀 경우, 2로 나눈 경우 중 최솟값을 Dy[i] 저장
            if (i % 2 == 0) Dy[i] = Math.min(Dy[i], Dy[i/2] + 1);

            // 1을 뺀 경우와 2로 나눈 경우의 최솟값인, Dy[i]와 3로 나눈 경우 중 최솟값을 Dy[i] 저장
            if (i % 3 == 0) Dy[i] = Math.min(Dy[i], Dy[i/3] + 1);
        }

        System.out.println(Dy[N]);
*/

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int[] Dy = new int[N+1];
        int[] pre = new int[N+1];   // 이전 경로를 저장해주는 배열

        ///초기화
        Dy[1] = 0;

        // 점화식
        for(int i=2; i<=N; i++){

            Dy[i] = Dy[i-1] +1;
            pre[i] = i-1; // 최적의 값을 저장함.

            if(i%3 ==0 && Dy[i] > Dy[i/3] + 1){
               Dy[i] = Dy[i/3] +1;
               pre[i] = i/3;
            }

            if(i%2 ==0 && Dy[i] > Dy[i/2] +1){
                Dy[i] = Dy[i/2] +1;
                pre[i] = i/2;
            }
        }

        // 최소 횟수 출력
        System.out.println(Dy[N]);

        // 경로 출력
        int cur =N;
        while(true){
            System.out.println(cur);
            if(cur == 1) break;
            cur = pre[cur];
        }

    }
}