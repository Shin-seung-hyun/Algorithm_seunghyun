import java.util.*;
import java.io.*;

//두 포인터
public class Main{

    public static int N;
    public static int arr[];
    public static int cnt[];

    public static void main(String[] args) throws IOException{
        //메모리 초과 발생
        //Scanner sc = new Scanner(System.in);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        cnt = new int[100_000 + 1];
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        
        br.close();
    }

    public static void twoPointer(){
        long answer = 0;
        int right=0;

        //left 마다 right를 최대한 옮기기
        for(int left =1; left <= N; left++){

            //right 가 중복되지 않을 때까지 증가
            while(right +1 <=N && cnt[arr[right+1]] ==0){
                right++;
                cnt[arr[right]]++;
            }

            //정답 갱신
            answer = answer + right - left +1;

            //cnt[arr[left]]의 개수 감소
            cnt[arr[left]]--;

        }
        System.out.println(answer);
    }

}