import java.util.*;
import java.io.*;

/*

    DP + 역추적
        완전탐색 O(2^N)
        DP O(N^2)
        이분탐색 O(Nlog^N)
        투 포인터 O(N)
*/
class Main{

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] dy = new int[N+1];
        int [] arr = new int[N+1];
        int [] pre = new int[N+1];  // 어디서 왔는지 저장하는 배열

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        //가짜식 dy[i] : i가 제일 큰 수일 때, 가장 긴 증가하는 부분 수열의 길이
        //초기화
        dy[1] = 1;

        //점화식
        int answer = 0;
        int idx =0;
        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){

                if( arr[j] < arr[i] && dy[i] < dy[j]){
                    dy[i] = dy[j];
                    pre[i] = j;
                }
            }
            dy[i] += 1;

        //방법1
            //answer = Math.max(answer , dy[i]);

        //방법2
            if(answer <dy[i]){
                answer = dy[i];
                idx = i;
            }

        }


/* 정답  출력 */
        // [방법1] Stack 사용해서 출력하기
//        int val = answer;
//        Stack<Integer> stack = new Stack<>();
//
//        for(int i=N; i>=1; i--){
//            if( val == dy[i]) {
//                stack.push(arr[i]);
//                val--;
//            }
//        }
//
//        System.out.println(answer);
//
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop() + " ");
//        }


        // [방법2] pre[] 배열로 역순으로 출력하기
        stack = new Stack<>();
        while(true){
            stack.push(arr[idx]);
            idx = pre[idx];
            if( idx == 0) break;
        }

        System.out.println(answer);

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

//        //수열 출력
//        int[] result = new int[answer];
//        int i = result.length-1;
//        while(true){
//
//            if(idx ==0) break;
//
//            result[i] = arr[idx];
//            i--;
//
//            idx = pre[idx];
//        }
//
//        System.out.println(answer);
//        for(int v: result) System.out.print(v + " ");
    }
}