import java.util.*;
import java.io.*;

//재귀
class Main{

    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    static int[] color = new int[2];   //0: 흰, 1:파


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

        System.out.println(color[0]);
        System.out.println(color[1]);
    }

    //과정2. 똑같은 크기의 네 개의 N/2 × N/2색종이로 나눈다.
    static void func(int size, int x, int y ){

        //종료 조건 : 모두 같은 색으로 칠해져 있을 때
        if(check(size, x,y)){

            color[ arr[x][y]] ++;
            return ;
        }

        //반복 조건 : 같은 크기 4개로 나누기
        int s = size/2;
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++)
                func( s, x + i * s, y + j * s);
        }
    }

    //과정1, 같은 색으로 칠해져 있는지 확인한다.
    static boolean check(int s, int x, int y) {

        for (int i = x; i < x + s; i++) {
            for (int j = y; j < y + s; j++)
                if (arr[i][j] != arr[x][y]) return false;
        }

        return true;
    }

}