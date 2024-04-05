import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();
    static int[][] bingo;
    static int[] check_bingo = new int[13];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        bingo= new int[6][6];
        for(int i=1; i<=5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=5; j++)
                bingo[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt =0;

        for(int i =1; i<=5; i++) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                cnt++;
                if (find(Integer.parseInt(st.nextToken()))) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

    static boolean find(int value){

        loop:
        for(int i=1; i<=5; i++){
            for(int j=1; j<=5; j++) {
                if (bingo[i][j] == value) {

                    if( i == j) check_bingo[11]++;
                    if( j + i == 6) check_bingo[12]++;

                    check_bingo[i]++;
                    check_bingo[j+5]++;

                    int bingoCnt = 0;
                    for(int k = 1; k< check_bingo.length; k++){
                        if( check_bingo[k] ==5) bingoCnt++;
                    }

                    if( bingoCnt >=3) return true;

                    break loop;
                }
            }
        }

        return false;
    }
}
