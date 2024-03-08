import java.util.*;
import java.io.*;

//재귀
class Main{

    static int N ;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        // 원판의 수
        N = Integer.parseInt(br.readLine());

        sb.append( (int)(Math.pow(2,N) -1) ).append("\n");

        func(1,3,N);

        System.out.println(sb.toString());
    }

    // K개의 원판을 a번 기둥에서 b번 기둥으로 옮기는 방법을 출력하자!
    static void func(int a, int b , int k){

        //종료조건
        if( k ==1){
            sb.append(a + " " + b).append("\n");
            return;
        }

        //반복 조건
        //1. n-1개의 원판을 a에서 6-a-b로 옮긴다
        func(a, 6-a-b, k-1);

        //2. n번 원판을 a에서 b로 옮긴다.
        sb.append(a + " " + b).append("\n");

        //3. n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다.
        func(6-a-b, b, k-1);
    }


}