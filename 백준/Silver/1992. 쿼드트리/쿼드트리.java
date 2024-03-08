import java.util.*;
import java.io.*;

//재귀
class Main{

    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j =0; j<N; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        func(N, 0, 0);

        System.out.println(sb.toString());
    }

    static void func(int size, int x, int y ){

        //종료 조건 : 모두 같은 숫자일 때
        if( check(size, x, y)) {
            sb.append(arr[x][y]);
            return;
        }
        
        //반복조건 : 4개의 부분으로 나눔
        int s = size /2;

        sb.append("(");
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                func(s, x + i*s, y + j*s);
            }
        }
        sb.append(")");
    }

    static boolean check(int s ,int x, int y){

        for(int i =x; i<x + s; i++){
            for(int j =y; j<y +s; j++)
                if( arr[x][y] != arr[i][j]) return false;
        }

        return true;
    }

}