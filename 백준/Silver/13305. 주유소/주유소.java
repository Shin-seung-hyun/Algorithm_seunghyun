import java.util.*;
import java.io.*;

// 오른쪽 도시로 이동하는 최소 비용을 구하시오
class Main{

    static int N;   // 도시의 수
    static int[] dist;  // 도로의 길이
    static int[] cost;  // 리터당 주유 가격

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dist = new int [N];
        cost = new int [N+1];

        // 거리 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        // 비용 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        //리터당 기름 값이 '내림차순'일 경우에 주유하기
        long totalCost = 0;  // 최종 비용
        int minCost = cost[1]; // 이전 중 최소 주유 비용
        for(int i=1; i<=N-1; i++){

            // 현재 주유소가 이전 주유소의 기름값보다 쌀 경우 minCost 갱신
            if(minCost > cost[i]){
                minCost = cost[i];
            }

            totalCost += minCost * dist[i];
        }

        System.out.println(totalCost);
    }
}
