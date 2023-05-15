import java.util.*;

// 1. DFS를 이용해 앞자리 부터 부등호 규칙을 만족하는 수를 찾아간다.
// 2. 부등호를 만족시키는 수를 찾을때 9부터 0까지 순서대로 DFS를 통해 찾은 첫 수가 최대값이 된다.
// 3. 부등호를 만족시키는 수를 찾을때 0부터 9까지 순서대로 DFS를 통해 찾은 첫 수가 최소값이 된다.
class Main {
    static int K;   //부등호 수
    static boolean[] arr;   //부등호 저장
    static boolean visit[];
    static int answer[];
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();

        visit = new boolean[10];
        answer = new int [K + 1];
        arr = new boolean[K];

        for (int i = 0; i < K; i++) {
            String str = sc.next();
            if(str.equals(">")) arr[i] = true;
        }

        flag = false;
        DFS(0,true);

        flag = false;
        DFS(0,false);
    }

    static void DFS(int depth, boolean reverse){

        //종료 조건
        if(depth == K+1){
            for(int i =0; i<K+1; i++) System.out.print(answer[i]);
            System.out.println();
            flag = true;

            return;
        }

        // 반복 조건
        for(int l = 0, j =0; l<= 9; l++){
            if( reverse) j = 9 - l;
            else j = l;

            if(visit[j]) continue;
            if(flag) continue;

            if(depth == 0 ||
                    (arr[depth-1] && (answer[depth-1] > j) ) ||
                    ( (!arr[depth-1] && (answer[depth-1] < j))) ){

                visit[j] = true;

                answer[depth] = j;
                DFS(depth+1, reverse);

                visit[j] = false;
            }
        }

    }


}