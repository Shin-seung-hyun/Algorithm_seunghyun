import java.util.*;
import java.io.*;

// 투 포인터
// x^2 - y^2 = G 값 구하기
//(x+y)(x-y) = G
/// 즉 x의 최댓값은 x^2 - (x-1)^2 = G
/// (x+(x-1))(x-(x-1)) = 100_000
/// 2x = 100_001
/// x의 최댓값은 50_000
/// 시간복잡도: x와 y값 이분탐색 O(5만 log(5만))
/// 단, 계산의 최대 범위가 5만 * 5만 = 25억임으로 long 타입

public class Main {
    static int G;
    static int MAX = 100_000;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());

        //모든 제곱값 배열에 저장
//        powArray = new long[MAX+1];
//        for(int i =1; i<=MAX; i++){
//            powArray[i] = (long)Math.pow(i,2);
//            // i * i 의 경우 long 의 범위를 벗어나 음수가 나올 수 있음으로 Math.pow를 통해 double 타입을 반환하도록 해야함
//            //powArray[i] = i * i;
//        }

        twoPointer2();

        // 정렬
        Collections.sort(result);

        //출력
        if(result.isEmpty()) System.out.println(-1);
        else {
            for (int val : result) {
                System.out.println(val);
            }
        }

    }

    static void twoPointer(){
        int left = 1;
        int right = 1;

        while(true){

            //Math.pow return double
            int diff = (int) (Math.pow(right,2) - Math.pow(left,2));

            // 가장 가까운 두 수의 제곱의 차가 G보다 크면 그 이후로는 계속 커짐으로 G를 구할 수 없다.
            if(right -left == 1 && diff > G) break;

            if(diff == G){
                result.add(right);
            }

            if (diff > G) left++;
            else right++;   // diff <= G라면
        }
    }

    static void twoPointer2(){
        int left = 1;
        int right = 1;

        while(right <= MAX){

            //long diff = powArray[right] - powArray[left];
            int diff = (int) ((Math.pow(right,2)) - (Math.pow(left,2)));

            if(diff == G) result.add(right);

            if(diff > G) left++;
            else right++; // diff <= G라면
        }
    }


}