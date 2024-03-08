import java.util.*;
import java.io.*;

//재귀
class Main{

    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(N, 0, 0);

        System.out.println(cnt[0]);     // -1
        System.out.println(cnt[1]);     // 0
        System.out.println(cnt[2]);     // 1
    }

    static void func(int size, int x, int y ){

        //종료 조건
        if( check(size, x, y) ){
            cnt[ arr[x][y]+1 ]++;
            return;
        }

        //반복조건
        for (int i = 0; i < 3; i++) {
            for(int j =0; j<3; j++)
                func(size / 3, x + i * (size/3), y + j * (size/3));
        }

    }

    static boolean check(int size, int x, int y){

        for(int i =x; i< x + size; i++){
            for(int j= y; j< y + size; j++)
                if( arr[x][y] != arr[i][j] ) return false;
        }

        return true;
    }
    
}