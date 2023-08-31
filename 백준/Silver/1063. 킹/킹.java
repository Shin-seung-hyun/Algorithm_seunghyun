import java.io.*;
import java.util.*;

//구현
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        int kx = king.charAt(0) - 'A' +1;
        int ky = king.charAt(1) - '0';

        String stone = st.nextToken();
        int sx = stone.charAt(0)-'A'+1;
        int sy = stone.charAt(1) - '0';

        int num = Integer.parseInt(st.nextToken());

        for(int i=1; i<=num; i++){

            String str = br.readLine();

            int arr[] = move(str, kx, ky);

            int x = arr[0];
            int y = arr[1];

            if( x < 1  || y < 1 || x > 8 || y >8 ) continue;
            if( x == sx && y == sy){

                int arr2[] = move(str,sx,sy);
                int tx = arr2[0];
                int ty = arr2[1];

                if(tx < 1 || ty < 1 || tx > 8 || ty >8 ) continue;
                else{
                    sx = tx;
                    sy = ty;
                }
            }

            kx = x;
            ky = y;
        }


        System.out.println( String.valueOf( (char)(kx + 'A' -1)) +  ky );
        System.out.println( String.valueOf( (char)(sx + 'A' -1)) +  sy );
    }

    static int[] move(String op, int x, int y){

        switch(op){

            case "R" : x +=1; break;
            case "L" : x -=1; break;
            case "B" : y -=1; break;
            case "T" : y +=1; break;
            case "RT": x +=1; y +=1; break;
            case "LT": x -=1; y +=1; break;
            case "RB": x +=1; y -=1; break;
            case "LB": x -=1; y -=1; break;
        }

        return new int[]{x, y};
    }

}