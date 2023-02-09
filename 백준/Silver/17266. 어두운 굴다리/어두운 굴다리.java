import java.util.*;
import java.io.*;

//이분 탐색
    //매개 변수 탐색 알고리즘
        // 굴다리 길이 N을 모두 비추기 위한 가로등의 최소 높이는?
        // 가로등의 높이기 [] 일 때, 굴다리 길이 N을 모두 비출 수 있는가?
public class Main{

    public static int N;        // 굴다리의 길이
    public static int M;        // 가로등의 개수
    public static int arr[];    // 가로등의 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int [M+1];
        for(int i =1; i<=M; i++){
            arr[i] = sc.nextInt();
        }

        search();
    }
    public static boolean determination(int len){

        //이전 가로등이 마지막으로 바춘 지점
            //0 지점부터 모두 비춰주어야 하기 때문에 0부터 시작
        int last = 0;
        for(int i =1; i<=M; i++){
            /*
                가로등 위치에서 높이를 빼면, 가로등이 비추는 최솟값
                이 최소값을 기준으로 가로등이 빈곳없이 다 비추는지 조건을 확인
            */

            //가로등이 비춰진다면
            if(arr[i] - len <= last){
                //최대 비추는 값을 last로 둠
                last = arr[i]+ len;
            }
            else{
                return false;
            }
        }
        return last >= N;
    }

    public static void search(){
        int left = 1;
        int right = N;
        int result = 0;

        while(left <= right){

            int mid = (left + right)/2;
            if(determination(mid)){
                right = mid -1;
                result = mid;
            }
            else{
                left = mid +1;
            }
        }
        System.out.println(result);
    }

}