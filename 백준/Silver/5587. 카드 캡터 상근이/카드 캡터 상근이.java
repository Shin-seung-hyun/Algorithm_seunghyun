import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static  ArrayList<Integer> delList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        //오름차순으로 저장
        PriorityQueue<Integer> first = new PriorityQueue<>();
        PriorityQueue<Integer> second = new PriorityQueue<>();

        boolean []check = new boolean[2*N +1];

    // 입력
        //상근 입력
        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            check[num] = true;
            first.add(num);
        }

        //근상 입력
        for(int i=1; i<2*N+1; i++){
            if(!check[i]) second.add(i);
        }

    //카드 내기
        while( first.size() >=1 && second.size() >=1){

            //상근이 카드 내기
            first = card(first);

            if( first.size() ==0) break;

            //근상이 카드 내기
            second = card(second);
        }


    //출력 -> 상대방이 가진 갯수가 내 점수
        System.out.println(second.size());
        System.out.println(first.size());
    }

    static PriorityQueue<Integer> card(PriorityQueue<Integer> pq){
        ArrayList<Integer> leftList = new ArrayList<>();

        int pqSize = pq.size();
        while(pq.size() > 0) {

            if (delList.size() == 0) {
                delList.add(pq.poll());
                break;

            }
            else {
                int tmp = pq.poll();
                if (delList.get(delList.size() - 1) < tmp) {
                    delList.add(tmp);
                    break;
                }
                else leftList.add(tmp);
            }

        }

        if( leftList.size() == pqSize) delList = new ArrayList<>();
        for(int val : leftList) pq.add(val);

        return pq;
    }

}