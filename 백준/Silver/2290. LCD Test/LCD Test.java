import java.util.*;
import java.io.*;


//기하학
class Main{

    static int N, S;
    static int[][] numbers = {
            {0,1,1,1,0,1,1,1},  //0
            {0,0,0,1,0,0,1,0},  //1
            {0,1,0,1,1,1,0,1},  //2
            {0,1,0,1,1,0,1,1},  //3
            {0,0,1,1,1,0,1,0},  //4
            {0,1,1,0,1,0,1,1},  //5
            {0,1,1,0,1,1,1,1},  //6
            {0,1,0,1,0,0,1,0},  //7
            {0,1,1,1,1,1,1,1},  //8
            {0,1,1,1,1,0,1,1},  //9
    };

    static String[][] output;
    static int space;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        char[] input= st.nextToken().toCharArray();
        N = input.length;

        output = new String [2 * S + 4][N * (S + 4)];

        // 빈 공간으로 채우기
        for(int i=0; i<2*S+3; i++)
            for (int j = 0; j < N * (S + 4); j++)
                output[i][j]= " ";

        for(int i=0; i<N; i++){

            int num = input[i] - '0';

            if (numbers[num][1] == 1) fill(0, 0, space + 1, space + S, "-");
            if (numbers[num][4] == 1) fill(S + 1, S + 1, space + 1, space + S, "-");
            if (numbers[num][7] == 1) fill(2 * (S + 1), 2 * (S + 1), space + 1, space + S, "-");

            if (numbers[num][2] == 1) fill(1, S, space, space, "|");
            if (numbers[num][5] == 1) fill(1 + (S + 1), S + (S + 1), space, space, "|");

            if (numbers[num][3] == 1) fill(1, S, space + S + 1, space + S + 1, "|");
            if (numbers[num][6] == 1) fill(1 + (S + 1), S + (S + 1), space + S + 1, space + S + 1, "|");

            space += S + 3;
        }

        //출력
        result();
    }

    static void fill(int sx, int ex, int sy, int ey, String s){
        for(int i= sx; i<=ex; i++){
            for(int j= sy; j<= ey; j++){
                output[i][j] = s;
            }
        }
    }

    static void result(){
        for(int i=0; i< 2 *S + 3; i++){
            for (int j = 0; j < space; j++) {
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
    }
}