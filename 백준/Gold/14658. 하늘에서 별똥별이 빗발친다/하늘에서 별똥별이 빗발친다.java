import java.io.*;
import java.util.*;

// 완전탐색 ( k번 3중 for 문 돌기)
    //최대한 많은 별똥별을 튕겨내도록 할 때, 지구에는 몇 개의 별똥별이 부딪히는가?
public class Main {
    static int N,M,L,K;
    static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Pos> arrList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    // 가로
        M = Integer.parseInt(st.nextToken());    // 세로
        L = Integer.parseInt(st.nextToken());    // L*L 크기의 트램펄린
        K = Integer.parseInt(st.nextToken());    // 별똥별의 수

        for(int i = 1; i<=K; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrList.add ( new Pos(x,y));
        }

        int answer = Integer.MIN_VALUE;
        for(int i=0; i<K; i++){  //좌하단
            for(int j = 0; j<K; j++){   // 우하단

                // arrList.get(i).x : 좌하단의 좌표
                // arrList.get(j).y : 우하단의 좌표
                answer = Math.max( answer , Star(arrList.get(i).x, arrList.get(j).y) );
            }
        }

        System.out.println(K - answer);
    }

    static int Star(int i, int j ){
        int result = 0;

        for(Pos p : arrList){

            if ( i <= p.x &&  p.x <= i+L && j <= p.y && p.y <= j+L) result ++;
        }
        return result;
    }


}