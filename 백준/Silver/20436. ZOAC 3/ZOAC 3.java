import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static HashMap<String, int[]> mo = new HashMap<>();
    static HashMap<String, int[]> ja = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        init();

        String startL = st.nextToken();
        String startR = st.nextToken();

        String str = br.readLine(); // zoac

        int time = 0;
        for(int i = 0; i< str.length(); i++){

            String s = String.valueOf(str.charAt(i));

            int[] next;
            int[] cur;

            // 자음이라면
            if( ja.containsKey(s) ){

                cur = ja.get(startL);
                next = ja.get(s);
                startL = s;
            }

            // 모음이라면
            else{
                cur = mo.get(startR);
                next = mo.get(s);
                startR = s;
            }

            // 자판 이동 시간
            time += Math.abs( cur[0] - next[0]) + Math.abs( cur[1] - next[1]);

            // 자판을 누르는 시간
            time++;
        }


        System.out.println(time);
    }

    static void init(){

        ja.put("q", new int[]{0, 0});
        ja.put("w", new int[]{0, 1});
        ja.put("e", new int[]{0, 2});
        ja.put("r", new int[]{0, 3});
        ja.put("t", new int[]{0, 4});
        mo.put("y", new int[]{0, 5});
        mo.put("u", new int[]{0, 6});
        mo.put("i", new int[]{0, 7});
        mo.put("o", new int[]{0, 8});
        mo.put("p", new int[]{0, 9});

        ja.put("a", new int[]{1, 0});
        ja.put("s", new int[]{1, 1});
        ja.put("d", new int[]{1, 2});
        ja.put("f", new int[]{1, 3});
        ja.put("g", new int[]{1, 4});
        mo.put("h", new int[]{1, 5});
        mo.put("j", new int[]{1, 6});
        mo.put("k", new int[]{1, 7});
        mo.put("l", new int[]{1, 8});

        ja.put("z", new int[]{2, 0});
        ja.put("x", new int[]{2, 1});
        ja.put("c", new int[]{2, 2});
        ja.put("v", new int[]{2, 3});
        mo.put("b", new int[]{2, 4});
        mo.put("n", new int[]{2, 5});
        mo.put("m", new int[]{2, 6});
    }


}