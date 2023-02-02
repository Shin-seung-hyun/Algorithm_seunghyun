import java.util.Scanner;
import java.util.Arrays;

//이분 탐색 -> 매개 변수 탐색 알고리즘
public class Main{

    public static int N; // 집의 개수
    public static int C; // 공유기의 개수
    public static int[] arr;

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        arr = new int[N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        //fromIndex는 포함, toIndex는 미포함
        Arrays.sort(arr , 1 ,N+1);

        //이분 탐색
            //공유기를 C개 설치할 때, 공유기 사이 거리의 최대값은?
            //공유기 사이의 거리가 x일 때, 공유기 C개를 설치할 수 있는가?
        search();
    }

    public static boolean determination(int D){
        
        //공유기는 첫번째 좌표에 무조건 설치한다고 가정
        int cnt =1;
        int install = arr[1];

        for(int i =2 ;i <= N; i++){
            if((arr[i] - install) >= distance){
                install = arr[i];
                cnt++;
            }
        }

        return cnt >= C;
    }

    public static void search(){

        int left =1;
        int right = 1_000_000_000; //10억
        int result = 0;

        //가능한 설치 거리 중, 가장 작은 설치 거리
            //현재 거리가 설치 가능하다면 더 먼거리가 설치 가능한지 확인
        while(left <= right){
            int mid = (left + right) /2;

            if(determination(mid)){

                result = mid;
                left = mid +1;
            }
            else{
                right = mid -1;
            }

        }

        System.out.println(result);
    }

}