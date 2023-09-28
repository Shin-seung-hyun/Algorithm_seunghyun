import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1; t<=testCase; t++){

            String winner = "";
            ArrayList<Integer> arrList = new ArrayList<>();

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arrList.add(Integer.parseInt(st.nextToken()));
            }

            while(arrList.size() != 2){
                int size = arrList.size();

                for(int i=0; i<= size/2; i++){
                    arrList.add( arrList.get(i) + arrList.get(size -1 -i));
                }

                while( size != 0){
                    arrList.remove(0);
                    size--;
                }

            }
            if( arrList.get(0) > arrList.get(1) ) winner = "Alice";
            else winner = "Bob";

            System.out.println("Case #" + t +": " + winner);
        }

    }

}