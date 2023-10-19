import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean []check = new boolean[10_000 +1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        //소수 판별 시작
        init();

        for(int t=0; t<testCase; t++){
            st = new StringTokenizer(br.readLine());

            int tNum = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String answer = "";

            //소수
            if(check[m]){

                //행복한 수 인지 확인
                if( happyNum(String.valueOf(m))){
                    answer = "YES";
                }
                else answer = "NO";
            }
            else answer = "NO";

            sb.append(tNum + " " + m + " " + answer + "\n");
        }

        System.out.print(sb.toString());
    }
    static void init(){
        // 소수 판별 알고리즘 https://st-lab.tistory.com/80
        // 소수인경우 true, 아닌경우 false

        Arrays.fill(check, true);

        check[0] = false;
        check[1] = false;

        // 1. 에라토스테네스의 체 : 시간 복잡도 O(N ㏒ (㏒ N))
        for(int i = 2; i<= Math.sqrt(10_000); i++){

            if(!check[i]) continue;

            for(int j = i * i; j<=10_000; j= j+i){
                check[j] = false;
            }
        }

        // 2. 제곱근 활용 : 시간 복잡도 O(N√N)
        for(int i =2; i<=10_000; i++){

            for(int j = 2; j<= Math.sqrt(i); j++){
                if( i%j == 0){
                    check[i] = false;
                    break;
                }
            }
        }

    }

    static boolean happyNum(String num){

        HashSet<Integer> hashSet = new HashSet<>();

        // 같은 수가 반복될 때까지 연산
        while(true){
            int sum = 0;
            for(int i=0; i< num.length(); i++){
                sum += Math.pow(Integer.parseInt(String.valueOf(num.charAt(i))),2);
            }

            //1이 되는지 확인
            if(sum == 1){
                return true;
            }

            //중복 사이클 확인
            if( hashSet.contains(sum)) break;
            else hashSet.add(sum);

            num = String.valueOf(sum);
        }

        return false;
    }
}