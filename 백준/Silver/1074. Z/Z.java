import java.util.*;
import java.io.*;

//재귀
class Main{

    static int N,R,C;
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());   //행 가로
        C = Integer.parseInt(st.nextToken());   //열 세로

        int size = (int)Math.pow(2,N); //한 변의 길이

        func(size, R, C);

        System.out.println(cnt);
    }

    static void func(int size, int r, int c){

        if( size == 1) return;

        // 1 사분면이면,
        if( r < size/2 && c <size/2)
            func ( size/2, r, c);

        //2 사분면이면,
        else if ( r < size/2 && c>= size/2){
            cnt += (size * size)/4;             // 1사분면 더함
            func(size/2, r, c - size/2);
        }

        //3 사분면이면,
        else if( r >= size/2 && c < size/2){
            cnt += (size * size)/4 * 2;         // 1, 2 사분면 더함
            func(size/2, r - size/2, c );
        }

        //4 사분면이면,
        else{
            cnt += (size * size)/4 * 3;         // 1, 2, 3 사분면 더함
            func(size/2, r - size/2, c -size/2);
        }
    }


}