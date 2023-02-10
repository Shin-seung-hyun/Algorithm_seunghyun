import java.util.*;
import java.io.*;

//두 포인터
    //두 용액 문제와 비슷
public class Main{

    public static int N;
    public static int arr[];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1 ; i<=N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //최댓값, 최솟값을 위한 정렬
            //1 2 3 4 5 6 7 8 9 10
        Arrays.sort(arr, 1, N +1);

        twoPointer();

        br.close();
    }

    public static boolean Possible(int targetIndex){
        //arr[targetIndex]을 arr[left] + arr[right] 로 만들 수 있는가?
        int left = 1;
        int right = N;

        //left == right 인 경우 용액이 하나임으로, left < right 까지만 반복
        while(left < right){

            //자기 자신은 더하지 않음
            if(left == targetIndex) left ++;
            else if(right == targetIndex) right--;
            
            //target을 탐색
            else{
                
                if(arr[left] + arr[right] > arr[targetIndex]) right--;
                else if (arr[left] + arr[right] < arr[targetIndex] ) left++;
                
                //arr[left] + arr[right] ==arr[targetIndex 인 경우
                else return true;
            }
        }
        return false;
    }
    public static void twoPointer() {
        int answer = 0;


        //target을 지정하고 해당 값이 "좋은지" 확인
        for (int i = 1; i <= N; i++) {
            if (Possible(i)) answer++;
        }

        System.out.println(answer);
    }

}