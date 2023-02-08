import java.util.*;

//이분 탐색
    //매개 변수 탐색 알고리즘
    // 불루레이 M개일 때, 블루레이의 크기 중 최소는?
    // 블루레이의 크기가 [] 일 때, 불루레이 M개가 가능한가?
public class Main{

    public static int N;        //강의의 수
    public static int M;        //블루레이 수
    public static int arr[];    //강의가 몇 분인지 담는 N개의 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int [N+1];
        for(int i =1; i<=N ;i++){
            arr[i] = sc.nextInt();
        }

        search();
    }

    public static boolean determination(int len){

        int cnt = 1;
        int sum = 0;

        //강의는 총 9개, 블루레이는 총 3개
        //[1 2 3 4 5/ 6 7 / 8 9]
        
        for(int i = 1; i<=N; i++){
            if(sum+ arr[i] > len){
                cnt ++;
                sum = arr[i];
            }
            else{
                sum += arr[i];
            }
        }

        return cnt  <= M;
    }

    public static void search(){

        //블루레이의 크기 <= 100_000(N개) * 10_000(분)
        int left = arr[1];
        int right = 1_000_000_000;
        int result = 0;

        // 적어도 제일 긴 녹화본의 길이 만큼 블루레이의 크기가 필요함
        for(int i =1; i<=N; i++){
            left = Math.max(left,arr[i]);
        }

        while(left <= right){
            int mid = (left +right)/2;

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