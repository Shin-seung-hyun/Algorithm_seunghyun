import java.util.*;
import java.io.*;

/*

    완전탐색으로 풀 때 시간복잡도 : O(N * M) -> O(N^2) // 시간 초과 발생
    DP로 풀 때 시간복잡도 : O(N +M) -> O(N)

    <Prefix Sum(부분 합) 개념 활용>
    - 1 ~ i 개의 수를 입력 받아 합 배열 생성
      Dy[i] = A[1] + A[2] + .. + A[i]
      Dy[i] = Dy[i-1] + A[i]
        
    - i ~ j 까지의 구간합
      A[i] + A[i+1] + ... + A[j] 
      = (Dy[1] + Dy[2] + ... Dy[j]) + (Dy[1] + Dy[2] + .. + Dy[i-1])
      =  Dy[j] - Dy[i-1]

*/
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());


        //Dy 배열 채우기
        int Dy[] = new int[100_000 + 1];

        for(int k=1; k<=N; k++){

            Dy[k] = Dy[k-1] + arr[k];
        }


        // 정답 출력
        int i,j;
        for(int k=1; k<=M; k++){
            st = new StringTokenizer(br.readLine());

            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            System.out.println( Dy[j] - Dy[i-1]);
        }


    }

}