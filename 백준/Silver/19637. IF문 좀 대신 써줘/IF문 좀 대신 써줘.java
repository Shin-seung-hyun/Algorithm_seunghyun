import java.io.*;
import java.util.*;

// 투 포인터
public class Main {

    static class Game{
        String str;
        int num;

        public Game(String str, int num){
            this.str = str;
            this.num = num;
        }
    }
    static ArrayList<Game> arrList = new ArrayList<>();
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            arrList.add(new Game(str,num));
        }

        for(int i= 1; i<=M; i++){
            int num = Integer.parseInt(br.readLine());

            twoPointer(num);
        }

        System.out.println(sb.toString());
    }
    static void twoPointer(int num){
        int left = 0;
        int right = N-1;
        int result = 0;

        while(left <= right){
            int mid = (left + right)/2;

            if( arrList.get(mid).num >= num){
                right = mid -1;
                result = mid;
            }
            else {
                left = mid +1;
            }
        }

        sb.append(arrList.get(result).str + "\n");
    }
}