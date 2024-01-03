import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 2007/01/01 Mon
        int month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String days[] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        int day = 0;

        //월
        for(int i=1; i<x; i++) day += month[i];

        //일
        day += y;

        System.out.println( days[ day % 7]);
    }
}