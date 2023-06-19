import java.util.*;
import java.io.*;

//문자열
class Main{

    static int H;   //행
    static int W;   //열
    static int N;   // 세로로 N칸 비우기
    static int M;   // 가로로 M칸 비우기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

    // W(행)에서 1명이 앉을 자리 뺀 값에서, M칸 띄우고 한 명이 앉았을 때 + 처음 앉은 1명 더하기
        int row = (W-1)/(M+1) +1;
        int col = (H-1)/(N+1) +1;

        System.out.println(row * col);
    }


}