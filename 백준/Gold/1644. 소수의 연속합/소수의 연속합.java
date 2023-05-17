import java.util.*;
import java.io.*;

// 연속된 소수의 합 -> 투 포인터
// 연속된 소수의 합으로 나타내는 경우의 수
class Main{
    static int N;   // 자연수 N
    static boolean[] primeCheck;
    static ArrayList<Integer> primeNumber = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (br.readLine());

        N = Integer.parseInt(st.nextToken());
        primeCheck = new boolean[N + 1];
        Arrays.fill(primeCheck, true);

        // 소수 구하기
        getPrime();

        //연속합 구하기
        twoPointer();
    }

    static void getPrime(){

        // 방법1 에라토스테네스의 체 O(Nlog(log N))
            //k=2 부터 √N 이하까지 반복하여 k를 제외한 k의 배수들을 제외시킨다"
                //k = 2 이면 2 를 제외한 2의 배수를 모두 지워주고,
                //k = 3 이면 3 을 제외한 3의 배수를 모두 지워주고, k = √N 까지 반복

        /*
            소수이면 true
            소수가 아니면 false
        */
        for(int i =2; i<= Math.sqrt(N); i++){
            if(!primeCheck[i]) continue;

            //i의 배수 false로 만들기
            for(int j = i * i; j <= N; j = j+i){
                primeCheck[j] = false;
            }

        }

        //primeNumber에 소수 넣기
        for(int i =2; i<=N; i++){
            if(primeCheck[i]) primeNumber.add(i);
        }

    }
    static void twoPointer() {

        if(N ==1){
            System.out.println(0);
            return;
        }

        // 방법1
//        int right = 1;
//        int sum = 0;
//        int cnt = 0;
//
//        for(int left = 0; left < primeNumber.size(); left++){
//
//            while(sum < N && right < primeNumber.size()){
//
//                sum = sum + primeNumber.get(right);
//                right++;
//            }
//
//            if(sum >= N){
//                if(sum == N) cnt++;
//                sum = sum - primeNumber.get(left);
//            }
//
//        }

        //방법2.
        int left = 0, right = 0, cnt = 0;
        int sum = primeNumber.get(right);

        while(true){
            if(sum >=N){
                if( sum ==N) cnt++;

                sum -= primeNumber.get(left);
                left++;
            }
            else{
                right++;
                if(right == primeNumber.size()) break;
                sum += primeNumber.get(right);
            }
        }

        //출력
        System.out.println(cnt);
    }

}