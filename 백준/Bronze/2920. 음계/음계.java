import java.util.*;
import java.io.*;

// 시뮬레이션
public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pre = Integer.parseInt(st.nextToken());
        int num = 0;
        while(st.hasMoreTokens()){

            num = Integer.parseInt(st.nextToken());

            if(pre - num != 1 && pre - num != -1 ){
                System.out.println("mixed");
                return;
            }

            pre = num;
        }

        if(pre == 1) System.out.println("descending");
        else System.out.println("ascending");
    }

}