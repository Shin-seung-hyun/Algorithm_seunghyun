import java.util.*;
import java.io.*;

// 한 명이 가져 간 보석의 수가 최소가 되게 해라
// 단 학생은 하나의 색만 가질 수 있다.
// 보석을 가지지 못해도 됨

//한명이 가져 간 보석의 수가 x 일 때, N명에게 나눠 줄 수 있는가?

//이분 탐색 알고리즘
    //매개 변수 탐색 알고리즘
class Main{
    static int N;   // 학생 수
    static int M;   // 색깔 종류
    static int [] arr;  // 색깔 별 보석의 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M+1];

        for(int i =1; i<=M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        search();
    }

    public static void search(){
        int left = 1;
        int right = 0;
        for(int i =1; i<=M; i++){
            right = Math.max(right, arr[i]);
        }
        int result = 0;

        while(left <= right){
            int mid = (left + right)/2;

            int cnt = 0;
            for(int i =1; i<=M; i++){
                cnt = cnt + (arr[i]/mid);
                if(arr[i] % mid != 0) cnt++;
            }

            if(cnt > N ){
                left = mid +1;
            }
            else{
                right = mid -1;
                result = mid;
            }
        }

        System.out.println(result);

    }
}