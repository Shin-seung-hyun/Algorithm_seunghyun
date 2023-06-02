import java.util.*;
import java.io.*;

//장애물의 최솟값과 그러한 구간이 총 몇 개 있는지
// 1. 구간(1 ~ H)에 따른 장애물의 수를 찾는다. 이때, 장애물 수는 U자 곡선을 그리게 된다.
// 2. 통과 구간(height)이 정해지고 정렬한 석순, 종유석에 대해 binary search로 장애물 수 구하기.
//    시간 복잡도 O(NlogN + HlogN)
class Main{
    static int N;   // 동굴의 길이
    static int H;   // 높이
    static int[] top;       // 종유석 배열
    static int[] bottom;    // 석순 배열

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        top = new int[N/2 + 1];
        bottom = new int [N/2 + 1];

        for(int i =1; i<=N; i++){

            //짝수(종유석)
            if(i % 2 == 0) top[i/2] = Integer.parseInt(br.readLine());

                //홀수(석순)
            else bottom[i/2 +1] = Integer.parseInt(br.readLine());
        }

        // 이분탐색을 위한 정렬
        Arrays.sort(top);
        Arrays.sort(bottom);

        solve();
    }

    static void solve(){
        int answer = N;     // 장애물의 최솟값
        int answer_cnt = 0; // 최솟값 구간의 갯수
        int broken = 0;

        for(int i =1; i<=H; i++){

            //이분탐색을 통해 부순 장애물 수(= i 보다 크거나 같은 수) 구하기
            broken = search(i);

            if(answer == broken) answer_cnt++;

            //장애물의 최솟값 갱신
            if(answer > broken){
                answer = broken;
                answer_cnt = 1;
            }
        }
        System.out.println(answer + " " + answer_cnt);
    }

    static int search(int height){

        /* 석순 탐색 */
        int left = 1;
        int right = N/2;
        int result = 0;

        //h보다 작은 수 찾기
        while(left <= right){
            int mid = (left + right)/2;

            if(bottom[mid] >= height) right = mid -1;
            else{
                left = mid +1;
                result = mid;
            }
        }

        // N/2개 중 h보다 큰거나 같은 수의 갯수 구하기
        int bottom_cnt = N/2 - result;

        /* 종유석 탐색 */
        left= 1;
        right = N/2;
        result = 0;

        // H - height +1 보다 작은 수 찾기
        while(left <= right){
            int mid = (left + right)/2;

            if(top[mid] >= H - height+1) right = mid -1;
            else {
                left = mid +1;
                result = mid;
            }
        }

        // N/2 개 중 H-height+1 보다 크거나 같은 수의 갯수
        int top_cnt = N/2 - result;


        /* 전체 부순 장애물의 수 */
        return bottom_cnt + top_cnt;
    }

}