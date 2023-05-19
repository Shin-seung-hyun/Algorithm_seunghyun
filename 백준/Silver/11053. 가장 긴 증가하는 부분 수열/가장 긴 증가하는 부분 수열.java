import java.util.*;
import java.io.*;


// 가장 긴 증가하는 부분 수열
class Main{
    static int N;   // 수열의 길이
    static int[] arr; // 수열을 저장
    static int[] Dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Dy = new int[N+1];
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DP();

        int max = 0;
        for(int i : Dy){
            max = Math.max( max, i);
        }
        System.out.println(max);
    }

    static void DP(){
        //초기값
        Dy[1] = 1;

        for(int i =2; i<=N; i++){
            Dy[i] = 1;

            for(int j =1; j<= i; j++){
                if(arr[j] < arr[i] && Dy[i] <= Dy[j]){
                    Dy[i] = Dy[j] + 1;
                }
            }
        }

    }


}