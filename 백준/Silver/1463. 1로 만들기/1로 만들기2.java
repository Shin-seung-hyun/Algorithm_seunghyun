import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int Dy[] = new int[N+1];

        Dy[1] = 0;

        for (int i = 2; i <= N; i++){

            // 1을 빼는 경우
            Dy[i] = Dy[i-1] + 1;

            // 1을 뺀 경우, 2로 나눈 경우 중 최솟값을 Dy[i] 저장
            if (i % 2 == 0) Dy[i] = Math.min(Dy[i], Dy[i/2] + 1);

            // 1을 뺀 경우와 2로 나눈 경우의 최솟값인, Dy[i]와 3로 나눈 경우 중 최솟값을 Dy[i] 저장
            if (i % 3 == 0) Dy[i] = Math.min(Dy[i], Dy[i/3] + 1);
        }

        System.out.println(Dy[N]);
    }
}