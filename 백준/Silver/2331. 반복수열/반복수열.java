import java.io.*;
import java.util.*;

// 구현
//    D = {57, 74, 65, 61, (37, 58, 89, 145, 42, 20, 4, 16), (37, 58,...)}
//    즉, 반복되지 않는 수열 {57, 74, 65, 61}, 4개가 정답
//    ArrayList에 계속 값을 추가하다가 ArrayList에 포함된 값이 있다면, 그 수의 인덱스 반환

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrList = new ArrayList<>();

        arrList.add(A);
        while(true){

            int tmp = arrList.get(arrList.size()-1);
            int sum = 0;

            // 각 자리별 P제곱 더함
            while( tmp > 0){

                sum += Math.pow( tmp % 10 , P);
                tmp = tmp / 10;
            }

            if(arrList.contains(sum)){
                System.out.println(arrList.indexOf(sum));
                break;
            }

            arrList.add(sum);
        }

    }
}