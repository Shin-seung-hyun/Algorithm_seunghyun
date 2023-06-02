import java.util.*;
import java.io.*;

//장애물의 최솟값과 그러한 구간이 총 몇 개 있는지
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

        top = new int[N/2 +1];
        bottom = new int [N/2+1];

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
        int answer = N;
        int answer_cnt = 0;
        int broken = 0;

        for(int i =1; i<=H; i++){

            //이분탐색을 통해 부순 장애물 갯수 확인
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

    static int search(int h){

        // 석순
        int left = 1;
        int right = N/2;
        int answer = 0;
        int bottom_cnt = 0;

        //h보다 작은 수가 몇 개 있을까 탐색
        while(left <= right){
            int mid = (left + right)/2;

            if(bottom[mid] >= h) right = mid -1;
            else{
                left = mid +1;
                answer = mid;
            }
        }
        bottom_cnt = N/2 - answer;

        // 종유석
        left= 1;
        right = N/2;
        answer = 0;
        int top_cnt = 0;

        // H - h 보다 작은 수가 몇 개 있을까 탐색
        while(left <= right){
            int mid = (left + right)/2;

            if(top[mid] >= H - h+1) right = mid -1;
            else {
                left = mid +1;
                answer = mid;
            }
        }
        top_cnt = N/2 - answer;

        return bottom_cnt + top_cnt;
    }

}