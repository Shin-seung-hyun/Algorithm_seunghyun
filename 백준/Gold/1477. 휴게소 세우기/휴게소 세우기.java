import java.util.*;
import java.io.*;

// 매개 변수 탐색 알고리즘
    // 휴게소가 없는 구간의 최소길이
public class Main{
    static int N;   // 현재 휴게소의 개수
    static int M;   // 더 지으려고 하는 휴게소의 개수
    static int L;   // 고속도로의 길이
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 도로의 시작, 도로의 끝 휴게소 위치 저장
        arr[0] = 0;
        arr[N+1] = L;

        // 정렬
            //0 82 201 411 555 622 755 800
        Arrays.sort(arr,1,N+1);

        search();
    }

    static void search(){
        //휴게소를 M개 지었을 때, 휴게소 사이의 거리의 최댓값이 D 이하게 되게 만들 수 있는가? -> T/F
        int left = 1;
        int right = L -1 ;
        int result = 0;

        while(left <= right){
            int mid = (left + right)/2;

            int sum =0;
            for(int i =1; i< N+2; i++){
                //휴게소 사이의 거리가 mid 일때, 현재 휴게소 사이에 새로 넣을 수 있는 휴게소 수
                    //이미 존재하는 휴게소 시작과 끝에는 휴게소를 설치할 수 없음으로, 설치 가능한 거리는 -1
                sum += ( arr[i] - arr[i-1] -1)/ mid;
            }

            if(sum > M){
                left = mid +1;
            }
            else {
                right = mid -1;
                result = mid;
            }
        }

        System.out.println(result);
    }

}