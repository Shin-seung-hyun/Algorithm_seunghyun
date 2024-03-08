import java.util.*;
import java.io.*;

class Main{
    static int N;
    static int[][] arr;

    static int cnt0=0, cnt1= 0, cnt2= 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        func(N,0,0);

        System.out.println(cnt2);
        System.out.println(cnt0);
        System.out.println(cnt1);
    }

    //과정 2. 같은 크기의 종이 9개로 자르기
    static void func(int size, int x ,int y){

        if(checkColor(size, x, y)){
            if( arr[x][y] == 0) cnt0++;
            else if( arr[x][y] == 1) cnt1++;
            else cnt2++;

            return;
        }

        // 9개의 영역으로 종이 자르기

        int s = size/3;

        func(s, x, y);
        func(s, x, y + s);
        func(s, x, y + 2*s);

        func(s, x + s, y);
        func(s, x + s, y + s);
        func(s, x + s, y + 2*s);

        func(s, x + s*2, y );
        func(s, x + s*2, y + s );
        func(s, x + s*2, y +2*s);
    }

    //과정 1. 모든 같은 종이의 종류인지 확인
    static boolean checkColor(int size, int x, int y){

        for(int i = x; i< x + size; i++)
            for(int j =y; j< y + size; j++)
                if( arr[x][y] != arr[i][j]) return false;

        return true;
    }
}