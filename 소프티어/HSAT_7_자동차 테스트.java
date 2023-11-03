import java.io.*;
import java.util.*;

/*
    문제 : [HSAT 7회 정기 코딩 인증평가 기출] 자동차 테스트
    링크 : https://softeer.ai/practice/6247

    풀이 :
    N = 50_000, Q = 200_000 임으로 하나씩 찾으면 10^9 -> 시간 초과
    즉, 이분 탐색으로 풀어야 함!
        O( Q * logN)
*/

public class Main {

    static int[] arr;
    static int N,Q;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 전체 자동차 수
        Q = Integer.parseInt(st.nextToken()); // 질의 갯수

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1 2 3 5 6
        Arrays.sort(arr);

        for(int i=0; i<Q; i++){
            int M = Integer.parseInt(br.readLine());

            int idx = findIdx(M);

            if( idx <= 0 || idx >= N-1 ) sb.append("0\n");

                // M보다 작은 경우의 수 * M보다 큰 경우에서 뽑을 경우 (N-1) - (idx+1) +1
            else sb.append( idx * (N - (idx + 1)) + "\n");
        }

        System.out.print(sb.toString());
    }

    static int findIdx(int find){

        int left = 0;
        int right = N-1;
        int result = -1;
        while( left <= right){

            int mid = (left + right)/2;

            if( arr[mid] < find){
                left = mid +1;
            }
            else if ( arr[mid] > find){
                right = mid -1;
            }
            else return mid;        // arr[mid] == find
        }

        return result;
    }
}
