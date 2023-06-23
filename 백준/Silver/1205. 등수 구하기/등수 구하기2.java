import java.util.*;
import java.io.*;

//새로운 점수가 랭킹 리스트에서 몇 등 하는지 구하시오
//단 ,점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1을 출력
class Main{
    static int P;   // 랭킹에 올라갈 수 있는 점수의 수
    static int N;   // 점수
    static int newScore;
    static Integer []arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        newScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 리스트에 점수가 0이라면 새점수는 무조건 1등
        if( N == 0 ){   // P는 10 <= P <= 50인 정수
            System.out.println(1);
            return;
        }

        arr = new Integer[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //내림차순 정렬
        Arrays.sort(arr,1,N+1, Collections.reverseOrder() );

        int rank = 0;
        int sameValue = 0;
        for(int i=1; i<=N; i++){

            if(arr[i] > newScore){
                rank++;
            }
            else if( arr[i] == newScore) sameValue++;
        }

        if( rank + sameValue >= P  ) System.out.println(-1);
        else System.out.println(rank + 1);
    }

}
