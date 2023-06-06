import java.util.*;
import java.io.*;

// 퀸을 놓는 방법의 경우의 수
///N개 중에서 N개를 중복 o, 순서o 나열하기
public class Main {

    static int N;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int [N+1];  //index 열, value 행

        N_Queen(1);

        System.out.println(answer);
    }

    static boolean Possible(int d ){

        // d 행 이전의 행을 돌면서
        for(int i =1; i < d; i++){

            // 이전 행의 열과 현재 퀸을 놓은 열이 같다면(상하에서 만날 경우)
            if(arr[i] == arr[d]) return false;

            // 이전 행과 대각선에서 만날 경우
                // 이전 행의 퀸을 놓은 자리의 행+열 == 현재 행의 퀸을 놓은 자리의 행 + 열
            else if ((arr[i] + i) == (arr[d] + d )||
                    (arr[i] - i) == (arr[d] - d))  return false;

        }

        return true;
    }

    static void N_Queen(int depth){

        // 종료 조건
        if( depth == N+1){
            answer +=1;
            return;
        }

        // 반복조건
        // N 행까지 돌면서
        for(int i =1; i<=N; i++){

            //depth의 행 i 열에 Queen 을 놓는다.
            arr[depth] = i;

            // 퀸을 놓을 수 있는지 확인
            if(Possible(depth)){
                N_Queen(depth+1);
            }
        }

    }

}