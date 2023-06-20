import java.util.*;
import java.io.*;

// 한 국가의 등수는 (자신보다 더 잘한 나라 수) + 1
class Main{
    static int N;   // 국가의 수
    static int K;   // 등수를 알고 싶은 국가
    static class country implements Comparable<country> {
        int num;
        int gold, silver, bronze;

        country(int num, int gold, int silver, int bronze){
            this.num = num;
            this.gold =gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        // Comparable, compareTo() vs Comparator, compare()
        @Override
        public int compareTo( country c1){
            if( this.gold == c1.gold){
                if(this.silver == c1.silver) return c1.bronze - this.bronze;
                else return c1.silver - this.silver;
            }
            else return c1.gold - this.gold;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<country> arrList = new ArrayList<>();
        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            arrList.add(new country(num, gold, silver, bronze));
        }

    //정렬
        Collections.sort(arrList);

    // 등수 매기기
        if(arrList.get(0).num == K){
            System.out.println(1);
            return;
        }

        int rank = 1;
        int cnt = 1;
        for(int i =1; i<=N; i++){

            country pre = arrList.get(i-1);
            country cur = arrList.get(i);

            if( (pre.gold == cur.gold) && (pre.silver == cur.silver) && (pre.bronze == cur.bronze)){
                cnt++;
            }
            else {
                rank = rank + cnt;
                cnt = 1;
            }

            // 등수를 알고 싶은 국가라면
            if( cur.num == K){
                System.out.println(rank);
                return;
            }
        }

    }
}