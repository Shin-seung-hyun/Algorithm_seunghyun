import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        long[]arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextLong();
        }

        Arrays.sort(arr); //22 3 666 77

        // mode: 최빈값
        // modeCnt: 최빈값의 등장 횟수
        // curCnt: 현재 값의 등장 횟수
        long mode = arr[0];
        int modeCnt = 0, curCnt = 0;

        for (int i = 1; i < N; i++) {

            // arr[i] 라는 숫자가 계속 등장하고 있면
            if (arr[i] == arr[i - 1]) {
                curCnt++;
            }

            // 숫자가 새롭게 등장했다면
            else curCnt = 1;

            if (curCnt > modeCnt) {
                modeCnt = curCnt;
                mode = arr[i];
            }
        }

        System.out.println(mode);
    }

}