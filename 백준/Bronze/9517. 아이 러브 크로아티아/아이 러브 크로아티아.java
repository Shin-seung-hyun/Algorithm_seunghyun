import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int start = Integer.parseInt(br.readLine());
        int question = Integer.parseInt(br.readLine());
        int endTime = 210; // 3분 30초

        for(int i = 1; i< question; i++){
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String answer = st.nextToken();

            if( endTime - time <0) break;

            endTime -= time;

            if(answer.equals("T")){
                start++;
                if (start > 8) start = 1;
            }

        }

        System.out.println(start);
    }

}