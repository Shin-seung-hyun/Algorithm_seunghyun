import java.util.Scanner;
import java.util.*;

//이분 탐색
public class Main{

    public static int N,M;
    public static String arr[];
    public static String answer[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //듣도 못한
        M = sc.nextInt(); //보도 못한

        arr = new String[N+1]; // 듣지도 못한 사람 배열
        answer = new String[N];

        //줄바꿈 제거
        sc.nextLine();
        for(int i =1; i<=N; i++){
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr , 1, N+1);

        int answerCnt = 0;
        for(int i = 0; i<M; i++){

            String x = sc.nextLine();
            //이분 탐색 (arr의 배열에 M이 존재하는지)
            if(search(1,N,x)) answer[answerCnt++]  = x;
        }

        //null 값이 있으면 정렬이 되지 않음으로 범위 지정
        Arrays.sort(answer, 0, answerCnt);

        //출력
        sb.append(answerCnt).append("\n");

        for(int i = 0; i<answerCnt; i++){
            sb.append(answer[i]).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static boolean search(int left, int right, String x){

        while(left <= right){
            int mid = (left + right)/2 ;

            if(arr[mid].equals(x)){
                return true;
            }
            else if(arr[mid].compareTo(x) >0){
                //x보다 arr[mid]가 더 크다면
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }

        return false;
    }

}