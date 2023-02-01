import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main{

    public static int N ;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        //Scanner 사용시 시간 초과 발생
        //Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i =1; i<=N;i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //formIndex 포함, toIndex 미포함
        Arrays.sort(arr, 1 , N+1);

        //-99 -2 -1 4 98

        int bestSum = Integer.MAX_VALUE;
        int v1 =0, v2 =0;
        for(int left =1; left<=N-1; left++){

            //arr[left] 용액을 쓰느데, arr[left+1] ~ arr[N] 중에서
            // -arr[left] 이상의 값 중 가장 왼쪽에 위치하는 것을 찾기
            int result = search(arr, left +1, N, -arr[left] );

            //arr[result-1], arr[result] 중에서 x와 가장 가까운 원소가 있다.
            //단, result-1 과 result 는 left+1 이상 N이하인 원소여야 한다.

            //1. arr[left], arr[result-1]가 쌍일 때
            if(left+1 <= result-1 && Math.abs(arr[left] + arr[result-1]) < bestSum){

                bestSum = Math.abs(arr[left] + arr[result -1]);
                v1 = arr[left];
                v2 = arr[result -1];

            }

            //2. arr[left] + arr[result]가 쌍일 때
            if(result <=N && Math.abs(arr[left] + arr[result]) < bestSum){

                bestSum = Math.abs(arr[left] + arr[result]);
                v1 = arr[left];
                v2 = arr[result];

            }
        }

        sb.append(v1).append(" ").append(v2);
        System.out.println(sb.toString());
    }

    public static int search(int [] arr, int left, int right, int x){

        int result = right +1;

        while(left <= right){

            int mid = (left +right)/2;

            if(arr[mid] >= x){
                result = mid;
                right = mid -1;
            }
            else{
                left = mid +1;

            }
        }
        return result;
    }

}