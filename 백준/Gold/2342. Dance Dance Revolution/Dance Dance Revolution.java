import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer> input;

    //dp[ i ] [ left ] [ right ] : 왼발(left) 위치, 오른발(right) 위치, i번째 스텝일때 최댓값
    static int[][][] Dy; // [ i ] <= 10만

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new ArrayList<>();
        while(true) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) break;
            input.add(num);
        }

        N = input.size();
        Dy = new int[N+1][5][5];

        int answer = DDR(0, 0, 0);

        System.out.println(answer);
    }

    static int DDR(int step, int left, int right) {
        //마지막 스텝 도달하면 끝
        if (step == N)
            return 0;

        //dp에 값이 차있으면 return
        if (Dy[step][left][right] != 0) {
            return Dy[step][left][right];
        }

        //가능한 경우의 수 중 가장 적은 경우로 갱신하고 return
        /// 왼발 욺직이는 경우 vs 오른발 움직이는 경우
        int leftScore = score(left, input.get(step)) + DDR(step + 1, input.get(step), right);
        int rightScore = score(right, input.get(step)) + DDR(step + 1, left, input.get(step));

        return Dy[step][left][right] = Math.min(leftScore, rightScore);
    }

    static int score(int from, int to){
        // 0. 지금 위치를 누르면 1
        if(from==to) return 1;

        // 1. 가운데 출발 2
        if(from==0) return 2;

        // 3. 반대편 밟으면 4
        if(Math.abs(from-to) ==2) return 4;

        // 4. 인접 스텝 밟으면 3
        return 3;
    }
}