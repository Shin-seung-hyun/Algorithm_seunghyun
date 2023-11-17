import java.util.*;
import java.io.*;


//기하학
class Main{

    static int N;
    static int M;
    static int[][] arr;

    static int sum =0;
    static int up =0, down=0, north=0, south=0, east=0, west=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //입력
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] != 0) up++;
            }
        }

        //위쪽 겉면 넓이 == 아래쪽 겉면 넒이
        down = up;

        // 동쪽(왼쪽)
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){

                if(j == 0) west += arr[i][0];
                else{
                    int space =  arr[i][j] - arr[i][j-1];
                    if( space > 0) west += space;
                }
            }
        }

        // 서쪽(오른쪽)
        for(int i=0; i<N; i++){
            for(int j=M-1; j>=0; j--){

                if( j == M-1) east += arr[i][j];
                else{

                    int space = arr[i][j] - arr[i][j+1];
                    if( space >0) east += space;
                }
            }
        }

        // 남쪽(아래쪽)
        for(int i =0; i<M; i++){
            for(int j= N-1; j>=0; j--){

                if(j ==N-1) south += arr[j][i];
                else{

                    int space = arr[j][i] - arr[j+1][i];
                    if( space > 0) south += space;
                }
            }
        }

        // 북쪽(위쪽)
        for(int i= 0; i<M; i++){
            for(int j=0; j< N; j++){

                if( j ==0) north += arr[j][i];
                else{

                    int space = arr[j][i] - arr[j-1][i];
                    if( space > 0) north += space;
                }
            }
        }

        sum = up + down + west + east + south + north;
        System.out.println(sum);
    }
}