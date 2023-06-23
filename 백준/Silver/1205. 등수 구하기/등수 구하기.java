import java.util.*;
import java.io.*;

//새로운 점수가 랭킹 리스트에서 몇 등 하는지 구하시오
//단 ,점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1을 출력
class Main{
    static int P;   // 랭킹에 올라갈 수 있는 점수의 수
    static int N;   // 점수
    static int newScore;
    static int []arr;

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

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 내림차순 정렬
            //Collections.reverseOrder()를 적용하기 위해서는
            // sort 메서드의 첫번째 인자가 T[]임으로 Integer[] 로 변경이 필요함
            // int[] -> Integer[]
        Integer[] conv = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(conv, 1, N+1, Collections.reverseOrder());

        // 랭킹 리스트가 다 차있고, 제일 낮은 점수보다 새로운 점수가 낮거나 같을 때 -1
        if( N == P && conv[N] >= newScore){
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for(int i=1; i<=N; i++){

            if(conv[i] > newScore) rank++;
            else break;
        }

        System.out.println(rank);
    }

}
