import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int[][] dir = { {-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(br.readLine());

        for(int t=0; t<testCase; t++){
            String tmp = br.readLine();

            int minX = 0, minY = 0;
            int maxX = 0, maxY = 0;

            int dirIdx =0;

            int curX =0, curY=0;

            for(int i=0; i<tmp.length(); i++){
                char c = tmp.charAt(i);

                if( c =='F'){

                    curX = curX + dir[dirIdx][0];
                    curY = curY + dir[dirIdx][1];

                }
                else if ( c =='B'){

                    curX = curX - dir[dirIdx][0];
                    curY = curY - dir[dirIdx][1];

                }
                else if ( c =='L'){

                    if(dirIdx ==0) dirIdx = 3;
                    else dirIdx--;
                }
                else{   //R

                    if( dirIdx == 3) dirIdx =0;
                    else dirIdx++;
                }

                minX = Math.min(minX, curX);
                minY = Math.min(minY, curY);
                maxX = Math.max(maxX, curX);
                maxY = Math.max(maxY, curY);
            }

            // 가로 * 세로
            sb.append( (maxX - minX) * (maxY - minY) + "\n");
        }

        System.out.println(sb.toString());
    }
}