import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int row = 0;    //가로
        int col = 0;    //세로

        char[][] arr = new char[N][N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            int cnt = 0;

            for(int j =0; j<N; j++){
                if(arr[i][j] == '.') cnt++;
                else{

                    if( cnt >=2) row++;

                    cnt = 0;
                }
            }
            if(cnt >= 2) row++;
        }


        for(int i=0; i<N; i++){
            int cnt = 0;

            for(int j=0; j<N; j++){

                if( arr[j][i] == '.') cnt++;
                else{

                    if( cnt >=2) col++;

                    cnt = 0;
                }
            }

            if( cnt >=2) col++;
        }



        System.out.println(row + " " + col);
    }
}
