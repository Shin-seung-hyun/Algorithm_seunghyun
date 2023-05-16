import java.util.*;
import java.io.*;

// 방법2. BF + 이분탐색
    // 1. 버스의 모든 시간을 입력하여 정렬한다.
    // 2. 정렬된 버스를 기준으로 영식이의 도착시간이 가장 빠른 시간보다 빠르거나 가장 늦은 시간보다 늦으면 brute force로 구하고,
    //    중간에 있을 경우 binary search로 도착시간과 같거나, 늦은 시간중 가장 이른 시간을 구해서 도착시간에서 빼준다.

class Main{
    static int N;   // 버스의 개수
    static int T;   // 터미널 도착 시간
    static ArrayList<Integer> busTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        busTime = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            //맨처음 시간 S부터 저장
            for(int j =0; j<C; j++) busTime.add(S + I * j);

//            for (int j = 1; j <= C; j++) {
//                busTime.add(S);
//                S = S + I;
//            }
        }

        //버스의 모든 시간 정렬
        Collections.sort(busTime);

        twoPointer();
    }

    static void twoPointer(){

        // 버스가 없을 때 (터미널에서 너무 늦게 도착했을 때 : S)
        if(busTime.get(busTime.size()-1) < T){
            System.out.println(-1);
            return;
        }

        // 맨 처음 버스 출발 시간보다 도착 시간이 빠를 때
        if(busTime.get(0) >= T){
            System.out.println( busTime.get(0) - T);
            return;
        }


        // 버스 시간 내에 터미널에 도착했을 때
        long left = 0;
        long right = busTime.size()-1;
        long result = 0;

        while(left <= right){

            long mid = (left + right)/2;

            if(busTime.get((int)mid) == T){
                System.out.println(0);
                return;
            }
            else if (busTime.get((int)mid) > T ){
                result = mid;
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(busTime.get((int)result) - T);
    }

}