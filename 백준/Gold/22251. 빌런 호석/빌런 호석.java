import java.io.*;
import java.util.*;

// 구현
public class Main {

    static int N,K,P,X;
    static int[][] num_flag ={  // 디지털 숫자의 한 획을 배열로 만듦
            {1, 1, 1, 0, 1, 1, 1},  //0
            {0, 0, 1, 0, 0, 1, 0},  //1
            {1, 0, 1, 1, 1, 0, 1},  //2
            {1, 0, 1, 1, 0, 1, 1},  //3
            {0, 1, 1, 1, 0, 1, 0},  //4
            {1, 1, 0, 1, 0, 1, 1},  //5
            {1, 1, 0, 1, 1, 1, 1},  //6
            {1, 0, 1, 0, 0, 1, 0},  //7
            {1, 1, 1, 1, 1, 1, 1},  //8
            {1, 1, 1, 1, 0, 1, 1}   //9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N개의 층
        K = Integer.parseInt(st.nextToken());   // 디스플레이에 보이는 K 자리의 수
        P = Integer.parseInt(st.nextToken());   // 반전시킨 수
        X = Integer.parseInt(st.nextToken());   // 현재 층수

        int answer =0;
        for(int i =1; i<=N; i++) { // 1층 ~ N층 까지 현재 층수가 될 수 있는 숫자 확인

            if (i == X) continue;
            if (change(X, i) <= P) answer++;
        }

        System.out.println(answer);
    }

    static int change(int current, int goal){
        int sum = 0;

        for(int i = 1; i<=K; i++){
            sum += diff_One(current % 10, goal % 10);   // current가 goal이 되기 위한 변경 횟수 저장

            current = current/ 10;
            goal = goal /10;
        }

        return sum;
    }

    static int diff_One(int num, int goal){
        int cnt =0;

        for(int i=0; i<= 6; i++){
            if( num_flag[num][i] != num_flag[goal][i]) cnt++;
        }

        return cnt;
    }
}
