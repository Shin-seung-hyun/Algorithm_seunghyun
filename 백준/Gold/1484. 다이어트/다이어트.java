import java.util.*;
import java.io.*;

// 투 포인터
//현재 몸무게로 가능한 것을 모두 출력
public class Main {
    static int G;
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //현재 몸무게^2 - 기억하고 있던 몸무게^2 = 15
        // = (a+b)(a-b) = 15
        // = (4+1)(4-1) = 15
        // = (8+7)(8-7) = 15
        G = Integer.parseInt(br.readLine());

        arrayList = new ArrayList<>();

        for(int i =1; i<=G; i++){

            //G의 약수만 뽑기
                //(1,15)
                //(3,5)
            if( G % i != 0) continue;

            //약수 중에서도 큰 것들만
            for(int j =1; j <= i/2; j++){

                // (a-b)를 충족 시키키 위함
                int a = j;
                int b = i - j;

                int big = Math.max( a,b );
                int small = Math.min(a,b);

                if((big + small) * (big - small) == G){
                    arrayList.add(big);
                }
            }
        }

        if(arrayList.size() == 0) System.out.println(-1);
        else {
            Collections.sort(arrayList);
            for (int val : arrayList) System.out.println(val);
        }
    }
}