import java.util.*;
import java.io.*;

class Main{

    static int N,M,R;
    static int[][]arr;
    static int[][] tmpArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 반복 횟수
        st  = new StringTokenizer(br.readLine());
        for(int i= 0; i<R; i++) {

            int op = Integer.parseInt(st.nextToken());
            switch (op) {
                case 1:
                    one();
                    break; //1번 연산 -> 상하 반전
                case 2:
                    two();
                    break; //2번 연산 -> 좌우 반전
                case 3:
                    three();
                    break; //3번 연산 -> 오른쪽으로 90도 회전
                case 4:
                    four();
                    break; //4번 연산 -> 왼쪽으로 90도 회전
                case 5:
                    five();
                    break; //5번 연산
                case 6:
                    six();
                    break; //6번 연산
            }
        }

        //출력
        for(int i=0; i<N; i++){
            for(int val : arr[i]) sb.append(val + " ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void one(){      //1번 연산 -> 상하 반전

        tmpArr = new int[N][M];
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                tmpArr[N-1-i][j] = arr[i][j];    // 열 고정

        arr = tmpArr;
    }

    static void two(){      //2번 연산 -> 좌우 반전

        tmpArr = new int [N][M];
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                tmpArr[i][M-1-j] = arr[i][j];

        arr = tmpArr;

        /* 방법2 */
//        for(int i=0; i<M; i++)
//            for(int j=0; j<N; j++)
//                tmpArr[j][M-1-i] = arr[j][i];
//
//        arr = tmpArr;
    }

    static void three(){    //3번 연산 -> 오른쪽으로 90도 회전
        tmpArr = new int[M][N];

        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                tmpArr[j][N-1-i] = arr[i][j];

        //N과 M 바꾸기
        int tmp = N;
        N = M;
        M = tmp;

        arr = tmpArr;
    }

    static void four(){     //4번 연산 -> 왼쪽으로 90도 회전

        tmpArr = new int[M][N];

        for(int i =0; i<N; i++)
            for(int j=0; j<M; j++)
                tmpArr[M-1-j][i] = arr[i][j];

        //N과 M 바꾸기
        int tmp = N;
        N = M;
        M = tmp;

        arr = tmpArr;
    }

    static void five(){     //5번 연산 : 1->2, 2->3, 3->4, 4->1

        tmpArr = new int [N][M];
        
    // 1->2 이동
        for(int i=0; i<N/2; i++)
            for(int j=0; j<M/2; j++)
                tmpArr[i][M/2+j] = arr[i][j];
    // 2->3 이동
        // 좌표 : 0,4 -> 3,4
        for(int i=0; i<N/2; i++)
            for(int j=M/2; j<M; j++)
                tmpArr[N/2+i][j] = arr[i][j];

    //3->4 이동
        // 좌표 : 3,4 -> 3,0
        for(int i=N/2; i<N; i++)
            for(int j=M/2; j<M; j++)
                tmpArr[i][j-M/2] = arr[i][j];
        
    //4 ->1 이동
        // 3,0 -> 0,0
        for(int i=N/2; i<N; i++)
            for(int j=0; j<M/2; j++)
                tmpArr[i-N/2][j] = arr[i][j];

        arr = tmpArr;
    }

    static void six(){      //6번 연산 : 1->4, 4->3, 3->2, 2->1

        tmpArr = new int[N][M];

    // 1->4 이동
        // 0,0 -> 3,0
        for(int i=0; i<N/2; i++)
            for(int j=0; j<M/2; j++)
                tmpArr[N/2+i][j] = arr[i][j];
    // 4 ->3 이동
        // 3,0 -> 3,4
        for(int i=N/2; i<N; i++)
            for(int j=0; j<M/2; j++)
                tmpArr[i][j+M/2] = arr[i][j];

    // 3 -> 2 이동
        // 3,4 -> 0,4
        for(int i=N/2; i<N; i++)
            for(int j=M/2; j<M; j++)
                tmpArr[i-N/2][j] = arr[i][j];
    
    // 2 ->1 이동
        // 0,4 -> 0,0
        for(int i=0; i<N/2; i++)
            for(int j=M/2; j<M; j++)
                tmpArr[i][j-M/2] = arr[i][j];

        arr = tmpArr;
    }

}