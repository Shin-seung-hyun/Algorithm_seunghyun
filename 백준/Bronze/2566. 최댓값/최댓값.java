import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxR = 1;
        int maxC = 1;
        int maxNum = 0;

        for(int i=1; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++){
                int num = Integer.parseInt(st.nextToken());

                if(maxNum < num){
                    maxNum = num;
                    maxR = i;
                    maxC = j;
                }
            }
        }

        System.out.println(maxNum);
        System.out.println(maxR + " " + maxC);
    }
}