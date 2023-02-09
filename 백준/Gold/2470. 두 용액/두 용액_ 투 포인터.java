import java.util.*;
import java.io.*;

//두 포인터
public class Main{

    public static int N;
    public static int arr[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        //Scanner 사용 시 , 시간 초과
        //Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //-99 -2 -1 4 98
        Arrays.sort(arr, 1, N+1);

        twoPointer();

        br.close();
    }

    public static void twoPointer(){
        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        int left =1;
        int right =N;

        //left == right 인 경우 용액이 하나임으로, left < right 까지만 반복
        while(left < right){

            if(best_sum > Math.abs(arr[left] + arr[right])){
                best_sum = Math.abs(arr[left] + arr[right]);
                v1 = arr[left];
                v2 = arr[right];
            }

            if(arr[left] + arr[right] > 0){
                //최대 값에게 최적의 상태, 최대값 삭제
                right --;
            }
            else{
                //최소 값에게 최적의 상태, 최소값 삭제
                left++;
            }
        }

        sb.append(v1).append(" ").append(v2);
        System.out.println(sb.toString());
    }

}