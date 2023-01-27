import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
/*
//이차원 배열로 풀기
하나의 배열에 순서대로 정렬
    0 1
    3 1
    5 1
    1 2
    4 2
 */

public class Main {

    public static void main(String args[])throws IOException {
        //0. Scanner 입력
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int [][]arr = new int[N][2];
//        int sum = 0;
//
//        //이차원 배열 입력
//        for(int i =0; i< N;i++){
//            for(int j = 0; j< 2; j++){
//                arr[i][j] = sc.nextInt();
//            }
//        }

        //0. BufferedReader 와 StringTokenizer로 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = new int[] {
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
            };
        }
        br.close();

        //1. 색깔 별로 정렬
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[]b){
                if(a[1] == b[1]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });

        //이차원 배열 출력
        //System.out.println(Arrays.deepToString(arr));

        //2. 거리 계산하기
        for(int i = 0 ; i< N; i++){

            // 처음 좌표라면
            if(i==0){
                sum +=  (arr[1][0] - arr[0][0]);
            }

            // 마지막 좌표라면
            else if(i == N-1){
                sum += (arr[N-1][0] - arr[N-2][0]);
            }
            else{

                //양쪽 모두 같을 때
                if((arr[i][1] == arr[i-1][1]) && (arr[i][1] == arr[i+1][1])){
                    //오른쪽 화살표
                    int right = arr[i][0] -arr[i-1][0];
                    //왼쪽 화살표
                    int left = arr[i+1][0] - arr[i][0];

                    sum += Math.min(right, left);
                }
                //오른쪽만 같을 때
                else if(arr[i][1] == arr[i-1][1]){
                    //오른쪽 화살표
                    sum += (arr[i][0] -arr[i-1][0]);
                }
                //왼쪽만 같을 때
                else{
                    //왼쪽 화살표
                    sum += (arr[i+1][0] - arr[i][0]);
                }

            }
        }

        System.out.println(sum);

    }
}
