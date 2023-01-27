import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
/*
//2차원 ArraysList<Integer>로 문제 풀기
색깔별로 배열을 분리, 순서대로 정렬
 arr[1][]
    0 1
    3 1
    5 1

 arr[2][]
    1 2
    4 2
 */
class Main{

    public static int N;
    public static ArrayList<Integer> arr[];
    public static int sum=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new ArrayList[N+1];

        //ArrayList 2차원 배열 선언
        for(int i = 1 ; i<= N; i ++){
            arr[i] = new ArrayList<Integer>();
        }

        //1. 색깔 별로 배열 나누기
        for(int i =1; i<=N; i ++){
            int x = sc.nextInt();      //좌표
            int color = sc.nextInt();  //색깔

            arr[color].add(x);
        }

        //2. 정렬
        for(int i = 1; i<=N; i++){
            Collections.sort(arr[i]);
        }

        //3. 거리 계산
        for(int i =1; i<=N; i ++){
            for(int k = 0; k< arr[i].size(); k++){
                int left_distance = Left(i, k);
                int right_distance = Right(i, k);

                sum = sum + Math.min(left_distance, right_distance);
            }
        }
        System.out.println(sum);
    }

    public static int Left(int color, int index){
        //왼쪽에 더 이상 좌표가 없을 때
        if(index == 0 ) return Integer.MAX_VALUE;
        else return arr[color].get(index)-arr[color].get(index - 1);
    }

    public static int Right(int color, int index){
        //오른쪽에 더 이상 좌표가 없을 때
        if(index == arr[color].size()-1) return Integer.MAX_VALUE;
        else return arr[color].get(index + 1) - arr[color].get(index);
    }
}
